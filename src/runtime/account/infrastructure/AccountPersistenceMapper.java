package runtime.account.infrastructure;

import runtime.account.domain.*;

public class AccountPersistenceMapper {

    public AccountPersistenceModel toPersistence(Account account) {
        return new AccountPersistenceModel(
                account.accountId().value(),
                account.accountUserId().value(),
                account.accountPseudonym().value(),
                account.accountEmail().value(),
                account.accountPassword().value());
    }

    public Account toDomain(AccountPersistenceModel model) {
        return new Account(
                new AccountId(model.id()),
                new AccountUserId(model.accountUserId()),
                new AccountPseudonym(model.pseudonym()),
                new AccountEmail(model.email()),
                new AccountPassword(model.password()));
    }

}
