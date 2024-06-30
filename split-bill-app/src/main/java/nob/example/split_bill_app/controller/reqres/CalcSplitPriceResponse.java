package nob.example.split_bill_app.controller.reqres;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import nob.example.split_bill_app.dto.MemberOutputInfoDto;

/**
 * 割り勘価格計算処理のレスポンスです。
 * 
 * @author nob
 */
@Data
@Schema(description = "割り勘価格計算処理のレスポンス", type = "object")
public class CalcSplitPriceResponse {

    /**
     * メンバーの出力情報リスト
     */
    @Schema(description = "メンバーの出力情報リスト", type = "object")
    private List<MemberOutputInfoDto> memberOutputInfoDtoList;
}
