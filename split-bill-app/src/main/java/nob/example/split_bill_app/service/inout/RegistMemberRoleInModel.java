package nob.example.split_bill_app.service.inout;

import lombok.Data;

/**
 * 役職情報登録処理のinModelです。
 * 
 * @author nob
 */
@Data
public class RegistMemberRoleInModel {

    /**
     * 役職名
     */
    private String roleName;

    /**
     * 重みづけ値
     */
    private Integer weightingValue;
}
