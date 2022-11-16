package com.hello.uims.model.DTO;

public class TimeTableDTO {

	private int enrollId; // 수강신청 번호
	private int studentNo; // 학번
	private int lectureNo; // 강의 번호
	private int day; // 날짜
	private int firstClass; // 1교시
	private int secondClass; // 2교시
	private int credit; // 수강학점

	public TimeTableDTO() {

	}

	public TimeTableDTO(int enrollId, int studentNo, int lectureNo, int day, int firstClass, int secondClass,
			int credit) {
		super();
		this.enrollId = enrollId;
		this.studentNo = studentNo;
		this.lectureNo = lectureNo;
		this.day = day;
		this.firstClass = firstClass;
		this.secondClass = secondClass;
		this.credit = credit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(int firstClass) {
		this.firstClass = firstClass;
	}

	public int getSecondClass() {
		return secondClass;
	}

	public void setSecondClass(int secondClass) {
		this.secondClass = secondClass;
	}

//	public String toString() { // 확인 
//		return "[studentNo=" + studentNo + ", lectureNo=" + lectureNo + "]";
//	}

}
