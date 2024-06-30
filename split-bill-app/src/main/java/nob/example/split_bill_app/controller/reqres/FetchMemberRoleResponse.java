package nob.example.split_bill_app.controller.reqres;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import nob.example.split_bill_app.dto.MemberRoleDto;

/**
 * 役職情報取得処理のresponseです。
 * 
 * @author nob
 */
@Data
@Schema(description = "役職情報取得処理のレスポンス", type = "object")
public class FetchMemberRoleResponse {

    /**
     * 役職情報のリスト
     */
    @Schema(description = "役職情報のリスト", type = "object")
    List<MemberRoleDto> memberRoleDtoList;
}
