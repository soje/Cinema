package it.dario.old.gui;

import it.dario.old.cinema.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

/**
 * Classe che gestisce all'apertura del programma il login degli utenti
 * 
 * @author Dario
 *
 */
public class Login extends JFrame{

	/**
	 * 
	 * @throws IOException eccezione che può avvenire quando c'è un errore nell'apertura del file
	 * @throws ClassNotFoundException eccezione che può avvenire quando c'è un errore nella lettura dell'oggetto
	 */
	public Login() throws IOException, ClassNotFoundException{
		super("Cinema UNISA");
		setLocation(250, 20);
		setSize(800, 700);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		f = new File("Cinema.dat");
		if(!f.exists()){
			f.createNewFile();
			unisa=new Cinema();
			out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(unisa);
			out.close();
		}
		
		gui = this;
		
		panel1 = new JPanel();
		panel1.setSize(800, 70);
		panel1.setLocation(0, 0);
		panel1.setBackground(Color.GRAY);
		
		welcomeField();
		userField();
		passwordField();
		okButtonField();
		regButtonField();
	}
	
	
	/**
	 * genera una barra di benvenuto 
	 */
	public void welcomeField(){
		text1 = new JLabel("Benvenuto al cinema Unisa!");
		text1.setFont(new Font("Arial", Font.PLAIN, 40));
		text1.setSize(100, 100);
		text1.setLocation(0, 0);

		panel1.add(text1);
		add(panel1);
		setVisible(true);
	}
	
	/**
	 * Genera il campo per l'inserimento dei dati dell'utente
	 */
	public void userField(){
		text2 = new JLabel("User:");
		text2.setFont(new Font("Arial", Font.PLAIN, 15));
		text2.setSize(50, 50);
		text2.setLocation(290, 245);

		inseret1 = new JTextField(20);
		inseret1.setSize(200, 20);
		inseret1.setLocation(290, 280);

		add(text2);
		add(inseret1);
	}
	
	public void passwordField(){
		text3 = new JLabel("Password:");
		text3.setFont(new Font("Arial", Font.PLAIN, 15));
		text3.setSize(70, 50);
		text3.setLocation(290, 290);

		inseret2 = new JPasswordField(20);
		inseret2.setSize(200, 20);
		inseret2.setLocation(290, 325);

		add(text3);
		add(inseret2);
		repaint();
	}
	
	public void okButtonField(){
		ok = new JButton("OK");
		ok.setSize(55,20);
		ok.setLocation(435, 350);
		ActionListener click = new AccessListener();
		ok.addActionListener(click);
		
		add(ok);
		repaint();
	}
	
	public void regButtonField(){
		registrati = new JButton("Registrati");
		registrati.setSize(100,20);
		registrati.setLocation(290,350);
		ActionListener clickReg = new RegListener();
		registrati.addActionListener(clickReg);
		
		add(registrati);
		repaint();
	}
	
	/**
	 * Classe interna per l'azione di gestione del login
	 * 
	 * @author Dario
	 *
	 */
	class AccessListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			
			try {
				in = new ObjectInputStream(new FileInputStream(f));
				unisa = (Cinema) in.readObject();
				in.close();
				
				String utente = inseret1.getText();
				String pswd = String.valueOf(inseret2.getPassword());
			
				for(Cliente e : unisa.getClienti()){
					if( e.getUser().equals(utente) && e.getPswd().equals(pswd)){
						unisa.setSessioneAttuale(e);
						out = new ObjectOutputStream(new FileOutputStream(f, false));
						out.writeObject(unisa);
						out.close();
						GuiUser win = new GuiUser(); 
					}
				}
				if(unisa.getGestore().getUser().equals(utente) && unisa.getGestore().getPswd().equals(pswd)){
					GuiGuest win = new GuiGuest();
				}
			} catch (ClassNotFoundException e1) { e1.printStackTrace();
			} catch (IOException e){e.printStackTrace(); }
		}
	}
	
	/**
	 * Classe interna per l'azione che apre il pannello di registrazione nel frame
	 * 
	 * @author Dario
	 *
	 */
	class RegListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
				try {
					Registrazione win = new Registrazione(gui);
				} catch (ClassNotFoundException | IOException e1) {e1.printStackTrace();}
		}
	}
	
	private Cinema unisa;
	private JFrame gui;
	private JPanel panel1;
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JTextField inseret1;
	private JPasswordField inseret2;
	private JButton ok;
	private JButton registrati;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private File f;
	
}
