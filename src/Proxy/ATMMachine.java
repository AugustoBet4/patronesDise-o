package Proxy;
public class ATMMachine implements GetATMData {

    private int cashInMachine;

    public ATMMachine(int cashInMachine){
        this.cashInMachine = cashInMachine;
    }
    public int getCashInMachine() {
        return cashInMachine;
    }
}