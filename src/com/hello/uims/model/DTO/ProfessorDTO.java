package com.hello.uims.model.DTO;

import java.sql.Date;

public class ProfessorDTO {

	private int profNo; // 교수 번호
	private String deptCode; // 학과 코드
	private String profId; // 교수 아이디
	private String profPwd; // 교수 비밀번호
	private String profName; // 교수 이름
	private String address; // 교수 주소
	private String profTelNo; // 교수 전화번호
	private String email; // 교수 이메일
	private Date enrollDate; // 교수 입사일
	private char status; // 재직상태

	public ProfessorDTO() {

	}

	public ProfessorDTO(int profNo, String deptCode, String profId, String profPwd, String profName, String address,
			String profTelNo, String email, Date enrollDate, char status) {
		this.profNo = profNo;
		this.deptCode = deptCode;
		this.profId = profId;
		this.profPwd = profPwd;
		this.profName = profName;
		this.address = address;
		this.profTelNo = profTelNo;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
	}

	public int getProfNo() {
		return profNo;
	}

	public void setProfNo(int profNo) {
		this.profNo = profNo;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	public String getProfPwd() {
		return profPwd;
	}

	public void setProfPwd(String profPwd) {
		this.profPwd = profPwd;
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfTelNo() {
		return profTelNo;
	}

	public void setProfTelNo(String profTelNo) {
		this.profTelNo = profTelNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String toString() {
		return "[profNo=" + profNo + ", deptCode=" + deptCode + ", profId=" + profId + ", profPwd=" + profPwd
				+ ", profName=" + profName + ", address=" + address + ", profTelNo=" + profTelNo + ", email=" + email
				+ ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
}
