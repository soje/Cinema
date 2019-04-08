package it.dario.cinema;

import it.dario.gui.Login;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
			
//		File f = new File("Cinema.dat");
//		Cinema unisa;
//		
//		try{
//			
//			if(f.exists()){
//				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
//				unisa = (Cinema) in.readObject();
//				in.close();
//			}
//			else{
//				unisa = new Cinema();
//				unisa.setGestore(new Gestore("gestore", "admin"));
//				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
//				out.writeObject(unisa);
//				out.close();
//			}
//			
//		}catch(IOException ex){ ex.printStackTrace(); 
//		}catch(ClassNotFoundException ex) { ex.printStackTrace(); }
//		
//		Login log = new Login();
	}
}
