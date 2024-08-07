package nob.example.split_bill_app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nob.example.split_bill_app.constant.ApiResultConstant;
import nob.example.split_bill_app.dto.MemberRoleDto;
import nob.example.split_bill_app.repository.MemberRoleRepository;
import nob.example.split_bill_app.repository.entity.MemberRole;
import nob.example.split_bill_app.service.MemberRoleService;
import nob.example.split_bill_app.service.inout.FetchMemberRoleOutModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleInModel;
import nob.example.split_bill_app.service.inout.RegistMemberRoleOutModel;

/**
 * 役職およびその重みづけ値に関するサービス実装クラスです。
 * 
 * @author nob
 */
@Service
public class MemberRoleServiceImpl implements MemberRoleService {

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Override
    public FetchMemberRoleOutModel fetchMemberRole() {

        // repository呼び出し
        List<MemberRole> memberRoleList = memberRoleRepository.findAll();

        // 返却値の作成
        FetchMemberRoleOutModel fetchMemberRoleOutModel = new FetchMemberRoleOutModel();
        List<MemberRoleDto> memberRoleDtoList = new ArrayList<MemberRoleDto>();
        // エンティティからdtoに値を詰め替え
        for (MemberRole memberRole : memberRoleList) {
            MemberRoleDto memberRoleDto = new MemberRoleDto();
            BeanUtils.copyProperties(memberRole, memberRoleDto);
            memberRoleDtoList.add(memberRoleDto);
        }
        fetchMemberRoleOutModel.setMemberRoleDtoList(memberRoleDtoList);

        return fetchMemberRoleOutModel;
    }

    @Override
    public RegistMemberRoleOutModel registMemberRole(RegistMemberRoleInModel registMemberRoleInModel) {

        // repository向けのリクエスト作成
        MemberRole memberRole = new MemberRole();
        BeanUtils.copyProperties(registMemberRoleInModel, memberRole);

        // repository呼び出し
        memberRoleRepository.save(memberRole);

        // 返却値の作成
        RegistMemberRoleOutModel registMemberRoleOutModel = new RegistMemberRoleOutModel();
        registMemberRoleOutModel.setResult(ApiResultConstant.SUCCESS);

        return registMemberRoleOutModel;
    }
}
