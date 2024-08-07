package nob.example.split_bill_app.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import nob.example.split_bill_app.controller.MemberRoleController;
import nob.example.split_bill_app.controller.reqres.FetchMemberRoleResponse;
import nob.example.split_bill_app.controller.reqres.RegistMemberRoleRequest;
import nob.example.split_bill_app.controller.reqres.RegistMemberRoleResponse;
import nob.example.split_bill_app.service.MemberRoleService;
import nob.example.split_bill_app.service.inout.FetchMemberRoleOutModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleInModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleOutModel;

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
        FetchMemberRoleOutModel fetchMemberRoleOutModel = memberRoleService.fetchMemberRole();
        // 返却値の作成
        FetchMemberRoleResponse fetchMemberRoleResponse = new FetchMemberRoleResponse();
        BeanUtils.copyProperties(fetchMemberRoleOutModel, fetchMemberRoleResponse);

        return fetchMemberRoleResponse;
    }

    @Override
    public RegistMemberRoleResponse registMemberRole(RegistMemberRoleRequest registMemberRoleRequest) {

        // サービス向けのリクエストを作成
        RegistMemberRoleInModel registMemberRoleInModel = new RegistMemberRoleInModel();
        BeanUtils.copyProperties(registMemberRoleRequest, registMemberRoleInModel);

        // サービス呼び出し
        RegistMemberRoleOutModel registMemberRoleOutModel = memberRoleService.registMemberRole(registMemberRoleInModel);

        // 返却値の作成
        RegistMemberRoleResponse registMemberRoleResponse = new RegistMemberRoleResponse();
        registMemberRoleResponse.setResult(registMemberRoleOutModel.getResult());

        return registMemberRoleResponse;
    }
}
