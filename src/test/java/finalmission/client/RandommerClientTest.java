package finalmission.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RandommerClientTest {

    @Autowired
    private RandommerClient randommerClient;

    @Test
    void getSingleRandomName() {
        String randomName = randommerClient.getSingleRandomName();

        assertThat(randomName).isNotEmpty();
    }
}
