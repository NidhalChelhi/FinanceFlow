package financeflow.services.accounts;

import financeflow.dao.accounts.LoanDAO;
import financeflow.models.accounts.Loan;

import java.util.List;

public class LoanService {

    private final LoanDAO loanDAO;

    public LoanService() {
        this.loanDAO = new LoanDAO();
    }

    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }

    public Loan getLoanById(int id) {
        return loanDAO.findById(id);
    }

    public void saveLoan(Loan loan) {
        loanDAO.save(loan);
    }

    public void deleteLoan(int id) {
        loanDAO.delete(id);
    }
}
