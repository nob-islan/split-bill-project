package nob.example.split_bill_app.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import nob.example.split_bill_app.controller.MemberRoleController;
import nob.example.split_bill_app.controller.reqres.FetchMemberRoleResponse;
import nob.example.split_bill_app.service.MemberRoleService;
import nob.example.split_bill_app.service.inout.FetchMemberRoleOutModel;

/**
 * 役職およびその重みづけ値に関するコントローラ実装クラスです。
 * 
 * @author nob
 */
@RestController
public class MemberRoleControllerImpl implements MemberRoleController {

    @Autowired
    private MemberRoleService memberRoleService;

    @Override
    public FetchMemberRoleResponse fetchMemberRole() {

        // サービス呼び出し
        FetchMemberRoleOutModel fetchMemberRoleOutModel = memberRoleService.fetchMemberOutModel();
        // 返却値の作成
        FetchMemberRoleResponse fetchMemberRoleResponse = new FetchMemberRoleResponse();
        BeanUtils.copyProperties(fetchMemberRoleOutModel, fetchMemberRoleResponse);

        return fetchMemberRoleResponse;
    }
}
