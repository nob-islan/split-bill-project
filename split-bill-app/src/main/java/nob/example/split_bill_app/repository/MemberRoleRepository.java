package nob.example.split_bill_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nob.example.split_bill_app.repository.entity.MemberRole;

/**
 * member_roleテーブル向けのrepositoryインターフェースです。
 * 
 * @author nob
 */
@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, String> {

}
