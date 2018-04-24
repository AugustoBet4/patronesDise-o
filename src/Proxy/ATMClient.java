package Proxy;

import javax.swing.JOptionPane;

public class ATMClient {
	static int cash = 1000;
    public static void main(String[] args) {
    	while(true) {
        
    	GetATMData realAtmMachine = new ATMMachine(cash);
        GetATMData atmProxy = new ATMProxy(realAtmMachine);
        
        ventanas(atmProxy.getCashInMachine());
       // System.out.println("ATM Machine, cash available: " + atmProxy.getCashInMachine());
    	}
        
    }
    public static void ventanas(int a) {
    	String[] options = new String[] {"Estado ATM", "Cambiar conf", "Cancelar"};
    	int opcion = JOptionPane.showOptionDialog(null, "�Qu� operaci�n desea realizar?", "Operaci�n",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);
    	if(opcion==0) {
    		JOptionPane.showMessageDialog(null, "Cajero ATM, efectivo disponible: "+ a);
    	}else {
    		if(opcion == 1) {
    			int nuevo = Integer.parseInt(JOptionPane.showInputDialog("Actualizar efectivo de la maquina"));
    			cash = nuevo;
    			GetATMData realAtmMachine = new ATMMachine(nuevo);
    			
    		}else {
    			System.exit(0);
    		}
    	}
    
    }
}