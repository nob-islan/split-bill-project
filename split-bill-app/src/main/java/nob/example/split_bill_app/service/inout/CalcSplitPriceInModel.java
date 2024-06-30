package nob.example.split_bill_app.service.inout;

import java.util.List;

import lombok.Data;
import nob.example.split_bill_app.dto.MemberInputInfoDto;

/**
 * 割り勘価格計算処理のinModelです。
 * 
 * @author nob
 */
@Data
public class CalcSplitPriceInModel {

    /**
     * メンバーの入力情報リスト
     */
    private List<MemberInputInfoDto> memberInputInfoDtoList;

    /**
     * 合計価格
     */
    private Integer totalPrice;
}
