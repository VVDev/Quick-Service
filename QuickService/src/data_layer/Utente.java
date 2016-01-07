
package data_layer;


import Interfacce.iUtente;

public class Utente implements iUtente {

	private String Cf;
	private String Nome;
	private String Cognome;
	private String UserName;
	private String Password;
	private String CodiceRuolo;

	public Utente(){
		Cf="";
		Nome="";
		Cognome="";
		UserName="";
		Password="";
		CodiceRuolo="";

	}
	public Utente(String cf,String nome,String cognome,String username,String password,String codiceruolo){
		Cf=cf;
		Nome=nome;
		Cognome=cognome;
		UserName=username;
		Password=password;
		CodiceRuolo=codiceruolo;

	}

	public String getCf() {
		return Cf;
	}

	public void setCf(String cf) {
		Cf = cf;
	}

	public String getCodiceRuolo() {
		return CodiceRuolo;
	}

	public void setCodiceRuolo(String codiceRuolo) {
		CodiceRuolo = codiceRuolo;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
}
