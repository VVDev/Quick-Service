package gestore;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cliente.GestioneClienteFrame;
import cliente.MenuCliente;
import cliente.SelezionaAttivita;

import common.UtilGC;
import data_layer.Utente;

public class MenuGestore1 {
private Utente utente;
public MenuGestore1 (Utente ut)
{
	utente=ut;
		
	UtilGC gc = new UtilGC();
	final JFrame finestra=new JFrame("- Menu Gestore Attivita - ");
        JPanel spazio = new JPanel();
	JPanel pannello=new JPanel();
        JPanel spazio1 = new JPanel();
        JPanel pannello1 = new JPanel();
        JPanel spazio2 = new JPanel();
        JPanel pannello2 = new JPanel();
        JPanel spazio3 = new JPanel();
	JPanel pannello3=new JPanel();
        JPanel spazio4 = new JPanel();

        
	finestra.setLayout(new GridLayout(9,1));

	final JButton btnInserisciAttivita = new JButton("Inserisci Attivita");
	final JButton btnModificaAttivita = new JButton("Modifica Attivita");
	final JButton btnCancellaAttivita = new JButton("Cancella Attivita");
	
	final JButton btnIndietro = new JButton("Indietro");
        final JButton btnEnd      = new JButton("Esci");


	pannello.add(btnInserisciAttivita);
        pannello1.add(btnModificaAttivita);
        pannello2.add(btnCancellaAttivita);
        pannello3.add(btnIndietro);
	pannello3.add(btnEnd);
        
        finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"gest.gif"));	
        finestra.add(spazio);
	finestra.add(pannello);
        finestra.add(spazio1);
	finestra.add(pannello1);
        finestra.add(spazio2);
	finestra.add(pannello2);
        finestra.add(spazio3);
	finestra.add(pannello3);
        finestra.add(spazio4);
	
	ActionListener al = new ActionListener(){
		
		public void actionPerformed(ActionEvent evento){
			Object btn =evento.getSource();
			if (btn ==btnInserisciAttivita){
				new GestioneInserisciAttivita(utente);
				finestra.dispose();
			}
                        
                        if (btn ==btnModificaAttivita){
				new GestioneModificaAttivita(utente);
				finestra.dispose();
			}
			
                        if (btn ==btnCancellaAttivita){
				new GestioneCancellaAttivita(utente);
				finestra.dispose();
			}
			
			else if(btn == btnIndietro){
                            new MenuGestore(utente);
				finestra.dispose();
			}
                        
			else if(btn ==btnEnd){
				finestra.dispose();
			}
			
		}
	};
	
	btnInserisciAttivita.addActionListener(al);
        btnModificaAttivita.addActionListener(al);
        btnCancellaAttivita.addActionListener(al);
        btnIndietro.addActionListener(al);
	btnEnd.addActionListener(al);
	

	
		
		
	finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	finestra.setSize(450, 450);
	centerMe(finestra);
	finestra.setVisible(true);
	}
        
	private void centerMe(JFrame frame) {
	    Dimension frameSize = frame.getSize();
	    frame.setSize(frameSize);
	    frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width
	            - frameSize.width) / 2,
	        (Toolkit.getDefaultToolkit().getScreenSize().height
	            - frameSize.height) / 2);
	}

}