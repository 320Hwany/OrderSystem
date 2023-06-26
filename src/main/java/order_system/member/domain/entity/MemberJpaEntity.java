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

    private String password;

    private String state;

    private String city;

    private String district;

    private String detailedAddress;

    @Builder
    private MemberJpaEntity(final String username, final String password, final String state,
                            final String city, final String district, final String detailedAddress) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.city = city;
        this.district = district;
        this.detailedAddress = detailedAddress;
    }
}
