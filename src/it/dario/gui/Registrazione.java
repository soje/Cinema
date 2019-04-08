package it.dario.gui;

import it.dario.cinema.Cinema;
import it.dario.cinema.Cliente;

import java.awt.Color;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe che gestisce il pannello di registrazione utente
 * 
 * @author Dario
 *
 */

public class Registrazione extends JFrame{
	
	/**
	 * 
	 * @param x frame su cui compare il panel registrazione
	 * @throws IOException eccezione che può avvenire quando c'è un errore nell'apertura del file
	 * @throws ClassNotFoundException eccezione che può avvenire quando c'è un errore nella lettura dell'oggetto
	 */
	public Registrazione(JFrame x) throws IOException, ClassNotFoundException{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(800, 300);
		panel.setLocation(0, 400);
		
		f= new File("Cinema.dat");
		this.frame=x;
		
		messageField();
		nameFiled();
		surnameFiled();
		ageField();
		userField();
		passwordField();
		confirmButton();
		
		frame.add(panel);
		frame.repaint();
		frame.setVisible(true);
	}
	
	
	public void messageField(){
		text1= new JLabel("Inserisci i tuoi dati:");
		text1.setLocation(290, 30);
		text1.setSize(200, 20);
		panel.add(text1);
	}
	
	public void nameFiled(){
		textName= new JLabel("Nome:");
		textName.setLocation(290, 50);
		textName.setSize(100, 20);
		panel.add(textName);
		name = new JTextField(200);
		name.setLocation(390, 50);
		name.setSize(200, 20);
		panel.add(name);
		panel.repaint();
	}
	
	public void surnameFiled(){
		textSur= new JLabel("Cognome:");
		textSur.setLocation(290, 75);
		textSur.setSize(100, 20);
		panel.add(textSur);
		surname = new JTextField(200);
		surname.setLocation(390, 75);
		surname.setSize(200, 20);
		panel.add(surname);
	}
	
	public void ageField(){
		textAge= new JLabel("Età:");
		textAge.setLocation(290, 100);
		textAge.setSize(100, 20);
		panel.add(textAge);
		age = new JTextField(200);
		age.setLocation(390, 100);
		age.setSize(200, 20);
		panel.add(age);
	}
	
	public void userField(){
		textUser= new JLabel("User:");
		textUser.setLocation(290, 125);
		textUser.setSize(100, 20);
		panel.add(textUser);
		user = new JTextField(200);
		user.setLocation(390, 125);
		user.setSize(200, 20);
		panel.add(user);
	}
	
	public void passwordField(){
		textPswd= new JLabel("Password:");
		textPswd.setLocation(290, 150);
		textPswd.setSize(100, 20);
		panel.add(textPswd);
		pswd = new JPasswordField(200);
		pswd.setLocation(390, 150);
		pswd.setSize(200, 20);
		panel.add(pswd);
	}
	
	public void confirmButton(){
		confirm = new JButton("Conferma");
		confirm.setLocation(600, 200);
		confirm.setSize(100,20);
		ActionListener clickConfirm = new ConfirmListener();
		confirm.addActionListener(clickConfirm);
		panel.add(confirm);
		panel.repaint();
	}
	
	public void confirmMessage(){
		msg = new JPanel();
		msg.setSize(800, 300);
		msg.setLocation(0, 400);
		msg.setVisible(true);
		
		effettuata = new JLabel("Registrazione confermata!");
		effettuata.setSize(500, 25);
		effettuata.setLocation(300,500);
		effettuata.setForeground(Color.RED);
		msg.add(effettuata);
		
		frame.add(msg);
		frame.repaint();
	}
	
	/**
	 * Classe interna che gestisce l'azione di crezione utente e salvataggio nel file
	 * 
	 * @author Dario
	 *
	 */
	class ConfirmListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			nuovoCliente = new Cliente();
			revalidate();
			repaint();
			try{nuovoCliente.setNome(name.getText());
				nuovoCliente.setCognome(surname.getText());
				nuovoCliente.setEta(Integer.parseInt(age.getText()));
				nuovoCliente.setUser(user.getText());
				nuovoCliente.setPswd(String.valueOf(pswd.getPassword()));
				
				panel.setVisible(false);
				
				in = new ObjectInputStream(new FileInputStream(f));
				unisa = (Cinema) in.readObject();
				in.close();
				
				unisa.getClienti().add(nuovoCliente);
				
				out = new ObjectOutputStream(new FileOutputStream(f, false));
				out.writeObject(unisa);
				out.close();
				
			}catch(IllegalArgumentException exception){
				FrameErrore error = new FrameErrore("Completare correttamente i campi!");
			}catch(IOException exception){
				exception.getStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private JFrame frame;
	private JPanel panel;
	private JLabel text1;
	private JLabel textName; 
	private JTextField name;
	private JLabel textSur;
	private JTextField surname;
	private JLabel textUser;
	private JTextField user;
	private JLabel textAge;
	private JTextField age;
	private JLabel textPswd;
	private JPasswordField pswd;
	private JButton confirm;
	private JLabel effettuata;
	private JPanel msg;
	private Cinema unisa;
	private Cliente nuovoCliente;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private File f;
}
