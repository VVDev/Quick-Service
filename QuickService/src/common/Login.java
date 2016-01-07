/**
 * 
 */
package common;

import javax.swing.*;
import javax.*;
import control.algetLogin;
import java.awt.*;
import java.*;

public class Login {
	public Login(){
		UtilGC gc=new UtilGC();
		final JFrame Finestra = new JFrame (" ALBERGO LOGIN");
		
		JPanel BtnPanel = new JPanel();
		JPanel txtPanel = new JPanel();
		
		final JButton btnOk      = new JButton("OK");
		final JButton btnAnnulla = new JButton("ANNULLA");
		
		JLabel         lblUser     = new JLabel("UserName :");
		JLabel         lblPwd      = new JLabel("Password :");
		JTextField     txtUser     = new JTextField();
		JPasswordField txtPassword = new JPasswordField();
                
                Finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(gc.getImagePaths()+"login.gif"));
                
		algetLogin al = new algetLogin(btnOk,btnAnnulla,Finestra,txtUser,txtPassword);
                
		txtPanel.setLayout(new GridLayout(2,2));
		txtPanel.add(lblUser);
		txtPanel.add(txtUser);
		txtPanel.add(lblPwd);
		txtPanel.add(txtPassword);
		
		
		Finestra.setSize(400,200);
		Finestra.setLayout(new GridLayout(2,1));
		Finestra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		BtnPanel.add(btnOk);
		BtnPanel.add(btnAnnulla);
		
		Finestra.add(txtPanel);
		Finestra.add(BtnPanel);
		
		btnOk.addActionListener(al);
		btnAnnulla.addActionListener(al);
		centerMe(Finestra);
		Finestra.setVisible(true);
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
