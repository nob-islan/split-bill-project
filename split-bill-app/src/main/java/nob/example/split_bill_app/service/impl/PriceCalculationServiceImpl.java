package nob.example.split_bill_app.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nob.example.split_bill_app.dto.MemberInputInfoDto;
import nob.example.split_bill_app.dto.MemberOutputInfoDto;
import nob.example.split_bill_app.repository.MemberRoleRepository;
import nob.example.split_bill_app.repository.entity.MemberRole;
import nob.example.split_bill_app.service.PriceCalculationService;
import nob.example.split_bill_app.service.inout.CalcSplitPriceInModel;
import nob.example.split_bill_app.service.inout.CalcSplitPriceOutModel;

/**
 * 価格計算に関するサービス実装クラスです。
 * 
 * @author nob
 */
@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    private static final Integer DISCOUNT_PRICE = 100;

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CalcSplitPriceOutModel calcSplitPrice(CalcSplitPriceInModel calcSplitPriceInModel) {

        // 役職情報を取得
        List<MemberRole> memberRoleList = memberRoleRepository.findAll();

        // 役職名から重みづけ値を取得するマップを作成
        Map<String, Integer> memberRoleWeightingValueMap = new HashMap<String, Integer>();
        for (MemberRole memberRole : memberRoleList) {
            memberRoleWeightingValueMap.put(memberRole.getRoleName(), memberRole.getWeightingValue());
        }

        // 正規化用の値を計算
        Integer normalizationValue = 0;
        for (MemberInputInfoDto memberInputInfoDto : calcSplitPriceInModel.getMemberInputInfoDtoList()) {
            normalizationValue = normalizationValue
                    + memberRoleWeightingValueMap.get(memberInputInfoDto.getMemberRole());
        }

        // 正規化用の値で合計価格を割り、割り勘価格計算用の単位価格を計算
        Integer unitPrice = calcSplitPriceInModel.getTotalPrice() / normalizationValue;

        // 返却値の作成
        List<MemberOutputInfoDto> memberOutputInfoDtoList = new ArrayList<MemberOutputInfoDto>();
        // 各人の割り勘価格を計算（百の位で切り上げ）
        for (MemberInputInfoDto memberInputInfoDto : calcSplitPriceInModel.getMemberInputInfoDtoList()) {
            Integer memberWeightingValue = memberRoleWeightingValueMap.get(memberInputInfoDto.getMemberRole());
            Integer memberPrice = new BigDecimal(memberWeightingValue * unitPrice).setScale(-2, RoundingMode.UP)
                    .intValue();
            MemberOutputInfoDto memberOutputInfoDto = new MemberOutputInfoDto();
            memberOutputInfoDto.setMemberName(memberInputInfoDto.getMemberName());
            memberOutputInfoDto.setMemberPrice(memberPrice);
            memberOutputInfoDtoList.add(memberOutputInfoDto);
        }

        // 各人の割引価格の和を計算
        Integer totalMemberPrice = 0;
        for (MemberOutputInfoDto memberOutputInfoDto : memberOutputInfoDtoList) {
            totalMemberPrice = totalMemberPrice + memberOutputInfoDto.getMemberPrice();
        }
        // 各人の割り勘価格の和がtotalPriceを超えている限り、割り勘価格が高い人の価格を100円割り引く
        Comparator comparator = Comparator.comparing(MemberOutputInfoDto::getMemberPrice); // ソート条件作成
        while (calcSplitPriceInModel.getTotalPrice() < totalMemberPrice) {
            memberOutputInfoDtoList = (List<MemberOutputInfoDto>) memberOutputInfoDtoList
                    .stream().sorted(comparator.reversed()).collect(Collectors.toList()); // ソート済みリスト作成
            // 0番目（最も割り勘価格が高い人）について100円割り引く
            MemberOutputInfoDto toModifyMemberOutputInfoDto = memberOutputInfoDtoList.get(0);
            toModifyMemberOutputInfoDto.setMemberPrice(toModifyMemberOutputInfoDto.getMemberPrice() - DISCOUNT_PRICE);
            memberOutputInfoDtoList.set(0, toModifyMemberOutputInfoDto);
            // 各人の割引価格の和からも100円を引く
            totalMemberPrice = totalMemberPrice - DISCOUNT_PRICE;
        }

        // 返却値を作成
        CalcSplitPriceOutModel calcSplitPriceOutModel = new CalcSplitPriceOutModel();
        calcSplitPriceOutModel.setMemberOutputInfoDtoList(memberOutputInfoDtoList);

        return calcSplitPriceOutModel;
    }
}
