package PDT.STD.ManagementApp.DBLOGIC;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import PDT.STD.ManagementApp.DTO.Student1;
import PDT.STD.ManagementApp.DTO.StudentAudit;
import PDT.STD.ManagementApp.DTO.StudentResponse;
import PDT.STD.ManagementApp.IWebsales.AuditLog;
import PDT.STD.ManagementApp.IWebsales.Student_Transaction;
@Component
public class DbUtil {
     Logger logger = LoggerFactory.getLogger(this.getClass());
     @Autowired
     AuditLog auditLog; 
     
     @Autowired
     Student_Transaction transaction;
    
	public void saveStudent(Student1 student, StudentResponse response, String businessCorelationID, String string, String status) {
		logger.info("Enterd inside saveStudent inside DbUtil");
		StudentAudit studentAudit = new StudentAudit();
		studentAudit.setRequest(student);
		studentAudit.setResponse(response);
		studentAudit.setBCID(businessCorelationID);
		studentAudit.setStatus(status);
		auditLog.save(studentAudit);
		logger.info("Enterd inside saveStudent inside DbUtil");
		
	}

	public StudentResponse saveToTransactionTable(Student1 student, String businessCorelationID) {
		logger.info("Enterd inside saveToTransactionTable inside DbUtil");
		student.setBasicid(businessCorelationID);
		StudentResponse response = new StudentResponse();
		if (Objects.nonNull(student)) {
			transaction.save(student);
		}
		response.setStatus("sucess");
		logger.info("Exit From saveToTransactionTable inside DbUtil");
		return response;
		
	}

}
