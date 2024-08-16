package PDT.STD.ManagementApp.BusinessLogic;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import PDT.STD.ManagementApp.DBLOGIC.DbUtil;
import PDT.STD.ManagementApp.DTO.ApplicationError;
import PDT.STD.ManagementApp.DTO.Student1;
import PDT.STD.ManagementApp.DTO.StudentResponse;

@Service
public class Businesslogic {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DbUtil dbUtil;
	
	public StudentResponse createStudent(Student1 student, String businessCorelationID) {
		logger.info("Enterd inside createStudent of Businesslogic");
		businessCorelationID="-"+"TS"+"savingrecord";
		StudentResponse response = new StudentResponse();
		ApplicationError applicationError = new ApplicationError();
		if (Objects.nonNull(student)) {
			response=	dbUtil.saveToTransactionTable(student,businessCorelationID);
			
			applicationError.setErrorCode("0");
			applicationError.setErrorMessage("success");
			response.setApplicationError(applicationError);
		}
		
		logger.info("Enterd inside createStudent of Businesslogic");
		return response;
	}

	
	
	
	
}
