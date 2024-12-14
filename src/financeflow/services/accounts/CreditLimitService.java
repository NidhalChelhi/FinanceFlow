package financeflow.services.accounts;

import financeflow.dao.accounts.CreditLimitDAO;
import financeflow.models.accounts.CreditLimit;

import java.util.List;

public class CreditLimitService {

    private final CreditLimitDAO creditLimitDAO;

    public CreditLimitService() {
        this.creditLimitDAO = new CreditLimitDAO();
    }

    public List<CreditLimit> getAllCreditLimits() {
        return creditLimitDAO.findAll();
    }

    public CreditLimit getCreditLimitById(int id) {
        return creditLimitDAO.findById(id);
    }

    public void saveOrUpdateCreditLimit(CreditLimit creditLimit) {
        creditLimitDAO.insertOrUpdate(creditLimit);
    }

    public void deleteCreditLimit(int id) {
        creditLimitDAO.delete(id);
    }
}
