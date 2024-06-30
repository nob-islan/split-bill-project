package nob.example.split_bill_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 役職に関する情報を格納するdtoです。
 * 
 * @author nob
 */
@Data
@Schema(description = "役職に関する情報を格納するdto", type = "object")
public class MemberRoleDto {

    /**
     * ID
     */
    @Schema(description = "ID", type = "integer", example = "1")
    private Integer id;

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
