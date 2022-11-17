package com.hello.uims.model.DTO;

public class GradeDTO {
	
	private int lectureNo; // 강의 번호
	private String lectureName; // 강의명
	private int profNo; //교수 번호
	private String profName; // 교수 이름
	private int studentNo; // 학번
	private String studentName; // 학생 이름
	private int attScore; // 출석 점수
	private int assScore; // 과제 점수
	private int midScore; // 중간 점수
	private int finScore; // 기말 점수
	private String grade; // 학점

	public GradeDTO() {

	}

	public GradeDTO(int lectureNo, String lectureName, int profNo, String profName, int studentNo, String studentName, int attScore, int assScore,
			int midScore, int finScore, String grade) {
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.profNo = profNo;
		this.profName = profName;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.attScore = attScore;
		this.assScore = assScore;
		this.midScore = midScore;
		this.finScore = finScore;
		this.grade = grade;
	}
	
	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	public int getProfNo() {
		return profNo;
	}

	public void setProfNo(int profNo) {
		this.profNo = profNo;
	}
	
	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getAttScore() {
		return attScore;
	}

	public void setAttScore(int attScore) {
		this.attScore = attScore;
	}

	public int getAssScore() {
		return assScore;
	}

	public void setAssScore(int assScore) {
		this.assScore = assScore;
	}

	public int getMidScore() {
		return midScore;
	}

	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}

	public int getFinScore() {
		return finScore;
	}

	public void setFinScore(int finScore) {
		this.finScore = finScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
 
	public String toString() {
		return lectureName + "  " + profName + "  " + studentNo + "  " + studentName + "  " + attScore + "  " + assScore
				+ "  " + midScore + "  " + finScore + "  " + grade;
	}

}
