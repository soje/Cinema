package it.dario.old.gui;

import it.dario.old.cinema.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VisualizzaFilm extends JFrame{
	
	public VisualizzaFilm(ArrayList<Spettacolo> s){
		super("Visualizza Film");
		setSize(400, 500);
		setLocation(460, 20);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.s=s;
		
		add(createListPanel());
	}
	
	public JPanel createListPanel(){
		JPanel panel = new JPanel();
		
		JTextArea text = new JTextArea(20,20);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 20));
		text.setText("Film ordinati per posti disponibili: \n");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		
		ordine = (x, y) -> { if(x.getSala().getPostiDisponibili()<y.getSala().getPostiDisponibili()) return -1;
		 					 if(x.getSala().getPostiDisponibili()==y.getSala().getPostiDisponibili()) return 0;
		 					 return 1;
				};
				
		Collections.sort(s, ordine);
		for(Spettacolo e : s){
			text.append(e.getFilm().getTitolo()+" - Sala n°"+e.getSala().getnSala()+"\n");
		}
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroll);
		
		return panel;
	}
	
	private Comparator<Spettacolo> ordine;
	private ArrayList<Spettacolo> s;
}
