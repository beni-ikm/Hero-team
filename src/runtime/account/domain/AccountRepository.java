package runtime.account.domain;

public interface AccountRepository {

    void save(Account account);

    Account fetchById(AccountId id);

}
