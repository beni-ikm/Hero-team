package runtime.account.application;

import runtime.account.domain.Account;
import runtime.account.domain.AccountFactory;
import runtime.account.domain.AccountRepository;

public class CreateAccountUseCase {

    private final AccountFactory accountFactory;
    private final AccountRepository accountRepository;
    private final AccountOutputMapper outputMapper;

    public CreateAccountUseCase(
            AccountFactory accountFactory,
            AccountRepository accountRepository,
            AccountOutputMapper outputMapper) {

        this.accountFactory = accountFactory;
        this.accountRepository = accountRepository;
        this.outputMapper = outputMapper;

    }

    public AccountOutput execute(CreateAccountCommand command) {

        Account account =
                accountFactory.create(
                        command.accountUserId(),
                        command.pseudonym(),
                        command.email(),
                        command.password());

        accountRepository.save(account);

        return outputMapper.toOutput(account);

    }

}
