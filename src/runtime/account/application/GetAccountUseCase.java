package runtime.account.application;

import runtime.account.domain.Account;
import runtime.account.domain.AccountId;
import runtime.account.domain.AccountRepository;
import runtime.account.domain.AccountUserId;
import runtime.account.domain.exception.AccountNotFoundException;

public class GetAccountUseCase {

    private final AccountRepository accountRepository;
    private final AccountOutputMapper outputMapper;

    public GetAccountUseCase(
            AccountRepository accountRepository, AccountOutputMapper outputMapper) {
        this.accountRepository = accountRepository;
        this.outputMapper = outputMapper;
    }

    public AccountOutput execute(GetAccountQuery query) {
        AccountId accountId = new AccountId(query.accountId());
        AccountUserId accountUserId = new AccountUserId(query.userId());

        Account account = accountRepository.fetchById(accountId);

        if (!account.isOwnedBy(accountUserId)) {
            throw new AccountNotFoundException(accountId);
        }

        return outputMapper.toOutput(account);

    }

}
