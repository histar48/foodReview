package bean;

import java.util.List;

public class ResListVo {
	int resSerial;
	String resName;
	String resPhone;
	String resSite;
	String resPostal;
	String resAddress;
	String resRdate;
	String resCategory;
	String resOpentime;
	String resClosetime;
	String resHoliday;
	int resState;
	String resScore;
	int resHit;
	String resLocation;
	String resContent;
	
	// DB저장파일명 리스트
	List<String> resAttFiles;
	// 원본파일명 리스트
	List<String> resOriFiles;
	// 삭제된파일명 리스트
	List<String> resDelFiles;
	
	// 게시판 목록 JSON타입으로 변환
	public String toListJson() {
		String str = String.format("{'resSerial':'%d', 'resName':'%s', 'resAddr':'%s', 'resScore':'%s', 'resHit':'%d'}", resSerial, resName, resLocation, resScore, resHit);
		return str.replaceAll("'", "\"");
	}
	
	// 가게정보 JSON타입으로 변환
	public String toViewJson() {
		String str = String.format("{"
				+ "'resSerial':'%d', "
				+ "'resName':'%s', "
				+ "'resPhone':'%s', "
				+ "'resSite':'%s', "
				+ "'resAddress':'%s', "
				+ "'resCategory':'%s', "
				+ "'resOpentime':'%s', "
				+ "'resClosetime':'%s', "
				+ "'resHoliday':'%s', "
				+ "'resScore':'%2.1f', "
				+ "'resAttFiles':'%s'"
				+ "}", resSerial, resName, resPhone, resSite, resAddress, resCategory, resOpentime, resClosetime, resHoliday, resScore, resAttFiles.toString());
		return str.replaceAll("'", "\"");
	}
	
	// getter, setter

	public String getResContent() {
		return resContent;
	}
	public void setResContent(String resContent) {
		this.resContent = resContent;
	}
	public int getResSerial() {
		return resSerial;
	}
	public void setResSerial(int resSerial) {
		this.resSerial = resSerial;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public String getResSite() {
		return resSite;
	}
	public void setResSite(String resSite) {
		this.resSite = resSite;
	}
	public String getResPostal() {
		return resPostal;
	}
	public void setResPostal(String resPostal) {
		this.resPostal = resPostal;
	}
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public String getResRdate() {
		return resRdate;
	}
	public void setResRdate(String resRdate) {
		this.resRdate = resRdate;
	}
	public String getResCategory() {
		return resCategory;
	}
	public void setResCategory(String resCategory) {
		this.resCategory = resCategory;
	}
	public String getResOpentime() {
		return resOpentime;
	}
	public void setResOpentime(String resOpentime) {
		this.resOpentime = resOpentime;
	}
	public String getResClosetime() {
		return resClosetime;
	}
	public void setResClosetime(String resClosetime) {
		this.resClosetime = resClosetime;
	}
	public String getResHoliday() {
		return resHoliday;
	}
	public void setResHoliday(String resHoliday) {
		this.resHoliday = resHoliday;
	}
	public int getResState() {
		return resState;
	}
	public void setResState(int resState) {
		this.resState = resState;
	}
	public String getResScore() {
		return resScore;
	}
	public void setResScore(String resScore) {
		this.resScore = resScore;
	}
	public int getResHit() {
		return resHit;
	}
	public void setResHit(int resHit) {
		this.resHit = resHit;
	}
	public String getResLocation() {
		return resLocation;
	}
	public void setResLocation(String resLocation) {
		this.resLocation = resLocation;
	}
	public List<String> getResAttFiles() {
		return resAttFiles;
	}
	public void setResAttFiles(List<String> resAttFiles) {
		this.resAttFiles = resAttFiles;
	}
	public List<String> getResOriFiles() {
		return resOriFiles;
	}
	public void setResOriFiles(List<String> resOriFiles) {
		this.resOriFiles = resOriFiles;
	}
	public List<String> getResDelFiles() {
		return resDelFiles;
	}
	public void setResDelFiles(List<String> resDelFiles) {
		this.resDelFiles = resDelFiles;
	}
}
