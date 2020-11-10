package chenrujun.azure.spring.boot.starter.active.directory.sample;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(@RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient client) {
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append("\r\n");
        builder.append("access token: " + client.getAccessToken().getTokenValue());
        builder.append("\r\n");
        builder.append("refresh token: " + client.getRefreshToken().getTokenValue());
        builder.append("\r\n");

        return  builder.toString();
    }
}
