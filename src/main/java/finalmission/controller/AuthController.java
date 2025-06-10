package finalmission.controller;

import finalmission.domain.Member;
import finalmission.dto.LoginInfo;
import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.request.MemberSignupRequest;
import finalmission.dto.response.MemberResponse;
import finalmission.service.MemberService;
import finalmission.util.JwtTokenProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(final MemberService memberService, final JwtTokenProvider jwtTokenProvider) {
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberSignupRequest request) {
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(request.name(), request.email(),
                request.password(), request.role());
        return ResponseEntity.ok(memberService.create(memberCreateRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(LoginInfo loginInfo, HttpServletResponse response) {
        Long id = loginInfo.id();
        Member member = memberService.find(id);
        String token = jwtTokenProvider.createToken(member);
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }
}
