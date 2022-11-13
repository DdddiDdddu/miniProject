package com.hello.uims.model.DTO;

public class GradeDTO {

	private String lectureName; // 강의명
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

	public GradeDTO(String lectureName, String profName, int studentNo, String studentName, int attScore,
			int assScore, int midScore, int finScore, String grade) {
		this.lectureName = lectureName;
		this.profName = profName;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.attScore = attScore;
		this.assScore = assScore;
		this.midScore = midScore;
		this.finScore = finScore;
		this.grade = grade;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
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
		return "[lectureName=" + lectureName + ", profName=" + profName + ", studentNo=" + studentNo + ", studentName="
				+ studentName + ", attScore=" + attScore + ", assScore=" + assScore + ", midScore=" + midScore
				+ ", finScore=" + finScore + ", grade=" + grade + "]";
	}

}
