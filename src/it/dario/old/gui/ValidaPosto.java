package it.dario.old.gui;

import it.dario.old.cinema.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 * Classe per l'interfaccia del gestore che permette di selezionare i posti da rendere
 * Disponibili o NonDisponibili
 * 
 * @author Dario
 *
 */

public class ValidaPosto extends JFrame{
	
	/**
	 * Costruttore che prende come parametro lo spettacolo sul quale applicare la modifica dei posti
	 * 
	 * @param s
	 */
	public ValidaPosto(Spettacolo s){
		super("Unisa");
		setSize(507, 570);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.s = s;
		this.ascissa = 0;
		this.ordinata = 0;
		this.posti = new ArrayList<DisegnaPosto>();
		
		add(createConfirmPanel(), BorderLayout.NORTH);
		disegnoSala();
		
		setVisible(true);
	}
	
	/**
	 * 
	 * @return pannello che consente la conferma della selezione
	 */
	public JPanel createConfirmPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		
		JButton button = new JButton("Conferma");
		panel.add(button);
		
		/**
		 * Classe interna per la gestione dell'aggiunta dello spettacolo all'ArrayList
		 * 
		 * @author Dario
		 */
		class ConfirmListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				
				try{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cinema.dat"));
					unisa = (Cinema) in.readObject();
					in.close();
					
					unisa.addSpettacolo(s);
					dispose();
					
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cinema.dat", false));
					out.writeObject(unisa);
					out.close();
				}catch(IOException ex){ex.printStackTrace();
				}catch(ClassNotFoundException ex){ ex.printStackTrace();}
			}
		}
		
		ActionListener listener = new ConfirmListener();
		button.addActionListener(listener);
		
		return panel;
	}
	
	/**
	 * Metodo che genera mediante un ciclo il disegno della sala, 
	 * l'istanziazione dei posti e la crezione dell'ArrayList per la gestione
	 * degli oggetti disegnati
	 */
	
	public void disegnoSala(){
		for(; ordinata < 500; ordinata+=50){
			while(ascissa < 500){
				rettangolo = new DisegnaPosto(ascissa, ordinata);
				Posto a = postoSelezionato(ascissa+50, ordinata+50);
				posti.add(rettangolo);
				s.getSala().addPosto(a);
				add(rettangolo);
				setVisible(true);
				ascissa+=50;
			}
			ascissa =0;
		}
	}
	
	/**
	 * Metodo che calcola la fila e il posto tramite il disegno della sala
	 * 
	 * @param x ascissa del punto in cui si trova il posto
	 * @param y ordinata del punto in cui si trova il posto
	 * @return il posto selezionato
	 */
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
	
	/**
	 * Classe interna che gestisce gli oggetti disegnatori che generano i posti
	 * 
	 * @author Dario
	 *
	 */
	class DisegnaPosto extends JComponent{
		
		/**
		 * Istanzia un disegnatore 
		 * 
		 * @param x ordnata
		 * @param y ascissa
		 */
		public DisegnaPosto(int x, int y){
			this.x=x;
			this.y=y;
			this.colore = Color.GREEN;
			
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
		
		public void setColor(){
			if(colore == Color.GREEN){
				colore = Color.GRAY; }
			else if(colore == Color.GRAY){
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
						e.setColor();
						revalidate();
						repaint();
						a = postoSelezionato(event.getX(), event.getY());
						
						if(s.getSala().getPosto(a).getStato() == 1){
							s.getSala().getPosto(a).setStato(3);
							s.getSala().setPostiDisponibili(s.getSala().getPostiDisponibili()-1);}
						else if(s.getSala().getPosto(a).getStato() == 3){
							s.getSala().getPosto(a).setStato(1);
							s.getSala().setPostiDisponibili(s.getSala().getPostiDisponibili()+1);}
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
	private Cinema unisa;
	private Spettacolo s;
}
