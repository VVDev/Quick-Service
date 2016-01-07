
package control;

import cliente.GestioneClienteFrame;
import data_layer.Database;
import data_layer.Utente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class alInserisciPrenotazione implements ActionListener{
        
        private JButton    btnInserisci;
        private JButton btnIndietro;
        private JTextField txtIdAttivita;
	private JTextField txtNome;
	private JTextField txtCognome;
        private JTextField txtPosti;
        private JTextField txtPrenotato;
	private Utente     ut;
        private JFrame frame;
        
	public alInserisciPrenotazione(JFrame fr,JButton btnI,JButton btnE,JTextField txtId,JTextField txtN,JTextField txtC,JTextField txtPost,JTextField txtPre,Utente u){
		btnInserisci  = btnI;
                btnIndietro   = btnE;
		txtIdAttivita = txtId;
                txtNome       = txtN;
                txtCognome    = txtC;
		txtPosti      = txtPost;
                txtPrenotato  = txtPre;
                frame         = fr;
		ut            = u;
	}
	public void actionPerformed(ActionEvent e ){
		 JButton btn = (JButton)e.getSource();
		 if (btn==btnInserisci){
			try{
                                     Database db=new Database();	
			             db.InserisciPrenotazione(Integer.parseInt(txtIdAttivita.getText()), txtNome.getText(), txtCognome.getText(), Integer.parseInt(txtPosti.getText()),"si", ut.getCf());
				JOptionPane.showMessageDialog(frame,"Operazione effettauta");
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(frame,ex.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
			}catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(frame,ex.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
			}
		 }
		 else if(btn==btnIndietro){
			 GestioneClienteFrame gestione =new GestioneClienteFrame (ut);
                         frame.dispose();
		 }
	}

}
