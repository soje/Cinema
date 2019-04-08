package it.dario.gui;

import it.dario.cinema.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class VisualizzaPosto extends JFrame{
	
	public VisualizzaPosto(Spettacolo s){
		super("Unisa");
		setSize(507, 530);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.s = s;
		this.ascissa = 0;
		this.ordinata = 0;
		this.posti = new ArrayList<DisegnaPosto>();
		
		disegnoSala();
		
		setVisible(true);
	}
	
	public void disegnoSala(){
		int index = 0;
		for(; ordinata < 500; ordinata+=50){
			while(ascissa < 500){
				rettangolo = new DisegnaPosto(ascissa, ordinata, s.getSala().getPosti().get(index));
				posti.add(rettangolo);
				add(rettangolo);
				setVisible(true);
				ascissa+=50;
				index++;
			}
			ascissa = 0;
		}
	}
	
	public Posto postoSelezionato(int x, int y){
		int nPosto = 0;
		char lFila = 'k';
		
		for(int lfila=0; lfila<500; lfila+=50){
			if(lfila<y){
				lFila--;
			}
		}
		for(int index = 0; index< 500; index+=50){
			if(index<x){
				nPosto++;
			}
		}
	
		Posto postoSelezionato = new Posto(nPosto, lFila);
		return postoSelezionato;
	}
	
	
	class DisegnaPosto extends JComponent{
		
		public DisegnaPosto(int x, int y, Posto p){
			this.x=x;
			this.y=y;
			this.colore = setColor(p);
			
			MouseListener click = new Click();
			addMouseListener(click);
		}
		
		public void paintComponent(Graphics g){
			g2 = (Graphics2D) g;
			g2.setColor(colore);
			box = new Rectangle(x, y, 50, 50);
			g2.fill(box);
			g2.setColor(Color.BLACK);
			g2.draw(box);
		}
		
		public Color setColor(Posto p){
			for(Posto e : s.getSala().getPosti()){
				if(e.equals(p)){
					switch(e.getStato()){
					case 0: colore = Color.RED; break;
					case 1: colore = Color.GREEN; break;
					case 2: colore = Color.ORANGE; break;
					case 3: colore = Color.GRAY; break;
					}
				}
			} return colore;
		}
		
		public void setColor(){
			if(colore == Color.GREEN){
				colore = Color.YELLOW; }
			else if(colore == Color.YELLOW){
				colore = Color.GREEN;}
		}
		
		private int x;
		private int y;
		private Color colore;
		private Graphics2D g2;
		private Rectangle box;
		
		class Click implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent event) {
				Posto a;
				for(DisegnaPosto e : posti){
					if(e.box.contains(event.getX(), event.getY())){
						a = postoSelezionato(event.getX(), event.getY());
						e.setColor();
						revalidate();
						repaint();
						
						PrenotaPosto win = new PrenotaPosto(s, s.getSala().getPosto(a));
						dispose();
						
					}
				} 
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
	}
	
	private DisegnaPosto rettangolo;
	private ArrayList<DisegnaPosto> posti;
	private int ascissa;
	private int ordinata;
	private Spettacolo s;
}
