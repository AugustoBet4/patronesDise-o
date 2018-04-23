package Facade;

public class BankFacade {

    private String accountNumber;
    private String securityCode;

    private AccountNumberCheck accountChecker;
    private SecurityCodeCheck codeChecker;
    private FundsCheck fundsChecker;

    private WelcomeMessage bankWelcome;

    public BankFacade(String accountNumber, String securityCode){

        this.accountNumber = accountNumber;
        this.securityCode  = securityCode;

        bankWelcome    = new WelcomeMessage();
        accountChecker = new AccountNumberCheck();
        codeChecker    = new SecurityCodeCheck();
        fundsChecker   = new FundsCheck();

    }

    private String getAccountNumber() {
    	return accountNumber;
    }

    private String getSecurityCode() {
    	return securityCode;
    }

    public void withdrawCash(double cashAmount){

        if(canWithdraw(cashAmount)) {
            System.out.println("Transacción Completada\n");
        } else {
            System.out.println("Transacción Fallida\n");
        }

    }


    public void depositCash(double cashAmount){
        if(canDeposit(cashAmount)) {
            fundsChecker.makeDeposit(cashAmount);
            System.out.println("Transacción Completada\n");
        } else {
            System.out.println("Transacción Fallida\n");
        }
    }

    private boolean canWithdraw(double cashAmount){
        return accountChecker.isAccountActive(this.accountNumber) &&
                codeChecker.isCodeCorrect(this.securityCode) &&
                fundsChecker.haveEnoughMoney(cashAmount);
    }

    private boolean canDeposit(double cashAmount){
        return accountChecker.isAccountActive(this.accountNumber) &&
                codeChecker.isCodeCorrect(this.securityCode);
    }
    public boolean isUser(){
    	return accountChecker.isAccountActive(this.accountNumber) &&
                codeChecker.isCodeCorrect(this.securityCode);
    }

}