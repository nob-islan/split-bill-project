package nob.example.split_bill_app.controller.reqres;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 役職情報登録処理のレスポンスです。
 * 
 * @author nob
 */
@Data
@Schema(description = "役職情報登録処理のレスポンス", type = "object")
public class RegistMemberRoleResponse {

    /**
     * 実行結果
     */
    @Schema(description = "実行結果", type = "string", example = "success")
    private String result;
}
