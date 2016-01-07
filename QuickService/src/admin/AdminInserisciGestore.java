/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

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
public class AdminInserisciGestore {  private Utente ut;
	 public AdminInserisciGestore (Utente u)
		{
                 ut=u; 
                 UtilGC gc = new UtilGC();
             final JFrame finestra       = new JFrame("Gestione Cinema - Inserisci Gestore");
             JPanel pnlCf                = new JPanel();
             JPanel pnlSpazio 		 = new JPanel();
	     JPanel pnlNome              = new JPanel();
             JPanel pnlSpazio1 		 = new JPanel();
             JPanel pnlCognome 		 = new JPanel();
             JPanel pnlSpazio2 		 = new JPanel();
             JPanel pnlUsr 		 = new JPanel();
             JPanel pnlSpazio3 		 = new JPanel();
             JPanel pnlPwd 		 = new JPanel();
             JPanel pnlSpazio4 		 = new JPanel();
             JPanel pnlRuolo 		 = new JPanel();
             JPanel pnlSpazio5 		 = new JPanel(); 
             JPanel pnlBottoni 		 = new JPanel();
                 
      JLabel           lblCf = new JLabel(" Codice Fiscale");
      final JTextField txtCf = new JTextField();    
      
      JLabel           lblNome =new JLabel(" NOME ");
      final JTextField txtNome =new JTextField();
      
      JLabel           lblCognome =new JLabel(" COGNOME");
      final JTextField txtCognome =new JTextField();
      
      JLabel           lblUsr = new JLabel(" USERNAME");
      final JTextField txtUsr = new JTextField();
      
      JLabel           lblPwd = new JLabel(" PASSWORD");
      final JTextField txtPwd = new JTextField();
      
      final JTextField txtRuolo =new JTextField("002");
      
      
      final JButton btnInserisci = new JButton("Inserisci");
      final JButton btnIndietro  = new JButton("Indietro");
      
      
      	 ActionListener cs = new  ActionListener(){
  
		public void actionPerformed(ActionEvent e ){
			 JButton btn = (JButton)e.getSource();
			 if (btn== btnInserisci ){
				final Connection con;        
				try{
                                    
					Database db=new Database();
					db.InserisciGestore(txtCf.getText(),txtNome.getText(),txtCognome.getText(),txtUsr.getText(),txtPwd.getText(),txtRuolo.getText());
                                        JOptionPane.showMessageDialog(null,"Inserimento eseguito correttamente ");
					finestra.dispose();
				}catch(ClassNotFoundException cs){
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Class ");
				}catch (SQLException cs) {
						JOptionPane.showMessageDialog(null,""+cs.toString()+": Fatal Error Sql ");
				}
			 }
			 else if(btn==btnIndietro){
				 MenuAdmin admin =new MenuAdmin (ut);
                                  finestra.dispose();
			 }
		}
	};
      
             finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		finestra.setSize(450, 450);
                
		btnInserisci.addActionListener(cs);
                btnIndietro.addActionListener(cs);
                
                
                pnlCf.add(lblCf);
                lblCf.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlCf.add(txtCf);
                txtCf.setPreferredSize(new java.awt.Dimension(120, 20));
                
                
                pnlNome.add(lblNome);
                lblNome.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlNome.add(txtNome);
                txtNome.setPreferredSize(new java.awt.Dimension(100, 20));
                
                
                pnlCognome.add(lblCognome);
                lblCognome.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlCognome.add(txtCognome);
                txtCognome.setPreferredSize(new java.awt.Dimension(100, 20));
                
                
                pnlUsr.add(lblUsr);
                lblUsr.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlUsr.add(txtUsr);
                txtUsr.setPreferredSize(new java.awt.Dimension(100, 20));
                
                
                pnlPwd.add(lblPwd);
                lblPwd.setPreferredSize(new java.awt.Dimension(100, 20));
                pnlPwd.add(txtPwd);
                txtPwd.setPreferredSize(new java.awt.Dimension(100, 20));
                
                pnlBottoni.add(btnInserisci);
		btnInserisci.setPreferredSize(new java.awt.Dimension(120, 25));
		pnlBottoni.add(btnIndietro);
		btnIndietro.setPreferredSize(new java.awt.Dimension(82, 25));
		
                
                finestra.setLayout(new GridLayout(12,1));
                finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"admin.gif"));
                finestra.add(pnlCf);
                finestra.add(pnlSpazio);
                finestra.add(pnlNome);
                finestra.add(pnlSpazio1);
                finestra.add(pnlCognome);
                finestra.add(pnlSpazio2);
                finestra.add(pnlUsr);
                finestra.add(pnlSpazio3);
                finestra.add(pnlPwd);
                finestra.add(pnlSpazio4);
                finestra.add(pnlBottoni);
                finestra.add(pnlSpazio5);
                
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