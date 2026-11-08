package runtime.account.domain;

public class AccountFactory {

    public Account create(
            String accountUserId,
            String pseudonym,
            String email,
            String password) {
        return new Account(
                AccountId.generate(),
                new AccountUserId(accountUserId),
                new AccountPseudonym(pseudonym),
                new AccountEmail(email),
                new AccountPassword(password));
    }
}
