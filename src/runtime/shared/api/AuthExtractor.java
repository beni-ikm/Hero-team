package runtime.shared.api;

import jakarta.ws.rs.core.HttpHeaders;

public final class AuthExtractor {

    private AuthExtractor() {}

    public static String requirePlayerId(HttpHeaders headers, TokenAuthenticator authenticator) {
        String authHeader = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ApiException(401, "NOT_AUTHENTICATED", "Authentification requise.");
        }
        String token = authHeader.substring("Bearer ".length()).trim();
        if (token.isEmpty()) {
            throw new ApiException(401, "NOT_AUTHENTICATED", "Jeton manquant ou invalide.");
        }
        return authenticator.authenticateBearerToken(token)
                .orElseThrow(() -> new ApiException(401, "NOT_AUTHENTICATED", "Jeton invalide."));
    }
}