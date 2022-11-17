package com.hello.uims.model.DTO;

import java.util.Arrays;

public class LectureDTO {

	private String deptCode; // 학과 코드
	private int lectureNo; // 강의 번호
	private int profNo; // 교수 번호
	private String profName; // 교수 이름
	private String lectureName; // 강의명
	private char credit; // 수강학점
	private int currNo; // 수강인원
	private int fullNo; // 정원인원
	private String day; // 요일
	private String time; // 시간

	public LectureDTO() {

	}

	public LectureDTO(String deptCode, int lectureNo, int profNo, String profName, String lectureName, char credit,
			int currNo, int fullNo, String day, String time) {
		super();
		this.deptCode = deptCode;
		this.lectureNo = lectureNo;
		this.profNo = profNo;
		this.profName = profName;
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

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
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
		return deptCode + "    " + lectureNo + "    " + profName + "  " + profNo + "      " + rpad(lectureName, 10, ' ')
				+ "  " + credit + "        (" + currNo + " / " + fullNo + ")     " + day + "     " + time;
	}

	public static String rpad(String str, int length, char fillChar) {
		if (str.length() > length)
			return str;
		char[] chars = new char[length];
		Arrays.fill(chars, fillChar);
		System.arraycopy(str.toCharArray(), 0, chars, 0, str.length());
		return new String(chars);
	}

}
