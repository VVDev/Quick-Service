/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestore;

import common.UtilGC;
import data_layer.Attivita;
import data_layer.Database;
import data_layer.Utente;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class GestioneModificaAttivita {
	
	private ArrayList<Attivita> attivita;
	private JTable TableAttivita;
	private Utente ut;
	 public GestioneModificaAttivita  (Utente u)
	{
	 ut=u;
         UtilGC gc = new UtilGC();
	 final JFrame frmFinestraGS = new JFrame("Albergo - Seleziona Attivita Da Modificare");  //  @jve:decl-index=0:visual-constraint="135,33"
	 JPanel btnPanel         = new  JPanel();
	 JPanel btnPanelCre      = new  JPanel();
	 JPanel btnPanelMod      = new  JPanel();
	 JPanel btnPanelCan      = new  JPanel();
	 JPanel btnPanelEsci     = new  JPanel();
	 JPanel txtPanel         = new  JPanel();
	 JLabel lblSelezAttivita = new  JLabel();
	 JLabel lblAttivita      = new  JLabel("Attivita ");
	 JLabel lblData          = new  JLabel("Data");
	 JLabel lblOra           = new  JLabel(" Ora");
	 JLabel lblPosti         = new  JLabel("Posti Disponibili");
         JLabel lblPrezzo        = new  JLabel("Prezzo");
   
         
         
         
        final JButton btnSelezAttivita = new JButton("SELEZIONA ATTIVITA");
        btnSelezAttivita.addMouseListener(new MouseAdapter() {
		 public void mouseClicked(MouseEvent evt) {
				try {
					ModificaSalaButtonMouseClicked(evt);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Errore nella query!", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void ModificaSalaButtonMouseClicked(MouseEvent evt)throws SQLException {
				int riga = TableAttivita.getSelectedRow();
				if (riga == -1 ){
					JOptionPane.showMessageDialog(null,"Selezionare una riga!", "ERRORE!", JOptionPane.WARNING_MESSAGE);
				}
				else{
					Attivita s = attivita.get(riga);
					GestioneModificaAttivita1  mod= new GestioneModificaAttivita1 (ut,s);
					frmFinestraGS.dispose();
				}
			}
		});

 		try{
 			Database db = new Database();
   		        attivita= db.getAttivita();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
		}

			int nrighe=0;
			int i=0;
			String celle[][];
			
			for (Attivita s : attivita){
				nrighe++;
			}
			celle=new String[nrighe][5];
			for (Attivita s : attivita){
				celle[i][0] = s.getNome();
                                celle[i][1] = s.getData();
                                celle[i][2] = s.getOra();
				celle[i][3] = String.valueOf(s.getPostiD());
                                celle[i][4] = s.getPrezzo();
				i++;
			}
			TableModel TableAttivitaModel = new DefaultTableModel(celle,	new String[] { "Attivita", "Data","Ora","Posti","Prezzo"});
			
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
                                    MenuGestore1 menu = new MenuGestore1(ut);
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
                        
                        
                        
                        
                        
         frmFinestraGS.setSize(400, 600);
	 
         txtPanel.add(lblSelezAttivita);
	 lblSelezAttivita.setFont(new java.awt.Font("Tahoma",1,18));
	 lblSelezAttivita.setText("ATTIVITA");
         
          btnPanel.add(lblAttivita);
	 lblAttivita.setPreferredSize(new java.awt.Dimension(50, 14));
          btnPanel.add(lblData);
	  lblData.setPreferredSize(new java.awt.Dimension(50, 14));
          btnPanel.add(lblOra);
	  lblOra.setPreferredSize(new java.awt.Dimension(50, 14));
	  btnPanel.add(lblPosti);
	 lblPosti.setPreferredSize(new java.awt.Dimension(100, 14));
          btnPanel.add(lblPrezzo);
	  lblPrezzo.setPreferredSize(new java.awt.Dimension(40, 14));

         btnPanelEsci.add(btnSelezAttivita);
	
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