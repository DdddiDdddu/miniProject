package com.hello.uims.model.DTO;

public class TimeTableDTO {

	private int studentNo; // 학번 
	private int lectureNo; // 강의 번호 

	public TimeTableDTO() {

	}

	public TimeTableDTO(int studentNo, int lectureNo) {
		super();
		this.studentNo = studentNo;
		this.lectureNo = lectureNo;
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
		return "[studentNo=" + studentNo + ", lectureNo=" + lectureNo + "]";
	}

}
