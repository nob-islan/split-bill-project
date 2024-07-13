package nob.example.split_bill_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import nob.example.split_bill_app.constant.UrlConstant;
import nob.example.split_bill_app.controller.reqres.FetchMemberRoleResponse;
import nob.example.split_bill_app.controller.reqres.RegistMemberRoleRequest;
import nob.example.split_bill_app.controller.reqres.RegistMemberRoleResponse;

/**
 * 役職およびその重みづけ値に関するコントローラインターフェースです。
 * 
 * @author nob
 */
@RestController
@RequestMapping(value = UrlConstant.API_BASE + UrlConstant.MEMBER_ROLE)
@Tag(name = "Member role", description = "役職に関するAPIです。")
public interface MemberRoleController {

    /**
     * 役職情報を取得します。
     * 
     * @return 役職情報のリスト
     */
    @GetMapping(value = "/fetch")
    @Operation(summary = "役職情報の取得", description = "${sampleapidoc.describe.member-role.fetch:説明文}")
    FetchMemberRoleResponse fetchMemberRole();

    /**
     * 役職情報を登録します。
     * 
     * @param registMemberRoleRequest 役職情報登録リクエスト
     * @return 実行結果
     */
    @PostMapping(value = "/regist")
    @Operation(summary = "役職情報の登録", description = "${sampleapidoc.describe.member-role.regist:説明文}")
    RegistMemberRoleResponse registMemberRole(RegistMemberRoleRequest registMemberRoleRequest);
}
