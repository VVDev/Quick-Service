/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import common.UtilGC;
import data_layer.Utente;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MenuAdmin {
private Utente utente;
	public MenuAdmin(Utente ut){
           utente = ut;
               UtilGC gc = new UtilGC();
               
		final JFrame finestra = new JFrame("- Menu Administrator - ");
		JPanel titolo    = new JPanel();
                JPanel pannello  = new JPanel();
                JPanel spazio    = new JPanel();
                JPanel pannello1 = new JPanel();
                
		
		finestra.setLayout(new GridLayout(5,1));
		
		final JButton btnInserisci = new JButton("Inserisci Gestore");

		final JButton btnEnd = new JButton("Esci");


		pannello.add(btnInserisci);
		pannello1.add(btnEnd);
		
                finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"admin.gif"));
                finestra.add(titolo);
		finestra.add(pannello);
                finestra.add(spazio);
                finestra.add(pannello1);
	
		ActionListener al = new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				Object s=evento.getSource();
				if (s==btnInserisci){
					new AdminInserisciGestore(utente);
					finestra.dispose();
				}
				
				else if(s==btnEnd){
					finestra.dispose();
				}
				
			}
		};
		
		btnInserisci.addActionListener(al);
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