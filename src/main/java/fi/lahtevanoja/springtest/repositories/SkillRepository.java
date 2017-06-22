package fi.lahtevanoja.springtest.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import fi.lahtevanoja.springtest.models.Skill;

@RepositoryRestResource(collectionResourceRel = "skills", path = "skills")
public interface SkillRepository extends CrudRepository<Skill, Long> {
    List<Skill> findByEmployeeId(@Param("employeeId") long employeeId);
}
