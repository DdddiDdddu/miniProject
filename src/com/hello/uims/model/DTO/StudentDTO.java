package com.hello.uims.model.DTO;

import java.sql.Date;

public class StudentDTO {

	private int studentNo; // 학번
	private String deptCode; // 학과 코드
	private String studentId; // 학생 아이디
	private String studentPwd; // 학생 비밀번호
	private String studentName; // 학생 이름
	private String address; // 학생 주소
	private String studentTelNo; // 학생 전화번호
	private String email; // 학생 이메일
	private Date enrollDate; // 입학일
	private char status; // 재학 상태

	public StudentDTO() {

	}

	public StudentDTO(int studentNo, String deptCode, String studentId, String studentPwd, String studentName,
			String address, String studentTelNo, String email, Date enrollDate, char status) {
		this.studentNo = studentNo;
		this.deptCode = deptCode;
		this.studentId = studentId;
		this.studentPwd = studentPwd;
		this.studentName = studentName;
		this.address = address;
		this.studentTelNo = studentTelNo;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPwd() {
		return studentPwd;
	}

	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentTelNo() {
		return studentTelNo;
	}

	public void setStudentTelNo(String studentTelNo) {
		this.studentTelNo = studentTelNo;
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
		return studentNo + "  " + deptCode + "    " + studentId + "   " + studentPwd + " " + studentName + "  " + address
				+ "  " + studentTelNo + "  " + email + "  " + enrollDate + "  " + status;
	}
}
