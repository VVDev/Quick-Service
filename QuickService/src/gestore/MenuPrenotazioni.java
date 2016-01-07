/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestore;

import common.UtilGC;
import data_layer.Database;
import data_layer.Prenotazioni;
import data_layer.Utente;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author user
 */
public class MenuPrenotazioni {
private ArrayList<Prenotazioni> prenotazioni;
	private JTable TableAttivita;
	private Utente ut;
	 public MenuPrenotazioni  (Utente u)
	{
	 ut=u;
         UtilGC gc = new UtilGC();
	 final JFrame frmFinestraGS = new JFrame("Albergo - Visualizza Prenotazioni");  //  @jve:decl-index=0:visual-constraint="135,33"
	 JPanel btnPanel         = new  JPanel();
	 JPanel btnPanelCre      = new  JPanel();
	 JPanel btnPanelMod      = new  JPanel();
	 JPanel btnPanelCan      = new  JPanel();
	 JPanel btnPanelEsci     = new  JPanel();
	 JPanel txtPanel         = new  JPanel();
	 JLabel lblSelezAttivita = new  JLabel();
	 JLabel lblAttivita      = new  JLabel("ID ATTIVITA");
	 JLabel lblData          = new  JLabel("NOME");
	 JLabel lblOra           = new  JLabel("COGNOME");
	 JLabel lblPosti         = new  JLabel("Posti ");
         JLabel lblPrezzo        = new  JLabel(" C_F");
         JLabel lblPrenotato     = new  JLabel("Prenotato");
         
         
         
//        final JButton btnSelezAttivita = new JButton("SELEZIONA ATTIVITA");
//        btnSelezAttivita.addMouseListener(new MouseAdapter() {
//		 public void mouseClicked(MouseEvent evt) {
//				try {
//					ModificaSalaButtonMouseClicked(evt);
//				} catch (SQLException e) {
//					JOptionPane.showMessageDialog(null,"Errore nella query!", "Errore",
//							JOptionPane.ERROR_MESSAGE);
//				}
//			}
//
//			private void ModificaSalaButtonMouseClicked(MouseEvent evt)throws SQLException {
//				int riga = TableAttivita.getSelectedRow();
//				if (riga == -1 ){
//					JOptionPane.showMessageDialog(null,"Selezionare una riga!", "ERRORE!", JOptionPane.WARNING_MESSAGE);
//				}
//				else{
//					Attivita s = attivita.get(riga);
//					GestioneModificaAttivita1  mod= new GestioneModificaAttivita1 (ut,s);
//					frmFinestraGS.dispose();
//				}
//			}
//		});

 		try{
 			Database db = new Database();
   		        prenotazioni = db.getPrenotazioni();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
		}

			int nrighe=0;
			int i=0;
			String celle[][];
			
			for (Prenotazioni s : prenotazioni){
				nrighe++;
			}
			celle=new String[nrighe][6];
			for (Prenotazioni s : prenotazioni){
				celle[i][0] = String.valueOf(s.getID());
                                celle[i][1] = s.getNome();
                                celle[i][2] = s.getCognome();
				celle[i][3] = String.valueOf(s.getPosti());
                                celle[i][4] = s.getPrenotato();
                                celle[i][5] = s.getCf();
				i++;
			}
			TableModel TableAttivitaModel = new DefaultTableModel(celle,	new String[] { "ID_Attivita", "Nome","Cognome","Posti","Prenotato","C_F"});
			
                        TableAttivita = new JTable();

			TableAttivita.setModel(TableAttivitaModel);

			//TableAttivita.setPreferredSize(new java.awt.Dimension(343,200));
			TableAttivita.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
                        btnPanelCre.add(TableAttivita);
			frmFinestraGS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 
                        
               	{
		JPanel btnPanelSpazio = new JPanel();
		frmFinestraGS.getContentPane().add(btnPanelSpazio);
		{
			final JButton btnIndietro = new JButton("Indietro");
			btnPanelEsci.add(btnIndietro);
			btnIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
                                    MenuGestore menu = new MenuGestore(ut);
					frmFinestraGS.dispose();
					
				}
			});
		}
		{
			final JButton btnESCI1 = new JButton("ESCI");
			btnPanelEsci.add(btnESCI1);
			btnESCI1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					frmFinestraGS.dispose();
				}
			});
		}
	}         
                        
                        
                        
                        
                        
         frmFinestraGS.setSize(600, 600);
	 
         txtPanel.add(lblSelezAttivita);
	 lblSelezAttivita.setFont(new java.awt.Font("Tahoma",1,18));
	 lblSelezAttivita.setText("ATTIVITA");
         
          btnPanel.add(lblAttivita);
	 lblAttivita.setPreferredSize(new java.awt.Dimension(80, 14));
          btnPanel.add(lblData);
	  lblData.setPreferredSize(new java.awt.Dimension(70, 14));
          btnPanel.add(lblOra);
	  lblOra.setPreferredSize(new java.awt.Dimension(70, 14));
	  btnPanel.add(lblPosti);
	 lblPosti.setPreferredSize(new java.awt.Dimension(80, 14));
          btnPanel.add(lblPrezzo);
	  lblPrezzo.setPreferredSize(new java.awt.Dimension(60, 14));
         btnPanel.add(lblPrenotato);
	  lblPrenotato.setPreferredSize(new java.awt.Dimension(80, 14));
 
//         btnPanelEsci.add(btnSelezAttivita);
	
         frmFinestraGS.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"gest.gif"));	
	 frmFinestraGS.setLayout(new GridLayout(7,1));
	 frmFinestraGS.add(txtPanel);
	 frmFinestraGS.add(btnPanel);

	 frmFinestraGS.add(btnPanelCre);
//	 btnPanelCre.setPreferredSize(new java.awt.Dimension(1, 1));
//	 frmFinestraGS.add(btnPanelMod);
	 frmFinestraGS.add(btnPanelCan);
	 frmFinestraGS.add(btnPanelEsci);

	 frmFinestraGS.setVisible(true);
	 centerMe(frmFinestraGS);
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