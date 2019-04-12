package it.dario.old.gui;

import it.dario.old.cinema.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 * Classe che crea il frame per l'interfaccia del Gestore del cinema
 * si struttura in pannelli
 * 
 * @author Dario
 *
 */
public class GuiGuest extends JFrame{
	/**
	 * 
	 * @throws IOException eccezione che può avvenire quando c'è un errore nell'apertura del file
	 * @throws ClassNotFoundException eccezione che può avvenire quando c'è un errore nella lettura dell'oggetto
	 */
	public GuiGuest() throws IOException, ClassNotFoundException{
		
		super("Pannello Gestore Cinema");
		setLocation(50, 20);
		setLayout(new GridLayout(5,0));
		setSize(400,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		add(createIntestazionePanel());
		add(createModifcaPanel());
		add(createVisualizzaFilmPanel());
		add(createVisualizzaIncassoPanel());
		add(createExitPanel());
	}
	
	/**
	 * 
	 * @return pannello contente un testo
	 */
	public JPanel createIntestazionePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 100);
		panel.setBorder(new EtchedBorder());
		
		JLabel text = new JLabel("Pannello Gestione Cinema");
		text.setSize(300, 30);
		text.setLocation(100, 30);
		panel.add(text);
		
		return panel;
	}
	
	/**
	 * 
	 * @return pannello con all'interno le info per la modifica della programmazione
	 */
	public JPanel createModifcaPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 100);
		panel.setBorder(new EtchedBorder());
		
		JLabel text = new JLabel("Modifica Programmazione");
		text.setSize(300, 30);
		text.setLocation(100, 20);
		panel.add(text);
		
		JButton button = new JButton("Modifica");
		button.setSize(200, 20);
		button.setLocation(100, 50);
		panel.add(button);
		
		/**
		 * Classe interna che gestisce l'azione per richiamare il frame di moidifica programmazione
		 * 
		 * @author Dario
		 *
		 */
		class ModListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				ModificaProgrammazione win = new ModificaProgrammazione();
			}
		}
		
		ActionListener listener = new ModListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * 
	 * @return pannello con all'interno le info per visuaizzazione dei film
	 */
	public JPanel createVisualizzaFilmPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 100);
		panel.setBorder(new EtchedBorder());
		
		JLabel text = new JLabel("Visualizza Film In Programmazione");
		text.setSize(300, 30);
		text.setLocation(100, 20);
		panel.add(text);
		
		JButton button = new JButton("Visualizza");
		button.setSize(200, 20);
		button.setLocation(100, 50);
		panel.add(button);
		
		/**
		 * Classe interna che gestisce l'azione per richiamare il frame di Visualizza film
		 * 
		 * @author Dario
		 *
		 */
		class VisualizzaFilmListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
					unisa = (Cinema) in.readObject();
					in.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}catch(ClassNotFoundException ex){ ex.printStackTrace(); }
				
				VisualizzaFilm win = new VisualizzaFilm(unisa.getSpettacoli());
			}
		}
		
		ActionListener listener = new VisualizzaFilmListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * 
	 * @return pannello con all'interno le info per visuaizzazione incasso
	 */
	public JPanel createVisualizzaIncassoPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 100);
		panel.setBorder(new EtchedBorder());
		
		JLabel text = new JLabel("Visualizza incassi Film");
		text.setSize(300, 30);
		text.setLocation(100, 20);
		panel.add(text);
		
		JButton button = new JButton("Visualizza");
		button.setSize(200, 20);
		button.setLocation(100, 50);
		panel.add(button);
		
		/**
		 * Classe interna che gestisce l'azione per richiamare il frame di Visualizza incasso
		 * 
		 * @author Dario
		 *
		 */
		class IncassoListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
					unisa = (Cinema) in.readObject();
					in.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}catch(ClassNotFoundException ex){ ex.printStackTrace(); }
				
				VisualizzaIncasso win = new VisualizzaIncasso(unisa.getGestore(), unisa.getSpettacoli());
			}
		}
		
		ActionListener listener = new IncassoListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * 
	 * @return pannello con all'interno il bottone per chiudere il prgramma
	 */
	public JPanel createExitPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 100);
		panel.setBorder(new EtchedBorder());
		
		JLabel text = new JLabel("Salva");
		text.setSize(300, 30);
		text.setLocation(100, 20);
		panel.add(text);
		
		JButton button = new JButton("Esci");
		button.setSize(200, 20);
		button.setLocation(100, 50);
		panel.add(button);
		
		/**
		 * Classe interna che gestisce l'azione per chiudere il programma
		 * 
		 * @author Dario
		 *
		 */
		class ExitListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		
		ActionListener event = new ExitListener();
		button.addActionListener(event);
		
		return panel;
	}
	
	private Cinema unisa;
}
