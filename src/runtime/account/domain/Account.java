package runtime.account.domain;

import java.util.Objects;

public class Account {

    private final AccountId id;
    private final AccountUserId userId;
    private final AccountPseudonym pseudonym;
    private final AccountEmail email;
    private final AccountPassword password;

    public Account(
            AccountId id,
            AccountUserId userId,
            AccountPseudonym pseudonym,
            AccountEmail email,
            AccountPassword password) {

        this.id = Objects.requireNonNull(id);
        this.userId = Objects.requireNonNull(userId);
        this.pseudonym = Objects.requireNonNull(pseudonym);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);

    }

    public boolean isOwnedBy(AccountUserId user) { return userId.equals(user); }

    public AccountId accountId() { return id; }

    public AccountUserId accountUserId() { return userId; }

    public AccountPseudonym accountPseudonym() { return pseudonym; }

    public AccountEmail accountEmail() { return email; }

    public AccountPassword accountPassword() { return password; }

    @Override
    public boolean equals(Object other) { return other instanceof Account account && id.equals(account.id); }

    @Override
    public int hashCode() { return id.hashCode(); }


}
