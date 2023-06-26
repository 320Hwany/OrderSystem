package order_system.member.presentation;

import order_system.member.application.command.CommandSignupService;
import order_system.member.mapper.dto.SignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class MemberRestController {

    private final CommandSignupService commandSignupService;

    public MemberRestController(final CommandSignupService commandSignupService) {
        this.commandSignupService = commandSignupService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody final SignupRequestDto dto) {
        commandSignupService.command(dto);
    }
}
