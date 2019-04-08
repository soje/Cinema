package it.dario.gui;

import it.dario.cinema.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe che genera il pannello per la modifica della programmazione
 * @author Dario
 *
 */

public class ModificaProgrammazione extends JFrame{
	
	public ModificaProgrammazione(){
		super("Pannello Aggiungi Programma");
		setSize(800, 70);
		setLayout(null);
		setLocation(460, 20);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		add(aggiungiPanel());
		add(rimuoviPanel());
	}
	
	/**
	 * 
	 * @return pannello con la gestione dell'aggiungi nuovo spettacolo 
	 */
	public JPanel aggiungiPanel(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setSize(400, 50);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder());
		
		JLabel label = new JLabel("Aggiungi nuovo spettacolo");
		label.setSize(180, 20);
		label.setLocation(2, 10);
		panel.add(label);
		
		JButton button = new JButton("Aggiungi");
		button.setSize(100, 20);
		button.setLocation(190, 10);
		panel.add(button);
		
		/**
		 * Classe interna per la gestione dell'azione di apertura del frame AggiungiFilm
		 * @author Dario
		 *
		 */
		class FilmListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				AggiungiFilm win = new AggiungiFilm();
			}	
		}
		
		ActionListener listener = new FilmListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * 
	 * @return pannello con la gestione della rimozione della programmazione settimanale
	 */
	public JPanel rimuoviPanel(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setSize(400, 50);
		panel.setLocation(400, 0);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder());
		
		JLabel label = new JLabel("Rimuovi programmazione");
		label.setSize(150, 20);
		label.setLocation(2, 10);
		panel.add(label);
		
		JButton button = new JButton("Rimuovi");
		button.setSize(100, 20);
		button.setLocation(150, 10);
		panel.add(button);
		
		
		/**
		 * Classe interna che gestisce l'azione di resettare l'intera programmazione degli spettacoli
		 * contenuti all'interno dell'ArrayList
		 * 
		 * @author Dario
		 *
		 */
		class FilmListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
					Cinema unisa = (Cinema) in.readObject();
					
					unisa.setSpettacoli();
					
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cinema.dat", false));
					out.writeObject(unisa);
				}catch(IOException ex){
					ex.printStackTrace();
				}catch(ClassNotFoundException ex){ ex.printStackTrace(); }
			}	
		}
		
		ActionListener listener = new FilmListener();
		button.addActionListener(listener);
		
		return panel;
	}
}
