package runtime.account.application;

import runtime.account.domain.Account;

public class AccountOutputMapper {

    public AccountOutput toOutput(Account account) {
        return new AccountOutput(
                account.accountId().value(),
                account.accountUserId().value(),
                account.accountPseudonym().value(),
                account.accountEmail().value(),
                account.accountPassword().value());
    }

}
