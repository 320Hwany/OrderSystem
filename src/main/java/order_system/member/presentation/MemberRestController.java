package order_system.member.presentation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import order_system.global.annotation.Login;
import order_system.member.application.command.CommandSignupService;
import order_system.member.application.query.QueryByMemberIdService;
import order_system.member.application.query.QueryLoginService;
import order_system.member.domain.Member;
import order_system.member.domain.MemberSession;
import order_system.member.mapper.MemberMapper;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.mapper.dto.MemberResponseDto;
import order_system.member.mapper.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class MemberRestController {

    private final CommandSignupService commandSignupService;
    private final QueryLoginService queryLoginService;
    private final QueryByMemberIdService queryByMemberIdService;

    public MemberRestController(final CommandSignupService commandSignupService,
                                final QueryLoginService queryLoginService,
                                final QueryByMemberIdService queryByMemberIdService) {
        this.commandSignupService = commandSignupService;
        this.queryLoginService = queryLoginService;
        this.queryByMemberIdService = queryByMemberIdService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid final SignupRequestDto dto) {
        commandSignupService.command(dto);
    }

    @PostMapping("/login")
    public MemberResponseDto login(@RequestBody @Valid final LoginRequestDto dto,
                                   HttpServletRequest request) {
        Member member = queryLoginService.query(dto, request);
        return MemberMapper.toResponseDto(member);
    }

    @GetMapping("/member")
    public MemberResponseDto get(@Login final MemberSession memberSession) {
        Member member = queryByMemberIdService.query(memberSession.getMemberId());
        return MemberMapper.toResponseDto(member);
    }
}
