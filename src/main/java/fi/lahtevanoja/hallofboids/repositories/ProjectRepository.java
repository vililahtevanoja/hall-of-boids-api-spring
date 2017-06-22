package fi.lahtevanoja.hallofboids.repositories;

import fi.lahtevanoja.hallofboids.models.Project;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "projects", path = "/projects")
public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findByEmployeeId(@Param("employeeId") long employeeId);
}
