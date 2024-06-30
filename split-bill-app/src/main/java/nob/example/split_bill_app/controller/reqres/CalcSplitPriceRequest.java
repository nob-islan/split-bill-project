package nob.example.split_bill_app.controller.reqres;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import nob.example.split_bill_app.dto.MemberInputInfoDto;

/**
 * 割り勘価格計算処理のリクエストです。
 * 
 * @author nob
 */
@Data
@Schema(description = "割り勘価格計算処理のリクエスト", type = "object")
public class CalcSplitPriceRequest {

    /**
     * メンバーの入力情報リスト
     */
    @Schema(description = "メンバーの入力情報リスト", type = "object")
    private List<MemberInputInfoDto> memberInputInfoDtoList;

    /**
     * 合計価格
     */
    @Schema(description = "合計価格", type = "integer", example = "13000")
    private Integer totalPrice;
}
