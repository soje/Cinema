package it.dario.old.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Classe che genera il frame richiamato da un'eccezione
 * 
 * @author Dario
 *
 */
public class FrameErrore extends JFrame{

	public FrameErrore(String s){
		super("Errore!");
		setSize(300, 100);
		setLocation(450, 450);
		setLayout(null);
		setVisible(true);
		
		JLabel msg = new JLabel(s);
		msg.setSize(250, 20);
		msg.setLocation(5, 10);
		
		JButton ok = new JButton("Ok");
		ok.setSize(50, 20);
		ok.setLocation(210, 30);
		
		add(msg);
		add(ok);
		repaint();
		
		class CloseAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
			
		}
		ActionListener close = new CloseAction();
		ok.addActionListener(close);
	}
}
