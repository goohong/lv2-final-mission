package finalmission.client;

import java.net.URI;
import org.springframework.web.client.RestClient;

public class RandommerClient {
    private final RestClient.Builder client;

    public RandommerClient(final RestClient.Builder client) {
        this.client = client;
    }

    public String getRandomName() {
        //TODO: 미완
        return client.build()
                .get()
                .uri(URI.create("/Name"))
                .retrieve()
                .body(String.class);
    }
}
