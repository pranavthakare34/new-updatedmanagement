package PDT.STD.ManagementApp.IWebsales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PDT.STD.ManagementApp.DTO.StudentAudit;
@Repository
public interface AuditLog extends JpaRepository<StudentAudit, Integer>{

}
