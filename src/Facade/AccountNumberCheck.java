package Facade;

public class AccountNumberCheck {

    private String accountNumber = "9896776";

    public String getAccountNumber() {
    	return accountNumber;
    }

    public boolean isAccountActive(String accountNumber){
        if(accountNumber.equals(getAccountNumber())) {
            return true;
        } else {
            return false;
        }
    }
}
