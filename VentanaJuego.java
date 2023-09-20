package ventanas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame {
	protected JButton btnAcelera;
	protected JButton btnFrena;
	protected JButton btnGira_IZQ;
	protected JButton btnGira_DCHA;
	protected JPanel pnlBotonera;
	protected JPanel pnlPrincipal;
	private CocheJuego coche;
	
	public VentanaJuego() {
		this.setTitle("Juego de Coches");
		this.setSize(500,500);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pnlPrincipal= new JPanel();
		pnlPrincipal.setLayout(null);
		
		pnlBotonera= new JPanel();
		pnlBotonera.setLayout(new GridLayout());
		this.add(pnlBotonera);
		
		coche= new CocheJuego();
		coche.setPosicion(150,100);
		pnlPrincipal.add(coche.getLabelCoche());
		
		
		
		btnAcelera= new JButton("ACELERA");
		pnlBotonera.add(btnAcelera);
		btnAcelera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				System.out.println("Velocidad Actual: "+ coche.getMiVelocidad());
			}
			
		});
		
		btnFrena= new JButton("FRENA");
		pnlBotonera.add(btnFrena);
		btnFrena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.frena(5);
				System.out.println("Velocidad Actual: "+ coche.getMiVelocidad());
				
			}
			
		});
		
		btnGira_IZQ= new JButton("GIRA IZQ");
		pnlBotonera.add(btnGira_IZQ);
		btnGira_IZQ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
				System.out.println("Velocidad Actual: "+ coche.getMiDireccionActual());
				
			}
			
		});
		
		btnGira_DCHA= new JButton("GIRA DCHA");
		pnlBotonera.add(btnGira_DCHA);
		btnGira_DCHA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				System.out.println("Dirección Actual: "+ coche.getMiDireccionActual());
				
			}
			
		});
		this.add(pnlBotonera, BorderLayout.SOUTH);
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				dispose();
				
			}
		});
		
		MiHilo miHilo= new MiHilo();
		miHilo.start();
	}
	private class MiHilo extends Thread{
		private boolean detener= false;
		
		public void detener() {
			detener= true;
		}
		@Override
		public void run() {
			while(!detener) {
				try {
					Thread.sleep(40);
				}catch(InterruptedException e) {
					e.printStackTrace();
					
				}
			}
		}
	}
	
	
	
	

	public static void main(String[] args) {
		VentanaJuego v= new VentanaJuego();
		v.setVisible(true);

	}

}
