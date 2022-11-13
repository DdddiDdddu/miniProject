package com.hello.uims.controller;

import java.util.ArrayList;
import java.util.Map;

import com.hello.uims.model.DTO.GradeDTO;
import com.hello.uims.model.service.GradeService;
import com.hello.uims.view.PrintResult;

public class Controller {

	private GradeService gradeService = new GradeService();
	private PrintResult printResult = new PrintResult();
	
	public void gradeCheck(Map<String, String> parameter) {
		
		int studentNo = Integer.parseInt(parameter.get("studentNo"));
		
		ArrayList<GradeDTO> list = gradeService.gradeCheck(studentNo);
		
		if(list != null && !list.isEmpty()) {
			printResult.printGrade(list);
			System.out.println(1);
		} else {
			printResult.printErrorMessage("gradeCheck");
			System.out.println(2);
		}
		
	}

}
