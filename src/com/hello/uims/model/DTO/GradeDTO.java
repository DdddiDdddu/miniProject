package com.hello.uims.model.DTO;

public class GradeDTO {

	private int gradeNo; // 학점 반호
	private int lectureNo; // 강의 번호
	private int profNo; // 교수 번호
	private int studentNo; // 학번
	private int attScore; // 출석 점수
	private int assScore; // 과제 점수
	private int midScore; // 중간 점수
	private int finScore; // 기말 점수
	private String grade; // 학점

	public GradeDTO() {

	}

	public GradeDTO(int gradeNo, int lectureNo, int profNo, int studentNo, int attScore, int assScore, int midScore,
			int finScore, String grade) {
		super();
		this.gradeNo = gradeNo;
		this.lectureNo = lectureNo;
		this.profNo = profNo;
		this.studentNo = studentNo;
		this.attScore = attScore;
		this.assScore = assScore;
		this.midScore = midScore;
		this.finScore = finScore;
		this.grade = grade;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public int getProfNo() {
		return profNo;
	}

	public void setProfNo(int profNo) {
		this.profNo = profNo;
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
		return "[gradeNo=" + gradeNo + ", lectureNo=" + lectureNo + ", profNo=" + profNo + ", studentNo=" + studentNo
				+ ", attScore=" + attScore + ", assScore=" + assScore + ", midScore=" + midScore + ", finScore="
				+ finScore + ", grade=" + grade + "]";
	}

}
