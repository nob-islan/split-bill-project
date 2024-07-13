package nob.example.split_bill_app.controller.reqres;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 役職情報登録処理のリクエストです。
 * 
 * @author nob
 */
@Data
@Schema(description = "役職情報登録処理のリクエスト", type = "object")
public class RegistMemberRoleRequest {

    /**
     * 役職名
     */
    @Schema(description = "役職名", type = "string", example = "部長")
    private String roleName;

    /**
     * 重みづけ値
     */
    @Schema(description = "ユーザID", type = "integer", example = "5")
    private Integer weightingValue;
}
