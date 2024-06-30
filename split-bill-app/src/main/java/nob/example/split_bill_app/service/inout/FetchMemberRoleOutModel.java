package nob.example.split_bill_app.service.inout;

import java.util.List;

import lombok.Data;
import nob.example.split_bill_app.dto.MemberRoleDto;

/**
 * 役職情報取得処理のoutModelです。
 * 
 * @author nob
 */
@Data
public class FetchMemberRoleOutModel {

    /**
     * 役職情報のリスト
     */
    List<MemberRoleDto> memberRoleDtoList;
}
