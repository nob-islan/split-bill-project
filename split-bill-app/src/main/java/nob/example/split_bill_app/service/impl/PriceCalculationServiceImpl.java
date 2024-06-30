package nob.example.split_bill_app.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Override
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
        CalcSplitPriceOutModel calcSplitPriceOutModel = new CalcSplitPriceOutModel();
        List<MemberOutputInfoDto> memberOutputInfoDtoList = new ArrayList<MemberOutputInfoDto>();
        // 各人の割り勘価格を計算（百の位で切り上げ）
        for (MemberInputInfoDto memberInputInfoDto : calcSplitPriceInModel.getMemberInputInfoDtoList()) {
            Integer memberWeightingValue = memberRoleWeightingValueMap.get(memberInputInfoDto.getMemberRole());
            Integer memberPrice = new BigDecimal(memberWeightingValue * unitPrice).setScale(-2, RoundingMode.UP)
                    .intValue();
            MemberOutputInfoDto memberOutputInfoDto = new MemberOutputInfoDto();
            memberOutputInfoDto.setMemberName(memberInputInfoDto.getMemberName());
            memberOutputInfoDto.setMemberPrice(String.valueOf(memberPrice));
            memberOutputInfoDtoList.add(memberOutputInfoDto);
        }
        calcSplitPriceOutModel.setMemberOutputInfoDtoList(memberOutputInfoDtoList);

        // TODO はみ出した価格の調整ロジック

        return calcSplitPriceOutModel;
    }
}
