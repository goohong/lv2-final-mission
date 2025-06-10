package finalmission.config;

import finalmission.domain.Member;
import finalmission.dto.LoginInfo;
import finalmission.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import finalmission.util.JwtTokenProvider;

@Component
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {
    private final JwtTokenProvider tokenProvider;
    private final MemberService memberService;

    public AuthenticationArgumentResolver(final JwtTokenProvider tokenProvider, final MemberService memberService) {
        this.tokenProvider = tokenProvider;
        this.memberService = memberService;
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.getParameterType().equals(LoginInfo.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer,
                                  final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory)
            throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        Cookie[] cookies = request.getCookies();
        String token = tokenProvider.extractTokenFromCookie(cookies);
        Long memberId = tokenProvider.extractId(token);
        Member member = memberService.find(memberId);

        return LoginInfo.from(member);
    }
}
