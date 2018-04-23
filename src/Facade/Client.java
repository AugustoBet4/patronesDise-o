package Facade;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Client extends JFrame{
		
	private JPanel contentPane;
	private JTextField numCuenta;
	private JTextField monto;
	private JPasswordField codSeguridad;
	private JLabel lblCodigoDeSeguridad;
	private JLabel lblNumCuenta;
	private JLabel lblMonto;
	private JButton btnAcceder;
	private JButton btnRetiro;
	private JButton btnDeposito;
	private JButton btnConfirmarRetiro;
	private JButton btnConfirmarDeposito;
	
	protected BankFacade acceso;

    public static void main(String[] args) {
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//
//        accesingBank.withdrawCash(50.00);
//        accesingBank.withdrawCash(900.00);
//        accesingBank.depositCash(200.00);
//
//        accesingBank.withdrawCash(900.00);

    }
    
    public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 165);
		setTitle("Acceder al sistema");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		numCuenta = new JTextField();
		numCuenta.setToolTipText("Igrese aqui su Numero de Cuenta :D");
		numCuenta.setBounds(21, 34, 163, 23);
		contentPane.add(numCuenta);
		numCuenta.setColumns(10);
		
		codSeguridad = new JPasswordField();
		codSeguridad.setToolTipText("Ingrese aqui su Codigo de Control :D");
		codSeguridad.setBounds(21, 81, 163, 23);
		contentPane.add(codSeguridad);
		
		lblNumCuenta= new JLabel("Numero de Cuenta: ");
		lblNumCuenta.setBounds(21, 18, 163, 14);
		contentPane.add(lblNumCuenta);
		
		lblCodigoDeSeguridad = new JLabel("Codigo de Seguridad");
		lblCodigoDeSeguridad.setBounds(21, 67, 165, 14);
		contentPane.add(lblCodigoDeSeguridad);
		
		lblMonto = new JLabel("");
		lblMonto.setBounds(160, 40, 116, 23);
		lblMonto.setVisible(false);
		contentPane.add(lblMonto);
		
		monto = new JTextField();
		monto.setToolTipText("Ingrese aqui el monto >:(");
		monto.setBounds(160, 60, 165, 23);
		monto.setVisible(false);
		contentPane.add(monto);


		/* Boton de Acceder con su correspondiente ActionListener */
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = numCuenta.getText();
				String cod = new String(codSeguridad.getPassword());
				if ((num!=null) || (cod!=null)){
					
					acceso = new BankFacade(num, cod);
					if (acceso.isUser()){
						
						JOptionPane.showMessageDialog(null, "Ingreso Exitoso", "EXITO! :V", JOptionPane.INFORMATION_MESSAGE);
						numCuenta.setVisible(false);
						codSeguridad.setVisible(false);
						lblCodigoDeSeguridad.setVisible(false);
						lblNumCuenta.setVisible(false);
						btnAcceder.setVisible(false);
						setTitle("Sistema :D");
						setBounds(100, 100, 450, 200);
						btnDeposito.setVisible(true);
						btnRetiro.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Numero de Cuenta o Codigo Incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
						System.out.println("No es Cliente");
					}
				}
			}
		});
		btnAcceder.setBounds(196, 58, 116, 23);
		contentPane.add(btnAcceder);
		
		btnRetiro = new JButton("Retiro");
		btnRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonto.setVisible(true);
				monto.setVisible(true);
				monto.setText("");
				lblMonto.setText("Monto a Retirar");
				btnConfirmarDeposito.setVisible(false);
				btnConfirmarRetiro.setVisible(true);
			}
		});
		btnRetiro.setBounds(20,28,116,23);
		btnRetiro.setVisible(false);
		contentPane.add(btnRetiro);
		
		btnDeposito = new JButton("Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMonto.setVisible(true);
				monto.setVisible(true);
				lblMonto.setText("Monto a Depositar");
				monto.setText("");
				btnConfirmarDeposito.setVisible(true);
				btnConfirmarRetiro.setVisible(false);
			}
		});
		btnDeposito.setBounds(20,78,116,23);
		btnDeposito.setVisible(false);
		contentPane.add(btnDeposito);
		
		btnConfirmarRetiro = new JButton("Confirmar");
		btnConfirmarRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monto.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Ingrese un monto", "ERROR", JOptionPane.ERROR_MESSAGE);
				else{
					acceso.withdrawCash(new Double(monto.getText()));
				}
			}
		});
		btnConfirmarRetiro.setBounds(160, 90, 116, 23);
		btnConfirmarRetiro.setVisible(false);
		contentPane.add(btnConfirmarRetiro);
		
		btnConfirmarDeposito = new JButton("Confirmar");
		btnConfirmarDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monto.getText().equals(""))
					JOptionPane.showMessageDialog(null,"Ingrese un monto", "ERROR", JOptionPane.ERROR_MESSAGE);
				else{
					acceso.depositCash(new Double(monto.getText()));
				}
			}
		});
		btnConfirmarDeposito.setBounds(160, 90, 116, 23);
		btnConfirmarDeposito.setVisible(false);
		contentPane.add(btnConfirmarDeposito);
	}
}