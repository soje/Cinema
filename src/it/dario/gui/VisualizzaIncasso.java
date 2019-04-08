package it.dario.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.*;
import it.dario.cinema.*;

public class VisualizzaIncasso extends JFrame{

	public VisualizzaIncasso(Gestore g, ArrayList<Spettacolo> s){
		super("Visualizza Incassi");
		setSize(400, 500);
		setLocation(460, 20);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.g=g;
		this.s= s;
		
		add(IncassoTotalePanel(), BorderLayout.NORTH);
		add(IncassoPerFilmPanel(), BorderLayout.SOUTH);
	}
	
	public JPanel IncassoTotalePanel(){
		JPanel panel = new JPanel();
		panel.setSize(400, 100);
		panel.setLocation(0, 0);
		panel.setBorder(new EtchedBorder());
		
		JTextArea text = new JTextArea("Incasso totale degli Spettacoli:\n"+String.valueOf(g.getIncassoTotale(s)));
		text.setFont(new Font("Arial", Font.PLAIN, 20));
		text.setEditable(false);
		panel.add(text);
		
		return panel;
	}
	
	public JPanel IncassoPerFilmPanel(){
		JPanel panel = new JPanel();
		panel.setSize(400, 370);
		panel.setLocation(0, 100);
		panel.setBorder(new EtchedBorder());
		
		JTextArea text = new JTextArea(15,20);
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 20));
		text.append("Incasso singolo per film:\n");
		for(Spettacolo e : s){
			text.append(e.getFilm().getTitolo()+": "+String.valueOf(e.getFilm().getIncasso())+"\n");
		}
		
		JScrollPane scroll = new JScrollPane(text);
		panel.add(scroll);
		
		return panel;
	}
	
	private Gestore g;
	private ArrayList<Spettacolo> s;
}
