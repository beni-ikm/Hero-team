package runtime.account;

import org.glassfish.jersey.server.ResourceConfig;
import runtime.account.api.*;
import runtime.account.application.AccountOutputMapper;
import runtime.account.application.CreateAccountUseCase;
import runtime.account.application.GetAccountUseCase;
import runtime.account.domain.AccountFactory;
import runtime.account.domain.AccountRepository;
import runtime.account.infrastructure.AccountPersistenceMapper;
import runtime.account.infrastructure.InMemoryAccountRepository;

public class AccountInstaller {

    private final AccountRepository accountRepository;

    public AccountInstaller() {
        this.accountRepository = new InMemoryAccountRepository(new AccountPersistenceMapper());
    }

    public void install(ResourceConfig resourceConfig) {

        AccountOutputMapper outputMapper =
                new AccountOutputMapper();
        CreateAccountUseCase createAccountUseCase =
                new CreateAccountUseCase(
                        new AccountFactory(), accountRepository, outputMapper);
        GetAccountUseCase getAccountUseCase =
                new GetAccountUseCase(accountRepository, outputMapper);

        resourceConfig.register(
                new AccountResource(
                        createAccountUseCase,
                        new CreateAccountRequestMapper(),
                        getAccountUseCase,
                        new AccountResponseMapper()));

        resourceConfig.register(new AccountExceptionMapper());
        resourceConfig.register(new AccountNotFoundExceptionMapper());
    }

}
