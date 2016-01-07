/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestore;

import common.UtilGC;
import data_layer.Utente;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MenuGestore {
private Utente utente;
public MenuGestore (Utente ut)
{
	utente=ut;
		
	UtilGC gc              = new UtilGC();
	final JFrame finestra  = new JFrame("- Menu Gestore- ");
        JPanel spazio          = new JPanel();
	JPanel pannello        = new JPanel();
        JPanel spazio1         = new JPanel();
        JPanel pannello1       = new JPanel();
        JPanel spazio2         = new JPanel();
        JPanel pannello2       = new JPanel();
        JPanel spazio3         = new JPanel();
	JPanel pannello3       = new JPanel();
        JPanel spazio4         = new JPanel();

        
	finestra.setLayout(new GridLayout(9,1));

	final JButton btnMenuAttivita     = new JButton("Gestione Attivita");
	final JButton btnMenuPrenotazioni = new JButton("Gestione Prenotazioni");
        final JButton btnMenuUtenti       = new JButton("Gestione Utenti");
	final JButton btnEnd              = new JButton("Esci");

        finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"gest.gif"));	
	pannello.add(btnMenuAttivita);
        pannello1.add(btnMenuUtenti);
        pannello2.add(btnMenuPrenotazioni);
	pannello3.add(btnEnd);
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
			if (btn ==btnMenuAttivita){
				new MenuGestore1(utente);
				finestra.dispose();
			}
                        
                        if (btn ==btnMenuUtenti){
				new MenuUtenti(utente);
				finestra.dispose();
			}
                        
                        
                        if (btn ==btnMenuPrenotazioni){
				new MenuPrenotazioni(utente);
				finestra.dispose();
			}			
			
			else if(btn ==btnEnd){
				finestra.dispose();
			}
			
		}
	};
	
	btnMenuAttivita.addActionListener(al);
        btnMenuPrenotazioni.addActionListener(al);
        btnMenuUtenti.addActionListener(al);
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