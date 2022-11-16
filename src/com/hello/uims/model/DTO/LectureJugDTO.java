package com.hello.uims.model.DTO;

public class LectureJugDTO {
	
	private int judgementNo; //강의평가 번호
	private int lectureNo; // 강의 번호
	private int studentNo; //학생번호
	private int profNo; // 교수 번호
	private int stuJugScore; //학생 만족도 점수
	private String stuOneJug; //학생 한줄평가
	
	public LectureJugDTO() {
	
		
	}

	public LectureJugDTO(int judgementNo, int lectureNo, int studentNo, int profNo, int stuJugScore, String stuOneJug) {
		super();
		this.judgementNo = judgementNo;
		this.lectureNo = lectureNo;
		this.studentNo = studentNo;
		this.profNo = profNo;
		this.stuJugScore = stuJugScore;
		this.stuOneJug = stuOneJug;
	}

	public int getJudgementNo() {
		return judgementNo;
	}

	public void setJudgementNo(int judgementNo) {
		this.judgementNo = judgementNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getProfNo() {
		return profNo;
	}

	public void setProfNo(int profNo) {
		this.profNo = profNo;
	}

	public int getStuJugScore() {
		return stuJugScore;
	}

	public void setStuJugScore(int stuJugScore) {
		this.stuJugScore = stuJugScore;
	}

	public String getStuOneJug() {
		return stuOneJug;
	}

	public void setStuOneJug(String stuOneJug) {
		this.stuOneJug = stuOneJug;
	}

	public String toString() {
		return judgementNo + "                " + lectureNo + "        " + profNo + "      " + 
				studentNo + "     " + stuJugScore + "        " +stuOneJug;
	}
	
	
}
