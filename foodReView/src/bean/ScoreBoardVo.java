package bean;

public class ScoreBoardVo {
	int serial;
	int pSerial;
	String content;
	String mdate;
	String id;
	int score;
	
	String attFile;
	String orFile;
	
	
	
	public ScoreBoardVo() {
		
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



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getMdate() {
		return mdate;
	}



	public void setMdate(String mdate) {
		this.mdate = mdate;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}

	public String getAttFile() {
		return attFile;
	}

	public void setAttFile(String attFile) {
		this.attFile = attFile;
	}

	public String getOrFile() {
		return orFile;
	}

	public void setOrFile(String orFile) {
		this.orFile = orFile;
	}

	public int getpSerial() {
		return pSerial;
	}

	public void setpSerial(int pSerial) {
		this.pSerial = pSerial;
	}
	
	
	
}
