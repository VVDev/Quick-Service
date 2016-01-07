
package gestore;

import com.mysql.jdbc.Connection;
import common.UtilGC;
import data_layer.Attivita;
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




public class GestioneModificaAttivita1 {
    private Utente ut;
    private Attivita attivita;
	 public GestioneModificaAttivita1 (Utente u,Attivita s)
		{
                 ut=u;
                 attivita = s;
                 UtilGC gc = new UtilGC();
		 final JFrame finestra = new JFrame("Gestione Cinema - Modifica un attivita");  //  @jve:decl-index=0:visual-constraint="135,33"
	     
             JPanel pnlNome              = new JPanel();
             JPanel pnlSpazio 		 = new JPanel();
	     JPanel pnlDescrizione       = new JPanel();
             JPanel pnlSpazio1 		 = new JPanel();
             JPanel pnlData 		 = new JPanel();
             JPanel pnlSpazio2 		 = new JPanel();
             JPanel pnlOra 		 = new JPanel();
             JPanel pnlSpazio3 		 = new JPanel();
             JPanel pnlPostiA 		 = new JPanel();
             JPanel pnlSpazio4 		 = new JPanel();
             JPanel pnlPrezzo 		 = new JPanel();
             JPanel pnlSpazio6 		 = new JPanel(); 
             JPanel pnlBottoni 		 = new JPanel();
            
      final JTextField txtIDAttivita =new JTextField(attivita.getID());


      
      JLabel lblNome=new JLabel("NOME ATTIVITA");
      final JTextField txtNome =new JTextField(attivita.getNome());
      
      JLabel lblDescrizione=new JLabel("DESCRIZIONE ATTIVITA");
      final JTextField txtDescrizione =new JTextField(attivita.getDescrizione());
      
      JLabel lblData=new JLabel("Data");
      final JTextField txtData =new JTextField(attivita.getData());
      
      JLabel lblOra =new JLabel("Ora");
      final JTextField txtOra = new JTextField (attivita.getOra());
     
      JLabel lblPostiA = new JLabel("Posti Disponibili");
      final JTextField txtPostiA = new JTextField(String.valueOf(attivita.getPostiD()));
      
      JLabel lblPrezzo = new JLabel("Prezzo");
      final JTextField txtPrezzo =new JTextField(attivita.getPrezzo());
      
      final JButton btnModifica = new JButton("Salva Modifiche");
      final JButton btnIndietro = new JButton("Indietro");
      
      
      	 ActionListener cs = new  ActionListener(){
  
		public void actionPerformed(ActionEvent e ){
			 JButton btn = (JButton)e.getSource();
			 if (btn== btnModifica ){
				final Connection con;        
				try{
                                    
					Database db=new Database();
					db.ModificaAttivita(Integer.valueOf(txtIDAttivita.getText().valueOf(attivita.getID())),txtNome.getText(),txtDescrizione.getText(),txtData.getText(),txtOra.getText(),txtPostiA.getText(),txtPrezzo.getText());
                                        JOptionPane.showMessageDialog(null,"Modifica eseguita correttamente ");
					GestioneModificaAttivita gestione =new GestioneModificaAttivita (ut);
                                        finestra.dispose();
				}catch(ClassNotFoundException cs){
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Class ");
				}catch (SQLException cs) {
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Sql ");
				}
			 }
			 else if(btn==btnIndietro){
				 GestioneModificaAttivita gestione =new GestioneModificaAttivita (ut);
                                  finestra.dispose();
			 }
		}
	};
      
      
      
      
     finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		finestra.setSize(450, 450);
                
		btnModifica.addActionListener(cs);
                btnIndietro.addActionListener(cs);
                
                pnlNome.add(lblNome);
                lblNome.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlNome.add(txtNome);
                txtNome.setPreferredSize(new java.awt.Dimension(100, 20));
                
		pnlDescrizione.add(lblDescrizione);
		lblDescrizione.setPreferredSize(new java.awt.Dimension(150, 20));
		pnlDescrizione.add(txtDescrizione);
		txtDescrizione.setPreferredSize(new java.awt.Dimension(250, 20));
		
		pnlData.add(lblData);
		lblData.setPreferredSize(new java.awt.Dimension(26, 20));
		pnlData.add(txtData);
		txtData.setPreferredSize(new java.awt.Dimension(75, 20));
		
		pnlOra.add(lblOra);
		lblOra.setPreferredSize(new java.awt.Dimension(36, 20));
		pnlOra.add(txtOra);
		txtOra.setPreferredSize(new java.awt.Dimension(55, 20));
		
		pnlPostiA.add(lblPostiA);
		lblPostiA.setPreferredSize(new java.awt.Dimension(120, 20));
                pnlPostiA.add(txtPostiA);
                txtPostiA.setPreferredSize(new java.awt.Dimension(40, 20));
                
		pnlPrezzo.add(lblPrezzo);
		lblPrezzo.setPreferredSize(new java.awt.Dimension(109, 20));
		pnlPrezzo.add(txtPrezzo); 
		txtPrezzo.setPreferredSize(new java.awt.Dimension(40, 20));pnlNome.add(lblNome);
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
		
		pnlPostiA.add(lblPostiA);
		lblPostiA.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlPostiA.add(txtPostiA); 
		txtPostiA.setPreferredSize(new java.awt.Dimension(100, 20));
		
		pnlPrezzo.add(lblPrezzo);
		lblPrezzo.setPreferredSize(new java.awt.Dimension(100, 20));
		pnlPrezzo.add(txtPrezzo); 
		txtPrezzo.setPreferredSize(new java.awt.Dimension(100, 20));


		pnlBottoni.add(btnModifica);
		btnModifica.setPreferredSize(new java.awt.Dimension(150, 25));
		pnlBottoni.add(btnIndietro);
		btnIndietro.setPreferredSize(new java.awt.Dimension(82, 25));
		
                finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"gest.gif"));
		finestra.setLayout(new GridLayout(14,1));
		finestra.add(pnlNome);
                finestra.add(pnlSpazio);
                finestra.add(pnlDescrizione);
                finestra.add(pnlSpazio1);
                finestra.add(pnlData);
                finestra.add(pnlSpazio2);
                finestra.add(pnlOra);
                finestra.add(pnlSpazio3);
                finestra.add(pnlPostiA);
                finestra.add(pnlSpazio4);
                finestra.add(pnlPrezzo);

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