package nob.example.split_bill_app.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * member_roleテーブル向けのエンティティクラスです。
 * 
 * @author nob
 */
@Table(name = "member_role")
@Entity
@Data
public class MemberRole {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "PRIMARY KEY", length = 11, nullable = false)
    private Integer id;

    /**
     * 役職名
     */
    @Column(name = "role_name", length = 8, nullable = false)
    private String roleName;

    /**
     * 重みづけ値
     */
    @Column(name = "weighting_value", length = 11, nullable = false)
    private Integer weightingValue;
}
