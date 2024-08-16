/**
 * 
 */
package PDT.STD.ManagementApp.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PDT.STD.ManagementApp.BusinessLogic.Businesslogic;
import PDT.STD.ManagementApp.DBLOGIC.DbUtil;
import PDT.STD.ManagementApp.DTO.Student1;
import PDT.STD.ManagementApp.DTO.StudentAudit;
import PDT.STD.ManagementApp.DTO.StudentResponse;

/**
 * 
 */
@RestController
@RequestMapping("/Pranav_web")
public class App_Controller {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Businesslogic businessLogic;
	
	@Autowired
	DbUtil dbUtil;
	
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "OK";
	}
	
	@PostMapping("/createStudent")
	public StudentResponse createStudent(@RequestBody Student1 student,String businessCorelationID) {
		logger.info("Enterd inside createStudent method of App_Controller");
		Random random = new Random();
		int gUID=random.nextInt();		
		businessCorelationID=student.getId()+"-"+student.getFirstName()+"-"+gUID;
		StudentResponse response = new StudentResponse();
		String errorMSG = null;
		StudentAudit studentAudit;
		try {
		response = businessLogic.createStudent(student,businessCorelationID);
		errorMSG="Success";
		}catch(Exception e) {
			errorMSG=e.getMessage();
			System.out.println(e.getMessage());
		}finally {
			dbUtil.saveStudent(student,response,businessCorelationID,"/createStudent",errorMSG);
		}
		logger.info("Exit inside createStudent method of App_Controller");
		return response;
	}
	
	
}
