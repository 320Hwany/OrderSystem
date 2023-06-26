package order_system.global.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import order_system.member.domain.MemberSession;
import order_system.member.exception.SessionNotFoundException;
import order_system.member.repository.MemberRepository;
import org.springframework.web.servlet.HandlerInterceptor;

import static order_system.global.constant.SessionConstant.*;

public class LoginInterceptor implements HandlerInterceptor {

    private final MemberRepository memberRepository;

    public LoginInterceptor(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new SessionNotFoundException();
        }
        MemberSession memberSession = (MemberSession) session.getAttribute(MEMBER_SESSION.value);
        memberRepository.getById(memberSession.getMemberId());
        request.setAttribute(MEMBER_SESSION.value, memberSession);

        return true;
    }
}
