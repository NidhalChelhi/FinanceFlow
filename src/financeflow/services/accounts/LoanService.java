package financeflow.services.accounts;

import financeflow.dao.accounts.LoanDAO;
import financeflow.models.accounts.Loan;

import java.util.List;

public class LoanService {

    private final LoanDAO loanDAO = new LoanDAO();

    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }

    public List<Loan> searchLoans(String query) {
        return loanDAO.searchLoans(query);
    }

    public void deleteLoan(int id) {
        loanDAO.delete(id);
    }

    public void saveLoan(Loan loan) {
        loanDAO.insertOrUpdate(loan);
    }
}
