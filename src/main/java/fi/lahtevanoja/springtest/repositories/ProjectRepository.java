package fi.lahtevanoja.springtest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import fi.lahtevanoja.springtest.models.Project;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByEmployeeId(@Param("employeeId") long employeeId);
}
