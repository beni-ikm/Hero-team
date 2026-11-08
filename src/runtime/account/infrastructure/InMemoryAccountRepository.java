package runtime.account.infrastructure;

import runtime.account.domain.Account;
import runtime.account.domain.AccountId;
import runtime.account.domain.AccountRepository;
import runtime.account.domain.exception.AccountNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, AccountPersistenceModel> accounts = new ConcurrentHashMap<>();

    public AccountPersistenceMapper persistenceMapper;

    public InMemoryAccountRepository(AccountPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Account account) {
        AccountPersistenceModel model = persistenceMapper.toPersistence(account);
        accounts.put(model.id(), model);
    }

    @Override
    public Account fetchById(AccountId id) {
        AccountPersistenceModel model = accounts.get(id.value());
        if (model == null) {
            throw new AccountNotFoundException(id);
        }
        return persistenceMapper.toDomain(model);
    }

}
