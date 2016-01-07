/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestore;

import com.mysql.jdbc.Connection;
import common.UtilGC;
import data_layer.Database;
import data_layer.Utente;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class GestioneInserisciAttivita {
    private Utente ut;
	 public GestioneInserisciAttivita (Utente u)
		{
                 ut=u;
                 UtilGC gc = new UtilGC();
		 final JFrame finestra = new JFrame("Gestione Cinema - Inserisci un attivita");  //  @jve:decl-index=0:visual-constraint="135,33"
	     
             JPanel pnlNome              = new JPanel();
             JPanel pnlSpazio 		 = new JPanel();
	     JPanel pnlDescrizione       = new JPanel();
             JPanel pnlSpazio1 		 = new JPanel();
             JPanel pnlData 		 = new JPanel();
             JPanel pnlSpazio2 		 = new JPanel();
             JPanel pnlOra 		 = new JPanel();
             JPanel pnlSpazio3 		 = new JPanel();
             JPanel pnlPosti 		 = new JPanel();
             JPanel pnlSpazio4 		 = new JPanel();
             JPanel pnlPrezzo 		 = new JPanel();
             JPanel pnlSpazio5 		 = new JPanel();
             JPanel pnlInfo              = new JPanel();
             JPanel pnlSpazio6 		 = new JPanel(); 
             JPanel pnlBottoni 		 = new JPanel();
            
      

      JLabel lblNome=new JLabel("NOME ATTIVITA");
      final JTextField txtNome =new JTextField();
      
      JLabel lblDescrizione=new JLabel("DESCRIZIONE ATTIVITA");
      final JTextField txtDescrizione =new JTextField();
      
      JLabel lblData=new JLabel("Data");
      final JTextField txtData =new JTextField();
      
      JLabel lblOra=new JLabel("Ora");
      final JTextField txtOra =new JTextField();
     
      JLabel lblPosti = new JLabel("Posti Disponibili");
      final JTextField txtPosti =new JTextField();
      
      JLabel lblPrezzo = new JLabel("Prezzo");
      final JTextField txtPrezzo =new JTextField();
     
      JLabel lblInfo= new JLabel("Specifiche sulla prenotazione");
      final JTextField txtInfo =new JTextField();
      
      final JButton btnInserisci = new JButton("Inserisci");
      final JButton btnIndietro = new JButton("Indietro");
      
      
      	 ActionListener cs = new  ActionListener(){
  
		public void actionPerformed(ActionEvent e ){
			 JButton btn = (JButton)e.getSource();
			 if (btn== btnInserisci ){
				final Connection con;        
				try{
                                    
					Database db=new Database();
					db.InserisciAttivita(txtNome.getText(),txtDescrizione.getText(),txtData.getText(),txtOra.getText(),txtPosti.getText(),txtPrezzo.getText());
                                        JOptionPane.showMessageDialog(null,"Prenotazione eseguita correttamente ");
					MenuGestore1 gestione =new MenuGestore1 (ut);
                                        finestra.dispose();
				}catch(ClassNotFoundException cs){
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Class ");
				}catch (SQLException cs) {
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Sql ");
				}
			 }
			 else if(btn==btnIndietro){
				 MenuGestore1 gestione =new MenuGestore1 (ut);
                                  finestra.dispose();
			 }
		}
	};
      
      
      
      
     finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		finestra.setSize(450, 450);
                
		btnInserisci.addActionListener(cs);
                btnIndietro.addActionListener(cs);
                
                pnlNome.add(lblNome);
                lblNome.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlNome.add(txtNome);
                txtNome.setPreferredSize(new java.awt.Dimension(100, 20));
                
		pnlDescrizione.add(lblDescrizione);
		lblDescrizione.setPreferredSize(new java.awt.Dimension(130, 20));
		pnlDescrizione.add(txtDescrizione);
		txtDescrizione.setPreferredSize(new java.awt.Dimension(250, 20));
		
		pnlData.add(lblData);
		lblData.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlData.add(txtData);
		txtData.setPreferredSize(new java.awt.Dimension(100, 20));
		
		pnlOra.add(lblOra);
		lblOra.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlOra.add(txtOra);
		txtOra.setPreferredSize(new java.awt.Dimension(100, 20));
		
		pnlPosti.add(lblPosti);
		lblPosti.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlPosti.add(txtPosti); 
		txtPosti.setPreferredSize(new java.awt.Dimension(100, 20));
		
		pnlPrezzo.add(lblPrezzo);
		lblPrezzo.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlPrezzo.add(txtPrezzo); 
		txtPrezzo.setPreferredSize(new java.awt.Dimension(100, 20));


		pnlInfo.add(lblInfo);
		lblInfo.setPreferredSize(new java.awt.Dimension(175, 20));
		pnlInfo.add(txtInfo);
		txtInfo.setPreferredSize(new java.awt.Dimension(243, 20));
		
		pnlBottoni.add(btnInserisci);
		btnInserisci.setPreferredSize(new java.awt.Dimension(120, 25));
		pnlBottoni.add(btnIndietro);
		btnIndietro.setPreferredSize(new java.awt.Dimension(82, 25));
		
                finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"gest.gif"));
		finestra.setLayout(new GridLayout(15,1));
		finestra.add(pnlNome);
                finestra.add(pnlSpazio);
                finestra.add(pnlDescrizione);
                finestra.add(pnlSpazio1);
                finestra.add(pnlData);
                finestra.add(pnlSpazio2);
                finestra.add(pnlOra);
                finestra.add(pnlSpazio3);
                finestra.add(pnlPosti);
                finestra.add(pnlSpazio4);
                finestra.add(pnlPrezzo);
                finestra.add(pnlSpazio5);
                finestra.add(pnlInfo);
                finestra.add(pnlSpazio6);
                finestra.add(pnlBottoni);
                
                
                
                

		finestra.setVisible(true);
                centerMe(finestra);
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