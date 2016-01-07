/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data_layer;

/**
 *
 * @author user
 */
public class Prenotazioni {

                private int ID;
		private String Nome;
		private String Cognome;
		private int PostiD;
		private String Cf;
                private String Pre;
		private int Indice;
                
    public Prenotazioni (int ids,String n,String c,int p,String cf, String pr,int i){
		
		ID=ids;
		Nome=n;
		Cognome = c;
		PostiD=p;
		Cf =cf;
                Pre = pr;
		Indice =i;
		
	}
    
    
    
        public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}
	
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
    
    
        public String getCognome() {
	return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}
        
        
       public int getPosti() {
		return PostiD;
	}

	public void setPosti(int posti) {
		PostiD = posti;
	} 
        
        
        public String getCf() {
		return Cf;
	}

	public void setCf(String cf) {
		Cf = cf;
	}
        
        
        public String getPrenotato() {
        return Pre;
	}

	public void setPrenotato(String pr) {
		Pre = pr;
	}
        
        
        public int getIndice() {
		return Indice;
	}

	public void setIndice(int indice) {
		Indice = indice;
	}
        
        
        
}
