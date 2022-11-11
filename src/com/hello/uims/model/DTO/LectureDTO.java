package com.hello.uims.model.DTO;

public class LectureDTO {

	private int lectureNo; // 강의 번호
	private String deptCode; // 학과 코드
	private int profNo; // 교수 번호
	private String lectureName; // 강의명
	private char credit; // 수강학점
	private int currNo; // 수강인원
	private int fullNo; // 정원인원
	private String day; // 요일
	private String time; // 시간

	public LectureDTO() {

	}

	public LectureDTO(int lectureNo, String deptCode, int profNo, String lectureName, char credit, int currNo,
			int fullNo, String day, String time) {
		this.lectureNo = lectureNo;
		this.deptCode = deptCode;
		this.profNo = profNo;
		this.lectureName = lectureName;
		this.credit = credit;
		this.currNo = currNo;
		this.fullNo = fullNo;
		this.day = day;
		this.time = time;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public int getProfNo() {
		return profNo;
	}

	public void setProfNo(int profNo) {
		this.profNo = profNo;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public char getCredit() {
		return credit;
	}

	public void setCredit(char credit) {
		this.credit = credit;
	}

	public int getCurrNo() {
		return currNo;
	}

	public void setCurrNo(int currNo) {
		this.currNo = currNo;
	}

	public int getFullNo() {
		return fullNo;
	}

	public void setFullNo(int fullNo) {
		this.fullNo = fullNo;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString() {
		return "[lectureNo=" + lectureNo + ", deptCode=" + deptCode + ", profNo=" + profNo + ", lectureName="
				+ lectureName + ", credit=" + credit + ", currNo=" + currNo + ", fullNo=" + fullNo + ", day=" + day
				+ ", time=" + time + "]";
	}
}
