package bean;

public class ScoreBoardAttVo {
	int serial;
	int pSerial;
	String attFile;
	String oriFile;
	
	public ScoreBoardAttVo() {
		
		
	}
	
	public String toJSON() {
		String str ="";
		
		return str;
		
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getpSerial() {
		return pSerial;
	}

	public void setpSerial(int pSerial) {
		this.pSerial = pSerial;
	}

	public String getAttFile() {
		return attFile;
	}

	public void setAttFile(String attFile) {
		this.attFile = attFile;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}
	

}
