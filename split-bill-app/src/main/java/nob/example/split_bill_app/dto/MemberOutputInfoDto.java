package nob.example.split_bill_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * メンバーの出力情報を格納するdtoです。
 * 
 * @author nob
 */
@Data
@Schema(description = "メンバーの出力情報を格納するdto", type = "object")
public class MemberOutputInfoDto {

    /**
     * メンバーの名前
     */
    @Schema(description = "メンバーの名前", type = "string", example = "nob")
    private String memberName;

    /**
     * 割り勘価格
     */
    @Schema(description = "割り勘価格", type = "string", example = "65000")
    private String memberPrice;
}
