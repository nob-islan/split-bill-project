package nob.example.split_bill_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * メンバーの入力情報を格納するdtoです。
 * 
 * @author nob
 */
@Data
@Schema(description = "メンバーの入力情報を格納するdto", type = "object")
public class MemberInputInfoDto {

    /**
     * メンバーの名前
     */
    @Schema(description = "メンバーの名前", type = "string", example = "nob")
    private String memberName;

    /**
     * 役職名
     */
    @Schema(description = "役職名", type = "string", example = "部長")
    private String memberRole;
}
