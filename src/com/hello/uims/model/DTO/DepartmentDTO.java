package com.hello.uims.model.DTO;

public class DepartmentDTO {

	private String deptCode; // 학과 코드
	private String deptName; // 학과 명

	public DepartmentDTO() {

	}

	public DepartmentDTO(String deptCode, String deptName) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String toString() {
		return deptCode + "  " + deptName;
	}

}
