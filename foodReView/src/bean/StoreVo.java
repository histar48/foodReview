package bean;


public class StoreVo {
	String id;
	String pwd;
	String irum;
	String email;
	String phone;
	String rdate;
	String postal;
	String address;
	String photo;
	String photoOri;
	String pwd_chk;
	
	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if(o instanceof StoreVo) {
			StoreVo vo = (StoreVo) o;
			if(vo.getId().equals(this.id) && vo.getIrum().equals(this.irum)) {
				b = true;
			}
		}
		return b;  // false
	}
	
	@Override
	public int hashCode() {
		int code = id.hashCode() + irum.hashCode();
		return code;
		//return Objects.hash(this.id, this.name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String name) {
		this.irum = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhotoOri() {
		return photoOri;
	}

	public void setPhotoOri(String photoOri) {
		this.photoOri = photoOri;
	}

	public String getPwd_chk() {
		return pwd_chk;
	}

	public void setPwd_chk(String pwd_chk) {
		this.pwd_chk = pwd_chk;
	}
}
