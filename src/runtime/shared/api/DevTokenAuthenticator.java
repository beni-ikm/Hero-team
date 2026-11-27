package runtime.shared.api;

import java.util.Optional;

public class DevTokenAuthenticator implements TokenAuthenticator {

    // TODO(J2): Replace DevTokenAuthenticator with real session/token validation

    @Override
    public Optional<String> authenticateBearerToken(String token) {
        if (token == null || token.isBlank()) {
            return Optional.empty();
        }
        if (token.startsWith("token-")) {
            return Optional.of(token.substring("token-".length()));
        }
        return Optional.of("p-7f3a");
    }
}