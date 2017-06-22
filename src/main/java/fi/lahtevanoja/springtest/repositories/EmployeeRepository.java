package fi.lahtevanoja.springtest.repositories;

import fi.lahtevanoja.springtest.models.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "/employees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  @Query("SELECT e.id from Employee e")
  List<Long> getIds();
}
