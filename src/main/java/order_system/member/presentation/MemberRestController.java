package order_system.member.presentation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import order_system.member.application.command.CommandSignupService;
import order_system.member.application.query.QueryLoginService;
import order_system.member.domain.Member;
import order_system.member.mapper.MemberMapper;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.mapper.dto.MemberResponseDto;
import order_system.member.mapper.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class MemberRestController {

    private final CommandSignupService commandSignupService;
    private final QueryLoginService queryLoginService;

    public MemberRestController(final CommandSignupService commandSignupService,
                                final QueryLoginService queryLoginService) {
        this.commandSignupService = commandSignupService;
        this.queryLoginService = queryLoginService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid final SignupRequestDto dto) {
        commandSignupService.command(dto);
    }

    @PostMapping("/login")
    public MemberResponseDto login(@RequestBody @Valid LoginRequestDto dto,
                                   HttpServletRequest request) {
        Member member = queryLoginService.query(dto, request);
        return MemberMapper.toResponseDto(member);
    }
}
