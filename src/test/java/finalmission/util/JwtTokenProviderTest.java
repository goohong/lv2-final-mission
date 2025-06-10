package finalmission.util;

import static org.assertj.core.api.Assertions.assertThat;

import finalmission.TestFixture;
import finalmission.domain.Member;
import finalmission.domain.Role;
import finalmission.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class JwtTokenProviderTest {

    @Autowired
    private MemberRepository memberRepository;
    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=", 3600000);
    }

    @Test
    void createAndParseToken() {
        Member savedMember = memberRepository.save(TestFixture.memberCreateRequest.toDomain());
        String token = jwtTokenProvider.createToken(savedMember);

        assertThat(token).isNotNull();
        assertThat(token).isNotEmpty();

        Long id = jwtTokenProvider.extractId(token);
        Role role = jwtTokenProvider.extractRole(token);

        assertThat(id).isEqualTo(savedMember.getId());
        assertThat(role).isEqualTo(savedMember.getRole());
    }
}
