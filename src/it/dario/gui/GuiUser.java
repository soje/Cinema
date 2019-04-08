package it.dario.gui;

import it.dario.cinema.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 * Classe che genera il frame per l'interfaccia di gestione dell'utente
 * 
 * @author Dario
 *
 */

public class GuiUser extends JFrame{
	
	/**
	 * 
	 * @throws IOException IOException eccezione che può avvenire quando c'è un errore nell'apertura del file
	 * @throws ClassNotFoundException ClassNotFoundException eccezione che può avvenire quando c'è un errore nella lettura dell'oggetto
	 */
	public GuiUser()throws IOException, ClassNotFoundException{
		super("Home Cinema Unisa!");
		setLocation(250, 20);
		setSize(800,710);
		setResizable(false);
		
		ordine = (x, y) -> x.getFilm().getTitolo().compareTo( y.getFilm().getTitolo() );
		
		in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
		this.unisa= (Cinema) in.readObject();
		current = new GregorianCalendar();
		
		for(Prenotazione e : unisa.getPrenotazioni()){
			if(e.getDataScadenza().before(current)){
				unisa.getPrenotazioni().remove(e);
			}
		}
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 0));
		
		filmsList = new JPanel();
		filmsList.setLayout(new GridLayout(0,1));
		addFilmList();
		
		scrollBar1 = new JScrollPane(filmsList);
		mainPanel.add(scrollBar1);
		
		filmInfo = new JPanel();
		filmInfoField();
		mainPanel.add(filmInfo);
		
		add(SortField(), BorderLayout.SOUTH);
		add(mainPanel, BorderLayout.NORTH);
		
		setVisible(true);
		}
	
	/**
	 * Genera sul frame principale un pannello contenente la lista dei film in programmazione
	 * da qui è possibile visualizzare il nome del film, l'ora di inizio, la sala in cui è proiettato
	 * e il tasto per avviare la prenotazione di un posto
	 * 
	 * @param i indice per trovare lo spettacolo da cui trarre le informazioni all'interno dell'ArrayList
	 */
	public void filmField(int i){
		film = new JPanel();
		film.setBorder(new EtchedBorder());
		film.setLayout(new GridLayout(2,2));
		film.setPreferredSize(new Dimension(400, 100));
		
		titolo = new JLabel(unisa.getSpettacoli().get(i).getFilm().getTitolo());
		titolo.setFont(new Font("Arial", Font.PLAIN, 25));
		film.add(titolo);
		
		sala = new JLabel("Sala: "+Integer.toString(unisa.getSpettacoli().get(i).getSala().getnSala()));
		sala.setFont(new Font("Arial", Font.PLAIN, 20));
		film.add(sala);
		
		ora = new JLabel("Inizio: "+Integer.toString(unisa.getSpettacoli().get(i).getOraInizio())+":"+Integer.toString(unisa.getSpettacoli().get(i).getMinutoInizio()));
		ora.setFont(new Font("Arial", Font.PLAIN, 20));
		film.add(ora);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		
		prenota = new JButton("Prenota");
		prenota.setSize(80, 20);
		buttonPanel.add(prenota);
		
		film.add(buttonPanel);
		filmsList.add(film);
		
		/**
		 * Classe interna che gestisce l'azione del mouse sul film selezionato, ne mostra le info
		 * 
		 * @author Dario
		 *
		 */
		class InfoClick implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				String info = unisa.getInfo(unisa.getSpettacoli().get(i));
				list.setText(info);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		} 
		MouseListener click = new InfoClick();
		film.addMouseListener(click);
		
		class PrenotaListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VisualizzaPosto win = new VisualizzaPosto(unisa.getSpettacoli().get(i));
			}
		}
		
		ActionListener listener = new PrenotaListener();
		prenota.addActionListener(listener);
	}
	
	/**
	 * Metodo che aggiunge i film all'interno del pannelo dei film
	 * e ne gestisce l'ordinamento
	 */
	public void addFilmList(){
		int index = 0;
		
		ArrayList<Spettacolo> x = unisa.getSpettacoli();
		Collections.sort(x, ordine);
		for(Spettacolo e : x){
			if(current.before(e.getInizio())){
				filmField(index);
				index++;
			}
		}
	}
	
	/**
	 * Genera il pannello che mostra le info dei film in programmazione
	 */
	public void filmInfoField(){
		filmList = new JPanel();
		filmList.setMaximumSize(new Dimension(400, 700));
		filmList.setBorder(new EtchedBorder());
		
		list = new JTextArea(41,33);
		list.setEditable(false);
		list.setLineWrap(true);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		list.setWrapStyleWord(true);
		
		scrollBar2 = new JScrollPane(list);
		filmList.add(scrollBar2);
		
		filmInfo.add(filmList);
		repaint();
	}
	
	/**
	 * 
	 * @return pannello contenente JRadioButton per la selezione del tipo di ordinamento 
	 * da effettuare
	 */
	public JPanel SortField(){
		JPanel panel = new JPanel();
		
		cB1 = new JRadioButton ("Ordina per sala");
		panel.add(cB1, FlowLayout.LEFT);
		
		cB2 = new JRadioButton ("Ordina per titolo");
		panel.add(cB2, FlowLayout.CENTER);
		
		cB3 = new JRadioButton ("Ordina per data");
		panel.add(cB3, FlowLayout.RIGHT);
		
		ButtonGroup g = new ButtonGroup();
		g.add(cB1);
		g.add(cB2);
		g.add(cB3);
		
		/**
		 * Classe interna che gestisce l'azione di ordinamento dei film
		 * 
		 * @author Dario
		 *
		 */
		class SalaListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				filmsList.setVisible(false);
				ordine = (x, y) ->{ if(x.getSala().getnSala() < y.getSala().getnSala()) return -1;
						 			if(x.getSala().getnSala() == y.getSala().getnSala()) return 0;
						 			return 1;
									};
				filmsList.removeAll();
				addFilmList();
				filmsList.revalidate();
				filmsList.repaint();
				filmsList.setVisible(true);
			}
			
		}
		
		ActionListener listener1 = new SalaListener();
		cB1.addActionListener(listener1);
		
		/**
		 * Classe interna che gestisce l'azione di ordinamento dei film
		 * 
		 * @author Dario
		 *
		 */
		class TitoloListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				filmsList.setVisible(false);
				
				ordine = (x, y) -> x.getFilm().getTitolo().compareTo( y.getFilm().getTitolo() );
				
				filmsList.removeAll();
				addFilmList();
				filmsList.revalidate();
				filmsList.repaint();
				filmsList.setVisible(true);
			}
		}
	
		ActionListener listener2 = new TitoloListener();
		cB2.addActionListener(listener2);
		
		/**
		 * Classe interna che gestisce l'azione di ordinamento dei film
		 * 
		 * @author Dario
		 *
		 */
		class DataListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				filmsList.setVisible(false);
				
				ordine = (x, y) -> { if(x.getInizio().compareTo(y.getInizio()) < 0) return -1;
									 if(x.getInizio().compareTo(y.getInizio()) == 0) return 0;
									 return 1;
				};
				
				filmsList.removeAll();
				addFilmList();
				filmsList.revalidate();
				filmsList.repaint();
				filmsList.setVisible(true);
			}
		}
		
		ActionListener listener3 = new DataListener();
		cB3.addActionListener(listener3);
		
		return panel;
	}
	
	
	private JPanel mainPanel;
	private JPanel filmsList;
	private JScrollPane scrollBar1;
	private JPanel filmInfo;
	private JPanel film;
	private JLabel titolo;
	private JLabel sala;
	private JLabel ora;
	private JPanel buttonPanel;
	private JButton prenota;
	private JPanel filmList;
	private JTextArea list;
	private JScrollPane scrollBar2;
	private Cinema unisa;
	private ObjectInputStream in;
	public GregorianCalendar current;
	private Comparator<Spettacolo> ordine;
	private JRadioButton cB1;
	private JRadioButton cB2;
	private JRadioButton cB3;
}