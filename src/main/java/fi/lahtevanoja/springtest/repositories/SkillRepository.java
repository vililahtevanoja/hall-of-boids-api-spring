package fi.lahtevanoja.springtest.repositories;


import fi.lahtevanoja.springtest.models.Skill;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "skills", path = "/skills")
public interface SkillRepository extends CrudRepository<Skill, Long> {

  List<Skill> findByEmployeeId(@Param("employeeId") long employeeId);
}
