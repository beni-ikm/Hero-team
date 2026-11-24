package runtime.shared.api;

import jakarta.ws.rs.core.HttpHeaders;

public final class AuthExtractor {

    private AuthExtractor() {}

    public static String requirePlayerId(HttpHeaders headers, TokenAuthenticator authenticator) {
        String authHeader = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ApiException(401, "NOT_AUTHENTICATED", "Authentification required.");
        }
        String token = authHeader.substring("Bearer ".length()).trim();
        if (token.isEmpty()) {
            throw new ApiException(401, "NOT_AUTHENTICATED", "Missing or invalid token.");
        }
        return authenticator.authenticateBearerToken(token)
                .orElseThrow(() -> new ApiException(401, "NOT_AUTHENTICATED", "Invalid token"));
    }
}