package control;

import admin.MenuAdmin;
import cliente.MenuCliente;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.UtilGC;

import data_layer.Database;

import data_layer.Utente;
import gestore.MenuGestore;

public class algetLogin implements ActionListener {

	private JButton btnAnnulla;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnOk;
	private Utente utente;
	private JFrame frame;
	private UtilGC utils;
	public algetLogin(JButton o,JButton a,JFrame f,JTextField u,JTextField p){
		btnAnnulla =a;
		btnOk=o;
		frame=f;
		txtUser=u;
		txtPass=p;
		utils = new UtilGC();
	}
	
	public void actionPerformed(ActionEvent evento){
		Object s=evento.getSource();
		
		if (s==btnOk){
			
					try{
						Database db=new Database();
						utente=db.getLogin(txtUser.getText(), txtPass.getText());
						if (utente.equals(null))
							JOptionPane.showMessageDialog(frame,new String("Nome utente o password errati, ritentare"),"Login",JOptionPane.DEFAULT_OPTION);
						else{
							if (utente.getCodiceRuolo().equals(utils.getCodiceA()))
								new MenuAdmin(utente);
							if (utente.getCodiceRuolo().equals(utils.getCodiceG()))
								new MenuGestore(utente);
							if(utente.getCodiceRuolo().equals(utils.getCodiceS()))
								new MenuCliente(utente);
							frame.dispose();
						}
					}catch (SQLException e) {
						JOptionPane.showMessageDialog(frame,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
					}catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(frame,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
					}catch (Exception e) {
						JOptionPane.showMessageDialog(frame,e.getMessage(),"Errore",JOptionPane.ERROR_MESSAGE);
					}
		}
		else if(s==btnAnnulla){
			frame.dispose();
		}
	}
}
