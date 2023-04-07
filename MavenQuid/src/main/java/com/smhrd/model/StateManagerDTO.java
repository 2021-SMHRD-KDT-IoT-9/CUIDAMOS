package com.smhrd.model;

public class StateManagerDTO {
	private String sm_mumber;
	private String ui_idfk;
	private String sensor;
	private String registration;
	private String result_division;
	private String result_date;

	@Override
	public String toString() {
		return "StateManager [sm_mumber=" + sm_mumber + ", ui_idfk=" + ui_idfk + ", sensor=" + sensor + ", registration="
				+ registration + ", result_division=" + result_division + ", result_date=" + result_date + "]";
	}

	public StateManagerDTO(String sm_mumber, String ui_idfkfk, String sensor, String registration, String result_division,
			String result_date) {
		super();
		this.sm_mumber = sm_mumber;
		this.ui_idfk = ui_idfkfk;
		this.sensor = sensor;
		this.registration = registration;
		this.result_division = result_division;
		this.result_date = result_date;
	}

	public StateManagerDTO() {
		super();
	}

	public String getSm_mumber() {
		return sm_mumber;
	}

	public String getUi_idfk() {
		return ui_idfk;
	}

	public String getSensor() {
		return sensor;
	}

	public String getRegistration() {
		return registration;
	}

	public String getResult_division() {
		return result_division;
	}

	public String getResult_date() {
		return result_date;
	}

}
