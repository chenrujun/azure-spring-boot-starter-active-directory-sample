package chenrujun.azure.spring.boot.starter.active.directory.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/graph")
    public String graph(
        @RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient oAuth2AuthorizedClient
    ) {
        logAuthorizedClient(oAuth2AuthorizedClient);
        return "graph";

    }

    @GetMapping("/arm")
    public String arm(
        @RegisteredOAuth2AuthorizedClient("arm") OAuth2AuthorizedClient oAuth2AuthorizedClient
    ) {
        logAuthorizedClient(oAuth2AuthorizedClient);
        return "arm";

    }

    static void logAuthorizedClient(OAuth2AuthorizedClient authorizedClient) {
        LOGGER.info(
            "principalName = {} ---------------------------",
            authorizedClient.getPrincipalName()
        );
        LOGGER.info(
            "clientName = {}",
            Optional.of(authorizedClient)
                    .map(OAuth2AuthorizedClient::getClientRegistration)
                    .map(ClientRegistration::getClientName)
                    .orElse(null)
        );
        LOGGER.info(
            "accessTokenIssuedAt = {}",
            Optional.of(authorizedClient)
                    .map(OAuth2AuthorizedClient::getAccessToken)
                    .map(AbstractOAuth2Token::getIssuedAt)
                    .orElse(null)
        );
        LOGGER.info(
            "accessTokenExpiresAt = {}",
            Optional.of(authorizedClient)
                    .map(OAuth2AuthorizedClient::getAccessToken)
                    .map(AbstractOAuth2Token::getExpiresAt)
                    .orElse(null)
        );
        LOGGER.info(
            "refreshTokenIssuedAt = {}",
            Optional.of(authorizedClient)
                    .map(OAuth2AuthorizedClient::getRefreshToken)
                    .map(AbstractOAuth2Token::getIssuedAt)
                    .orElse(null)
        );
        LOGGER.info(
            "refreshTokenExpiresAt = {}",
            Optional.of(authorizedClient)
                    .map(OAuth2AuthorizedClient::getRefreshToken)
                    .map(AbstractOAuth2Token::getExpiresAt)
                    .orElse(null)
        );
    }
}
