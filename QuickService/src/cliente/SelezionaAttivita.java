package cliente;

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


public class SelezionaAttivita {
    private Utente ut;
    private Attivita attivita;
	 public SelezionaAttivita (Utente u,Attivita s)
		{
                 ut=u;
                 attivita = s;
                 UtilGC gc = new UtilGC();
		 final JFrame finestra = new JFrame("Gestione Cinema - Prenota l attivita Scelta");  //  @jve:decl-index=0:visual-constraint="135,33"
	     
		 JPanel pnlTitolo        = new JPanel();
	     JPanel pnlDescrizione       = new JPanel();
	     JPanel pnlBigliettidis      = new JPanel();
	     JPanel pnlPrenota 		 = new JPanel();
	     JPanel pnlSpazio1 		 = new JPanel();
             JPanel pnlBigliettipre      = new JPanel();
             JPanel pnlPostiPrenota      = new JPanel();
             JPanel pnlSepara      	 = new JPanel();
             JPanel pnlOpzioni     	 = new JPanel();
             JPanel pnlOpzioniScelta     = new JPanel();
             JPanel pnlDavendere         = new JPanel();
             JPanel pnlSpazio3 		 = new JPanel();
             JPanel pnlBottoni 		 = new JPanel();
             JPanel pnlSpazio4 		 = new JPanel();
      
      final JTextField txtIDAttivita =new JTextField(attivita.getID());
      final JTextField txtPrenota =new JTextField("SI");
      
      
      JLabel lblDescrizione=new JLabel(" DESCRIZIONE ATTIVITA");
      final JTextField txtDescrione =new JTextField(attivita.getDescrizione());
      
      JLabel lblData=new JLabel("Data");
      final JTextField txtData =new JTextField(attivita.getData());
      
      JLabel lblOra=new JLabel("     Ora");
      final JTextField txtOra =new JTextField(attivita.getOra());
     
      JLabel lblBigliettidis = new JLabel(" Posti Disponibili");
      final JTextField txtPosti =new JTextField(String.valueOf(attivita.getPostiD()));
      
      JLabel lblPrenota=new JLabel("    PRENOTAZIONE");
      
      JLabel lblNome=new JLabel("       Nome");
      final JTextField txtNome =new JTextField();
      
      JLabel lblCognome = new JLabel("       Cognome");
      final JTextField txtCognome =new JTextField();
      
      JLabel lblPostiPrenota = new JLabel(" Posti da prenotare");
      JLabel lblVuoto = new JLabel("#");
      final JTextField txtPostiPrenota =new JTextField();
      
      JLabel lblSepara = new JLabel("-----------------------------------------------------------------------------------------");
      JLabel lblOpzioni = new JLabel("OPZIONI SPECIALI");
      
      
//      JLabel lblAdulti = new JLabel("Num.Adulti");
//      final JTextField txtAdulti =new JTextField();
//      
//      JLabel lblBambini = new JLabel("      Num.Bambini");
//      final JTextField txtBambini =new JTextField();
      
      JLabel lblInfo= new JLabel("Specifiche sulla prenotazione");
      final JTextField txtInfo =new JTextField();
      
      final JButton btnPrenota = new JButton("PRENOTA");
      final JButton btnIndietro = new JButton("INDIETRO");
      
      
      	 ActionListener cs = new  ActionListener(){
  
		public void actionPerformed(ActionEvent e ){
			 JButton btn = (JButton)e.getSource();
			 if (btn== btnPrenota ){
				final Connection con;        
				try{
                                  
                                    
					Database db=new Database();
					db.InserisciPrenotazione(Integer.valueOf(txtIDAttivita.getText().valueOf(attivita.getID())), txtNome.getText(), txtCognome.getText(), Integer.parseInt(txtPostiPrenota.getText()),txtPrenota.getText(), String.valueOf(ut.getCf()));
                                        JOptionPane.showMessageDialog(null,"Prenotazione eseguita correttamente ");
                                        GestioneClienteFrame utente = new GestioneClienteFrame(ut);
					finestra.dispose();
				}catch(ClassNotFoundException cs){
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Class ");
				}catch (SQLException cs) {
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Sql ");
				}
			 }
			 else if(btn==btnIndietro){
				 GestioneClienteFrame gestione =new GestioneClienteFrame (ut);
                                  finestra.dispose();
			 }
		}
	};
      
      
      
      
     finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		finestra.setSize(450, 450);
                
		btnPrenota.addActionListener(cs);
                btnIndietro.addActionListener(cs);
                
		pnlTitolo.add(lblDescrizione);
		lblDescrizione.setPreferredSize(new java.awt.Dimension(157, 20));
		pnlDescrizione.add(txtDescrione);
		txtDescrione.setPreferredSize(new java.awt.Dimension(340, 20));
		
		pnlBigliettidis.add(lblData);
		lblData.setPreferredSize(new java.awt.Dimension(26, 20));
		pnlBigliettidis.add(txtData);
		txtData.setPreferredSize(new java.awt.Dimension(75, 20));
		
		pnlBigliettidis.add(lblOra);
		lblOra.setPreferredSize(new java.awt.Dimension(36, 20));
		pnlBigliettidis.add(txtOra);
		txtOra.setPreferredSize(new java.awt.Dimension(55, 20));
		
		pnlBigliettidis.add(lblBigliettidis);
		lblBigliettidis.setPreferredSize(new java.awt.Dimension(109, 20));
		pnlBigliettidis.add(txtPosti); 
		txtPosti.setPreferredSize(new java.awt.Dimension(30, 20));
		
		
		pnlPrenota.add(lblPrenota);
		lblPrenota.setPreferredSize(new java.awt.Dimension(125, 20));
		
		pnlBigliettipre.add(lblNome); 
		lblNome.setPreferredSize(new java.awt.Dimension(55, 20));
		pnlBigliettipre.add(txtNome); 
		txtNome.setPreferredSize(new java.awt.Dimension(104, 20));
		
		pnlBigliettipre.add(lblCognome); 
		lblCognome.setPreferredSize(new java.awt.Dimension(78, 20));
		pnlBigliettipre.add(txtCognome); 
		txtCognome.setPreferredSize(new java.awt.Dimension(107, 20));
		
		pnlPostiPrenota.add(lblPostiPrenota);
		lblPostiPrenota.setPreferredSize(new java.awt.Dimension(117, 20));
		pnlPostiPrenota.add(txtPostiPrenota); 
		txtPostiPrenota.setPreferredSize(new java.awt.Dimension(34, 20));
		pnlPostiPrenota.add(lblVuoto);
		lblVuoto.setPreferredSize(new java.awt.Dimension(161, 20));
		
		pnlSepara.add(lblSepara);
		pnlOpzioni.add(lblOpzioni);
		lblOpzioni.setPreferredSize(new java.awt.Dimension(104, 20));
		
//		pnlOpzioniScelta.add(lblAdulti);
//		lblAdulti.setPreferredSize(new java.awt.Dimension(63, 20));
//		pnlOpzioniScelta.add(txtAdulti);
//		txtAdulti.setPreferredSize(new java.awt.Dimension(37, 20));
//		
//		pnlOpzioniScelta.add(lblBambini);
//		lblBambini.setPreferredSize(new java.awt.Dimension(96, 20));
//		pnlOpzioniScelta.add(txtBambini);
//		txtBambini.setPreferredSize(new java.awt.Dimension(26, 20));
//		
		
		pnlDavendere.add(lblInfo);
		lblInfo.setPreferredSize(new java.awt.Dimension(175, 20));
		pnlDavendere.add(txtInfo);
		txtInfo.setPreferredSize(new java.awt.Dimension(243, 20));
		
		pnlBottoni.add(btnPrenota);
		btnPrenota.setPreferredSize(new java.awt.Dimension(120, 25));
		pnlBottoni.add(btnIndietro);
		btnIndietro.setPreferredSize(new java.awt.Dimension(90, 25));
		
                finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"utenti.gif"));
		finestra.setLayout(new GridLayout(14,2));
		finestra.add(pnlTitolo);
		finestra.add(pnlDescrizione);
		finestra.add(pnlBigliettidis);
		finestra.add(pnlSpazio1);
		finestra.add(pnlPrenota);
		finestra.add(pnlBigliettipre);
		finestra.add(pnlPostiPrenota);
		finestra.add(pnlSepara);
		finestra.add(pnlOpzioni);
		finestra.add(pnlOpzioniScelta);
		finestra.add(pnlDavendere);
		finestra.add(pnlSpazio3);
		finestra.add(pnlBottoni);
		finestra.add(pnlSpazio4);
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