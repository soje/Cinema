package it.dario.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.dario.cinema.*;

/**
 * Classe istanzia il frame per la gestione dell'inserimento dei parametri di un film 
 * nella programmazione
 * 
 * @author Dario
 *
 */
public class AggiungiFilm extends JFrame{

	/**
	 * Costruttore, genera un frame principale
	 */
	
	public AggiungiFilm(){
		
		super("Inserisci Parametri");
		setLayout(null);
		setSize(810, 430);
		setLocation(455, 95);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		add(createInfoPanel());
		add(createDatePanel());
		add(createDatiPanel());
		add(createPolitichePanel());
		add(createButtonPanel());
		add(createButtonPanel());
		
	}
	
	/**
	 * 
	 * @return un pannello con all'interno i componenti per l'inserimento di parametri
	 */
	public JPanel createInfoPanel(){
		panel = new JPanel();
		panel.setSize(400, 300);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("passo 1"));
		
		text1 = new JLabel("Titolo:");
		text1.setFont(new Font("Arial", Font.PLAIN, 15));
		text1.setSize(100, 20);
		text1.setLocation(5, 20);
		panel.add(text1);
		
		titolo = new JTextField();
		titolo.setSize(280, 20);
		titolo.setLocation(100, 20);
		panel.add(titolo);
		
		text2 = new JLabel("Descrizione:");
		text2.setFont(new Font("Arial", Font.PLAIN, 15));
		text2.setSize(100, 20);
		text2.setLocation(5, 50);
		panel.add(text2);
		
		info = new JTextArea(10,10);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		
		scroll = new JScrollPane(info);
		scroll.setSize(280, 200);
		scroll.setLocation(100, 50);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroll);
		
		return panel;
	}
	
	/**
	 * 
	 * @return un pannello con all'interno i componenti per l'inserimento di parametri
	 */
	public JPanel createDatePanel(){
		panel = new JPanel();
		panel.setSize(300, 120);
		panel.setLocation(420, 0);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("passo 2"));
		
		text1 = new JLabel("Data di inizio proiezione:");
		text1.setFont(new Font("Arial", Font.PLAIN, 15));
		text1.setSize(180, 20);
		text1.setLocation(5, 15);
		panel.add(text1);
		
		text2 = new JLabel("Giorno:");
		text2.setFont(new Font("Arial", Font.PLAIN, 15));
		text2.setSize(100, 20);
		text2.setLocation(5, 40);
		panel.add(text2);
		
		giorno = new JTextField(20);
		giorno.setSize(20, 20);
		giorno.setLocation(60, 40);
		panel.add(giorno);
		
		text3 = new JLabel("Mese:");
		text3.setFont(new Font("Arial", Font.PLAIN, 15));
		text3.setSize(100, 20);
		text3.setLocation(100, 40);
		panel.add(text3);
		
		mese = new JTextField(20);
		mese.setSize(20, 20);
		mese.setLocation(160, 40);
		panel.add(mese);
		
		text4 = new JLabel("Ora inizio spettacolo:");
		text4.setFont(new Font("Arial", Font.PLAIN, 15));
		text4.setSize(150, 20);
		text4.setLocation(5, 70);
		panel.add(text4);
		
		ora = new JTextField(20);
		ora.setSize(20, 20);
		ora.setLocation(150, 70);
		panel.add(ora);
		
		text5 = new JLabel(":");
		text5.setFont(new Font("Arial", Font.PLAIN, 15));
		text5.setSize(20, 20);
		text5.setLocation(175, 70);
		panel.add(text5);
		
		minuto = new JTextField(20);
		minuto.setSize(20, 20);
		minuto.setLocation(185, 70);
		panel.add(minuto);
		
		return panel;
	}
	
	/**
	 * 
	 * @return un pannello con all'interno i componenti per l'inserimento di parametri
	 */
	public JPanel createDatiPanel(){
		panel = new JPanel();
		panel.setSize(300, 100);
		panel.setLocation(420, 150);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("passo 3"));
		
		text1 = new JLabel("N° Sala:");
		text1.setFont(new Font("Arial", Font.PLAIN, 15));
		text1.setSize(100, 20);
		text1.setLocation(5, 25);
		panel.add(text1);
		
		sala = new JTextField(20);
		sala.setSize(20, 20);
		sala.setLocation(60, 25);
		panel.add(sala);
		
		text3 = new JLabel("Prezzo Biglietto:");
		text3.setFont(new Font("Arial", Font.PLAIN, 15));
		text3.setSize(120, 20);
		text3.setLocation(5, 60);
		panel.add(text3);
		
		prezzo = new JTextField(20);
		prezzo.setSize(60, 20);
		prezzo.setLocation(115, 60);
		panel.add(prezzo);
		
		return panel;
	}
	
	/**
	 * 
	 * @return un pannello con all'interno i componenti per la selezione e l'abilitazione degli sconti
	 */
	public JPanel createPolitichePanel(){
		panel = new JPanel();
		panel.setSize(400, 80);
		panel.setLocation(0, 300);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("passo 4"));
		
		politica1 = new JCheckBox("Fasce protette");
		politica1.setSize(110, 40);
		politica1.setLocation(5, 20);
		panel.add(politica1);
		
		politica2 = new JCheckBox("Speciale Mercoledì");
		politica2.setSize(140, 40);
		politica2.setLocation(111, 20);
		panel.add(politica2);
		
		politica3 = new JCheckBox("Fascia pomeridiana");
		politica3.setSize(140, 40);
		politica3.setLocation(250, 20);
		panel.add(politica3);
		
		return panel;
	}
	
	/**
	 * 
	 * @return un pannello con all'interno i componenti per l'inserimento di parametri
	 */
	public JPanel createButtonPanel(){
		panel = new JPanel();
		panel.setSize(300, 80);
		panel.setLocation(420, 300);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("passo 5"));
		
		text1 = new JLabel("Set Posti Disponibili:");
		text1.setFont(new Font("Arial", Font.PLAIN, 15));
		text1.setSize(240, 20);
		text1.setLocation(5, 25);
		panel.add(text1);
		
		button = new JButton("Set");
		button.setSize(120, 20);
		button.setLocation(150, 25);
		panel.add(button);
		
		/**
		 * Classe interna che gestisce un'azione 
		 * 
		 * @author Dario
		 *
		 */
		class addListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Spettacolo nuovo = new Spettacolo();		
				try{			
					nuovo.getFilm().setTitolo(titolo.getText());
					nuovo.getFilm().setInfo(info.getText());
					nuovo.setInizio(Integer.parseInt(mese.getText()), Integer.parseInt(giorno.getText()), Integer.parseInt(ora.getText()), Integer.parseInt(minuto.getText()));
					nuovo.getSala().setnSala(Integer.parseInt(sala.getText()));
					nuovo.setPrezzo(Double.parseDouble(prezzo.getText()));
					if(politica1.isSelected()) { nuovo.setPolitica1(true);}
					if(politica2.isSelected()) { nuovo.setPolitica2(true);}
					if(politica3.isSelected()) { nuovo.setPolitica3(true);}
					
					ValidaPosto win = new ValidaPosto(nuovo);

					dispose();
				}catch(IllegalArgumentException ex){
					FrameErrore win = new FrameErrore("Inserire correttamente i parametri");
				}
			}	
		}
		
		ActionListener listener = new addListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	private JPanel panel;
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JLabel text4;
	private JLabel text5;
	private JTextField titolo;
	private JTextField giorno;
	private JTextField mese;
	private JTextField ora;
	private JTextField minuto;
	private JTextField sala;
	private JTextField prezzo;
	private JTextArea info;
	private JScrollPane scroll;
	private JButton button;
	private JCheckBox politica1;
	private JCheckBox politica2;
	private JCheckBox politica3;
}
