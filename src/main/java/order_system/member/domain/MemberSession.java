package order_system.member.domain;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static order_system.global.constant.SessionConstant.MEMBER_SESSION;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSession implements Serializable {

    private Long memberId;

    @Builder
    private MemberSession(final long memberId) {
        this.memberId = memberId;
    }

    public void makeSession(final HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(MEMBER_SESSION.value, this);
    }
}
