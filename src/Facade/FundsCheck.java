package Facade;

public class FundsCheck {

    private double cashInAccount = 1000.00;

    public double getCashInAccount() {
    	return cashInAccount;
    }

    public void decreaseCashInAccount(double cashWithdrawn) {
    	cashInAccount -= cashWithdrawn;
    }

    public void increaseCashInAccount(double cashDeposited) {
    	cashInAccount += cashDeposited;
    }

    public boolean haveEnoughMoney(double cashToWithdrawal) {

        if(cashToWithdrawal > getCashInAccount()) {
            System.out.println("ERROR: Usted no tiene dinero suficiente");
            System.out.println("Balance Actual: " + getCashInAccount());
            return false;
        } else {
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Transaccion Completada:\nBalance actual: " + getCashInAccount());
            return true;
        }

    }

    public void makeDeposit(double cashToDeposit) {
        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposito Completo:\nBalance Actual: " + getCashInAccount());

    }

}