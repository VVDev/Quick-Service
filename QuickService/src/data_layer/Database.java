package data_layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Database {
	Connection connessione;
	
	/**
	 * 
	 * @param NomeDb Nome del database
	 * @param Host	 		   Macchina remota dove è installato mysql
	 * @param Porta	 		    Il demone dove runna mysql
	 * @param Uname	 		    UserName per accedere al db
	 * @param PassWd 		    Password per accedere al db
	 * @throws SQLException             Eccezione da gestire per il db
	 * @throws ClassNotFoundException	Eccezione da gestire se jdbc non è installato
	 */	

	public Database(String NomeDb,String Host,String Porta,String Uname,String PassWd)throws SQLException,ClassNotFoundException {
		String connStr="jdbc:mysql://"+Host+":"+Porta+"/"+NomeDb;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}catch (Exception e){
				System.out.println("Errore Database:" + e.getCause());
				throw new SQLException(e.getMessage());
			}
		try{
		connessione = DriverManager.getConnection(connStr,Uname,PassWd);
		}catch (Exception e) {
			System.out.println("Errore DataBase:" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
	}
	
	/**
	 * Leggerà i parametri da file 
	 * @throws SQLException Eccezione da gestire per il db
	 * @throws ClassNotFoundException	Eccezione da gestire se jdbc non è installato
	 */
	
	public Database()throws SQLException,ClassNotFoundException{
		try{
		String connStr="jdbc:mysql://localhost:3306/dbquick";
		String Uname="root";
		String PassWd="facile";
		Class.forName("com.mysql.jdbc.Driver");
		connessione = DriverManager.getConnection(connStr,Uname,PassWd);
        }catch (SQLException e) {
			System.out.println("Errore DataBase():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Errore DataBase():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
		
	}

        
        public Utente getLogin(String user , String pass) throws SQLException,Exception{
		Utente ut=null;
		
		try{
			int i=0;
			if (user.equals("")||pass.equals("")){
				throw new SQLException("E\' necessario inserere Nome Utente e Password!");
			}
			user.replace("'","''");
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spGetLogin(?,?)}");
			istruzione.setString(1, user);
			istruzione.setString(2, pass);
			ResultSet rs=istruzione.executeQuery();
			while (rs.next()){
				i++;
			}
			
			if (i>0){
				rs=istruzione.executeQuery();
				while(rs.next()){
					ut = new Utente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			}else{
				throw new Exception("Utente o password errata, utente inesistente ritentare");				
			}
		}catch (SQLException e) {
			System.err.println("Errore GetLogin:" + e.getMessage());
			throw new SQLException(e.getMessage());
		}catch (Exception e) {
			System.err.println("Errore GetLogin:" + e.getMessage());
			throw new Exception(e.getMessage());
		}
		return ut;
	}

        
        	public ArrayList<Attivita> getAttivita()throws SQLException{
		ArrayList<Attivita> attivita=new ArrayList<Attivita>();
		ResultSet rs;
		int i;
		try{
			java.sql.CallableStatement st=connessione.prepareCall("call spSelezionaAttivita()");
			
			rs = st.executeQuery();
			i=0;
			while(rs.next()){
				attivita.add(new Attivita(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),++i));
			}
		}catch(SQLException e){
			System.err.println("Errore getAttivita:" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
		return attivita;
	}
        
        
              public ArrayList<Prenotazioni> getPrenotazioni()throws SQLException{
		ArrayList<Prenotazioni> prenotazioni = new ArrayList<Prenotazioni>();
		ResultSet rs;
		int i;
		try{
			java.sql.CallableStatement st=connessione.prepareCall("call spVisualizzaPrenotazioni()");
			
			rs = st.executeQuery();
			i=0;
			while(rs.next()){
				prenotazioni.add(new Prenotazioni(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),++i));
			}
		}catch(SQLException e){
			System.err.println("Errore getPrenotazioni:" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
		return prenotazioni;
	}    
                
                
                
        public void InserisciPrenotazione(int Id,String Nome,String Cognome,int Posti , String Prenotato ,String Cf) throws SQLException 
        {
		try{
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spInsertPrenotazione(?,?,?,?,?,?)}");
			istruzione.setInt(1,Id);
			istruzione.setString(2, Nome);
			istruzione.setString(3, Cognome);
			istruzione.setInt(4, Posti);
                        istruzione.setString(5, Prenotato);
                        istruzione.setString(6, Cf);
                        
			istruzione.execute();
		}catch(SQLException e){
			System.err.println("Errore InserisciPrenotazione():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
        }        
                
          
        
                public void InserisciAttivita(String Nome,String Descrizione,String Data,String Ora,String Posti , String Prezzo) throws SQLException 
        {
		try{
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spInserisciAttivita(?,?,?,?,?,?)}");
			istruzione.setString(1, Nome);
			istruzione.setString(2, Descrizione);
			istruzione.setString(3, Data);
			istruzione.setString(4, Ora);
                        istruzione.setString(5, Posti);
                        istruzione.setString(6, Prezzo);
                        
			istruzione.execute();
		}catch(SQLException e){
			System.err.println("Errore InserisciAttivita():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
        } 
        
        
        
                
       public void ModificaAttivita(int Id,String Nome,String Descrizione,String Data,String Ora,String Posti , String Prezzo) throws SQLException 
        {
		try{
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spUpdateAttivita(?,?,?,?,?,?,?)}");
		        istruzione.setInt(1,Id);
                        istruzione.setString(2, Nome);
			istruzione.setString(3, Descrizione);
			istruzione.setString(4, Data);
			istruzione.setString(5, Ora);
                        istruzione.setString(6, Posti);
                        istruzione.setString(7, Prezzo);
                        
			istruzione.execute();
		}catch(SQLException e){
			System.err.println("Errore nella modifica dell attivita():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
        }    
                
               public void CancellaAttivita(int Id) throws SQLException 
        {
		try{
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spCancellaAttivita(?)}");
		        istruzione.setInt(1,Id);

                        
			istruzione.execute();
		}catch(SQLException e){
			System.err.println("Errore nella cancellazzione dell attivita():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
        }   
        
               
               
                public void InserisciGestore(String Cf,String Nome,String Cognome,String Usr , String Pwd ,String Ruolo) throws SQLException 
        {
		try{
			java.sql.CallableStatement istruzione=connessione.prepareCall("{call spInsertGestore(?,?,?,?,?,?)}");
			istruzione.setString(1,Cf);
			istruzione.setString(2, Nome);
			istruzione.setString(3, Cognome);
			istruzione.setString(4, Usr);
                        istruzione.setString(5, Pwd);
                        istruzione.setString(6, Ruolo);
                        
			istruzione.execute();
		}catch(SQLException e){
			System.err.println("Errore InserisciPrenotazione():" + e.getMessage());
			throw new SQLException(e.getMessage());
		}
        }            
               
               
               
               
	/**
	 * 
	 * @return la connessione attiva
	 */
	public Connection getConnessione(){
		return connessione;
	}

}


