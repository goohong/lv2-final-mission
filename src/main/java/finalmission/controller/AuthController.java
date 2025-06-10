package finalmission.controller;

import finalmission.dto.request.MemberCreateRequest;
import finalmission.dto.request.MemberSignupRequest;
import finalmission.dto.response.MemberResponse;
import finalmission.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final MemberService memberService;

    public AuthController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberSignupRequest request) {
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(request.name(), request.email(),
                request.password());
        return ResponseEntity.ok(memberService.create(memberCreateRequest));
    }
}
