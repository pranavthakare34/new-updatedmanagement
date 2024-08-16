package PDT.STD.ManagementApp.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ApplicationError applicationError;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApplicationError getApplicationError() {
		return applicationError;
	}

	public void setApplicationError(ApplicationError applicationError) {
		this.applicationError = applicationError;
	}
	
	
}
