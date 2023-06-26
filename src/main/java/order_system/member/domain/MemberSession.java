package order_system.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSession implements Serializable {

    private Long memberId;

    @Builder
    private MemberSession(final long memberId) {
        this.memberId = memberId;
    }
}
