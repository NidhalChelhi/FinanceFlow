package financeflow.services.accounts;

import financeflow.dao.accounts.AccountDAO;
import financeflow.models.accounts.Account;

import java.util.List;

public class AccountService {
    private final AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    public Account getAccountById(int id) {
        return accountDAO.findById(id);
    }

    public void createAccount(Account account) {
        accountDAO.insert(account);
    }


}
