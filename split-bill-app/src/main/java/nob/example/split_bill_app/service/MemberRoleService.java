package nob.example.split_bill_app.service;

import org.springframework.stereotype.Service;

import nob.example.split_bill_app.service.inout.FetchMemberRoleOutModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleInModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleOutModel;

/**
 * 役職およびその重みづけ値に関するサービスインターフェースです。
 * 
 * @author nob
 */
@Service
public interface MemberRoleService {

    /**
     * 役職情報を取得します。
     * 
     * @return 役職情報のリスト
     */
    FetchMemberRoleOutModel fetchMemberRole();

    /**
     * 役職情報を登録します。
     * 
     * @param registMemberRoleInModel 役職情報
     * @return 実行結果
     */
    RegistMemberRoleOutModel registMemberRole(RegistMemberRoleInModel registMemberRoleInModel);
}
