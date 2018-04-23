package Facade;

public class SecurityCodeCheck{
	

    public String getSecurityCode() {
    	return "76215591";
    }

    public boolean isCodeCorrect(String securityCode){

        if(securityCode.equals(getSecurityCode())) {
            return true;
        } else {
            return false;
        }
    }
}