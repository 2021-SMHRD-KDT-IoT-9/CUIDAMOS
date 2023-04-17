package com.smhrd.model;

public class WebMember1 {
	private String gu_id;
	private String pw;
	private String gu_name;
	private String address;
	private String phone;
	private String birth;
	private String gu_job;
	private String gender;
	private String furniture;

	@Override
	public String toString() {
		return "WebMember [gu_id=" + gu_id + ", pw=" + pw + ", gu_name=" + gu_name + ", address=" + address + ", phone="
				+ phone + ", birth=" + birth + ", gu_job=" + gu_job + ", gender=" + gender + ", furniture=" + furniture
				+ "]";
	}

	public WebMember1(String gu_id, String pw, String gu_name, String address, String phone, String birth, String gu_job,
			String gender, String furniture) {
		super();
		this.gu_id = gu_id;
		this.pw = pw;
		this.gu_name = gu_name;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.gu_job = gu_job;
		this.gender = gender;
		this.furniture = furniture;
	}

	public WebMember1() {
		super();
	}

	public WebMember1(String gu_id, String pw) {
		this.gu_id = gu_id;
		this.pw = pw;
	}

	public String getGu_id() {
		return gu_id;
	}

	public String getPw() {
		return pw;
	}

	public String getGu_name() {
		return gu_name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirth() {
		return birth;
	}

	public String getGu_job() {
		return gu_job;
	}

	public String getGender() {
		return gender;
	}

	public String getFurniture() {
		return furniture;
	}	


}
