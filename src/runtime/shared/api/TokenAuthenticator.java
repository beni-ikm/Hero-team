package runtime.shared.api;

import java.util.Optional;

public interface TokenAuthenticator {
    Optional<String> authenticateBearerToken(String authorizationHeader);
}