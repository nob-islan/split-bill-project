package nob.example.split_bill_app.service.inout;

import java.util.List;

import lombok.Data;
import nob.example.split_bill_app.dto.MemberOutputInfoDto;

/**
 * 割り勘価格計算処理のoutModelです。
 * 
 * @author nob
 */
@Data
public class CalcSplitPriceOutModel {

    /**
     * メンバーの出力情報リスト
     */
    private List<MemberOutputInfoDto> memberOutputInfoDtoList;
}
