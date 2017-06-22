package fi.lahtevanoja.hallofboids.repositories;

import fi.lahtevanoja.hallofboids.models.Employee;
import fi.lahtevanoja.hallofboids.models.Project;
import fi.lahtevanoja.hallofboids.models.Skill;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Employee.class, Project.class, Skill.class);
  }
}