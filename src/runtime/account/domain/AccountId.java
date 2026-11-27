package runtime.account.domain;

import java.util.Objects;
import java.util.UUID;

public record AccountId(String value) {

    public AccountId {
        Objects.requireNonNull(value);
    }

    public static AccountId generate() {
        return new AccountId(UUID.randomUUID().toString());
    }

}
