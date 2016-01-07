package common;

public class UtilGC {
	
        private String CodiceA;
	private String CodiceG;
	private String CodiceS;
	private String ImagePaths;

        
        
	public UtilGC(){
		
                CodiceA="001";
		CodiceG="002";
		CodiceS="003";
		
		ImagePaths=new String("C:\\Progetti\\QuickService\\src\\images\\");

	}


	public String getCodiceA() {
		return CodiceA;
	}

	public void setCodiceA(String codiceA) {
		CodiceA = codiceA;
	}

	public String getCodiceG() {
		return CodiceG;
	}

	public void setCodiceG(String codiceG) {
		CodiceG = codiceG;
	}

	public String getCodiceS() {
		return CodiceS;
	}

	public void setCodiceS(String codiceS) {
		CodiceS = codiceS;
	}
        
        public String getImagePaths() {
	return ImagePaths;
	}

	public void setImagePaths(String imagePaths) {
		ImagePaths = imagePaths;
	}


}
