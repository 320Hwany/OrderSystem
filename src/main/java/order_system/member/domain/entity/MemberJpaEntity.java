package order_system.member.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@Entity
public class MemberJpaEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    String state;

    String city;

    String district;

    @Builder
    private MemberJpaEntity(String username, String state, String city, String district) {
        this.username = username;
        this.state = state;
        this.city = city;
        this.district = district;
    }
}
