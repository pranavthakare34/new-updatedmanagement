package PDT.STD.ManagementApp.IWebsales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PDT.STD.ManagementApp.DTO.Student1;

@Repository
public interface Student_Transaction extends JpaRepository<Student1, Integer>{

}
