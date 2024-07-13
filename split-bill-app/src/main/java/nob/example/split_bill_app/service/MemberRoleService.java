package nob.example.split_bill_app.service;

import org.springframework.stereotype.Service;

import nob.example.split_bill_app.service.inout.FetchMemberRoleOutModel;

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
}
