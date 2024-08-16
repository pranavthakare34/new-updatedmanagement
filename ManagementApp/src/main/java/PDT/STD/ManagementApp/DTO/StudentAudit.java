package PDT.STD.ManagementApp.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class StudentAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Student1 request;

	@OneToOne
	private StudentResponse response;

	private String BCID;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student1 getRequest() {
		return request;
	}

	public void setRequest(Student1 request) {
		this.request = request;
	}

	

	public StudentResponse getResponse() {
		return response;
	}

	public void setResponse(StudentResponse response) {
		this.response = response;
	}

	public String getBCID() {
		return BCID;
	}

	public void setBCID(String bCID) {
		BCID = bCID;
	}
}
