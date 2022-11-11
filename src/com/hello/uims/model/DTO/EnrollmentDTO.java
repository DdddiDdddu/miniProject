package com.hello.uims.model.DTO;

public class EnrollmentDTO {

	private int enrollId; // 수강 신청 번호 
	private int studentNo; // 학번 
	private int lectureNo; // 강의 번호 

	public EnrollmentDTO() {

	}

	public EnrollmentDTO(int enrollId, int studentNo, int lectureNo) {
		super();
		this.enrollId = enrollId;
		this.studentNo = studentNo;
		this.lectureNo = lectureNo;
	}

	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	
	public String toString() {
		return "[enrollId=" + enrollId + ", studentNo=" + studentNo + ", lectureNo=" + lectureNo + "]";
	}

}
