package runtime.account.api.dto;

public record GetAccountResponse(
        String id, String pseudonym, String email) {
}
