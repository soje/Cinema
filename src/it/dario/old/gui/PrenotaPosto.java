package it.dario.old.gui;

import it.dario.old.cinema.Cinema;
import it.dario.old.cinema.Posto;
import it.dario.old.cinema.Prenotazione;
import it.dario.old.cinema.Spettacolo;
import it.dario.old.eccezioni.PostoIndisponibileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class per la gestione del frame di Prenotazione del posto selezionato
 * 
 * @author Dario
 */

public class PrenotaPosto extends JFrame{
	
	/**
	 * Costruttore, oltre ad istanziare il frame prende come parametri lo spettacolo in cui il posto
	 * è stato selezionato e il posto stesso
	 * 
	 * @param s spettacolo 
	 * @param p posto
	 */
	public PrenotaPosto(Spettacolo s, Posto p){
		super("Prenota posto");
		setSize(500, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		try{
			in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
			unisa = (Cinema) in.readObject();
			in.close();
		}catch(ClassNotFoundException ex){ ex.printStackTrace();
		}catch(IOException ex){ ex.printStackTrace(); }
		
		this.p = p;
		this.s = s;
		
		add(createInfoPanel(), BorderLayout.NORTH);
		add(createStatoPanel(), BorderLayout.CENTER);
		if(	p.getStato() == 1){
			add(createConfirmPanel(), BorderLayout.SOUTH);
		}
		if( p.getStato() == 2 ){
			add(createAcquistaPanel(), BorderLayout.SOUTH);
		}
		
			
		setVisible(true);
	}
	
	/**
	 * Metodo che genera il panel con l'informazione del numero di posto selezionato e la lettera della fila
	 * in cui si trova
	 * 
	 * @return panel
	 */
	public JPanel createInfoPanel(){
		panel = new JPanel();
		
		text1 = new JLabel("Posto fila: "+p.getlFila()+" n°: "+p.getnPosto());
		text1.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(text1);
		
		return panel;
	}
	
	/**
	 * Metodo che genera un panel che visualizza lo stato del posto selezionato
	 * 
	 * @return panel
	 */
	public JPanel createStatoPanel(){
		panel = new JPanel();
		
		text1 = new JLabel();
		text1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		switch(p.getStato()){
		case 0: text1.setText("Stato: OCCUPATO"); break;
		case 1: text1.setText("Stato: LIBERO"); break;
		case 2: text1.setText("Stato: PRENOTATO"); break;
		case 3: text1.setText("Stato: NON DISPONIBILE"); break;
		}
		panel.add(text1);
		
		return panel;
	}
	
	/**
	 * Crea il panel di gestione della prenotazione
	 * 
	 * @return
	 */
	public JPanel createConfirmPanel(){
		panel = new JPanel();
		
		button1 = new JButton("Prenota");
		panel.add(button1);
		
		ActionListener listener = new PrenotaListener();
		button1.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * Crea il panel di gestione dell'acquisto della prenotazione
	 * 
	 * @return panel
	 */
	public JPanel createAcquistaPanel(){
		panel = new JPanel();
		
		button1 = new JButton("Compra");
		panel.add(button1);
		
		button2 = new JButton("Disdici");
		panel.add(button2);
		
		box = new JCheckBox("Seleziona se fascia protetta");
		panel.add(box);
		
		ActionListener listener = new CompraListener();
		button1.addActionListener(listener);
		
		ActionListener listener1 = new DisidiciListener();
		button2.addActionListener(listener1);
		
		return panel;
	}
	
	/**
	 * Classe interna che gestisce l'azione di prenotare il posto
	 * 
	 * @author Dario
	 *
	 */
	class PrenotaListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			try{
				
				prenota = new Prenotazione(s, unisa.getSessioneAttuale());
				prenota.prenota(p);
				unisa.getPrenotazioni().add(prenota);
				
				for(Spettacolo e : unisa.getSpettacoli()){
					if(e.getInizio().equals(s.getInizio()) && e.getSala().getnSala() == s.getSala().getnSala()){
						e.getSala().getPosto(p).setStato(2);
					}
				}
				
				dispose();
				
				out = new ObjectOutputStream(new FileOutputStream("Cinema.dat", false));
				out.writeObject(unisa);
				out.close();
				}catch(IOException ex){ ex.printStackTrace(); }
		}
	}
	
	/**
	 * Classe interna che gestisce l'azione di comprare il posto
	 * @author Dario
	 *
	 */
	class CompraListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			try{
				
				for(Prenotazione pre : unisa.getPrenotazioni()){
					if(pre.getC().equals(unisa.getSessioneAttuale())){
						if(pre.getPostoPrenotato().equals(p)){
							prenota = pre;
							prenota.confermaPrenotazione(p);							
							break;
						}
					}else prenota = null;
				}
				
				if(prenota == null) throw new PostoIndisponibileException("non autorizzato");
				
				for(Spettacolo e : unisa.getSpettacoli()){
					if(e.getInizio().equals(s.getInizio()) && e.getSala().getnSala() == s.getSala().getnSala()){
						e.getSala().getPosto(p).setStato(0);
						e.getFilm().setIncasso(e.getFilm().getIncasso()+prenota.ApplicaSconto(box.isSelected()));
					}
				}
				
				dispose();
				
				out = new ObjectOutputStream(new FileOutputStream("Cinema.dat", false));
				out.writeObject(unisa);
				out.close();
			}catch(IOException ex){ ex.printStackTrace(); 
			}catch(PostoIndisponibileException ex){
				FrameErrore win = new FrameErrore(ex.getMessage());
			}
		}
	}
	
	/**
	 * Classe interna che gestisce l'azione di disdire il posto
	 * 
	 * @author Dario
	 *
	 */
	class DisidiciListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			try{
				
				for(Prenotazione pre : unisa.getPrenotazioni()){
					if(pre.getC().equals(unisa.getSessioneAttuale())){
						if(pre.getPostoPrenotato().equals(p)){
							prenota = pre;
							prenota.rimuoviPrenotazione(p);
							unisa.getPrenotazioni().remove(pre);
							break;
						}
					}else prenota = null;
				}
				
				if(prenota == null) throw new PostoIndisponibileException("non autorizzato");
				
				for(Spettacolo e : unisa.getSpettacoli()){
					if(e.getInizio().equals(s.getInizio()) && e.getSala().getnSala() == s.getSala().getnSala()){
						e.getSala().getPosto(p).setStato(1);
						e.getFilm().setIncasso(e.getFilm().getIncasso()-prenota.getPrezzoFinale());
					}
				}
				
				dispose();
				
				out = new ObjectOutputStream(new FileOutputStream("Cinema.dat", false));
				out.writeObject(unisa);
				out.close();
			}catch(IOException ex){ ex.printStackTrace(); 
			}catch(PostoIndisponibileException ex){
				FrameErrore win = new FrameErrore(ex.getMessage());
			}
		}
	}
	
	private JPanel panel;
	private JLabel text1;
	private JButton button1;
	private JButton button2;
	private JCheckBox box;
	private Posto p;
	private Spettacolo s;
	private Cinema unisa;
	private Prenotazione prenota;
	private ObjectInputStream in;
	private ObjectOutputStream out;
}
