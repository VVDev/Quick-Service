package data_layer;


import interfacce.iAttivita;

public class Attivita implements iAttivita {
	    
	        private int ID;
		private String Nome;
		private String Descrizione;
		private String Data;
		private String Ora;
		private int PostiD;
		private String Prezzo;
		
		private int Indice;
		

            public Attivita (){
		
		ID=0;
		Nome="";
		Descrizione="";
		Data= "";
		Ora = "";
		PostiD=0;
		Prezzo ="";
		Indice =0;
		
		
	}
                
                
	public Attivita (int ids,String n,String d,String dt,String o,int p,String pr,int i){
		
		ID=ids;
		Nome=n;
		Descrizione=d;
		Data= dt;
		Ora = o;
		PostiD=p;
		Prezzo =pr;
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



	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrzione(String descrizione) {
		Descrizione = descrizione;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data){
		Data = data;
	}
	
	public String getOra() {
		return Ora;
	}

	public void setOra(String ora){
		Ora = ora;
	}

	public int getPostiD() {
		return PostiD;
	}

	public void setPostiD(int postiD) {
		PostiD = postiD;
	}
	
	public String getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(String prezzo){
		Prezzo = prezzo;
	}


	public int getIndice() {
		return Indice;
	}

	public void setIndice(int indice) {
		Indice = indice;
	}

    public void setDescrizione(String descrizione) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}