package fi.lahtevanoja.hallofboids.card;

import fi.lahtevanoja.hallofboids.models.Employee;
import fi.lahtevanoja.hallofboids.models.Project;
import fi.lahtevanoja.hallofboids.models.Skill;
import fi.lahtevanoja.hallofboids.repositories.EmployeeRepository;
import fi.lahtevanoja.hallofboids.repositories.ProjectRepository;
import fi.lahtevanoja.hallofboids.repositories.SkillRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardBuilder {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private SkillRepository skillRepository;

  public Card buildForEmployeeId(long employeeId) {
    Employee employee = employeeRepository.findOne(employeeId);
    List<Project> projects = projectRepository.findByEmployeeId(employeeId);
    List<Skill> skills = skillRepository.findByEmployeeId(employeeId);
    Card card = new Card();

    long id = employeeId;
    CardEmployeeInfo employeeInfo = CardEmployeeInfo.fromEmployee(employee);
    String image = employee.getImage();
    String motto = employee.getMotto();
    boolean isAvailable = hasOngoingProject(projects);
    long availableFrom = getAvailableFrom(projects);
    boolean inProcess = false;
    List<CardSkill> cardSkills = getCardSkills(skills);
    List<CardProject> cardProjects = getCardProjects(projects);

    return new Card(
        id,
        employeeInfo,
        image,
        motto,
        isAvailable,
        inProcess,
        cardSkills,
        cardProjects,
        availableFrom
    );
  }

  private boolean hasOngoingProject(List<Project> projects) {
    long now = DateTime.now().getMillis();
    return projects.stream()
        .anyMatch(p ->
            p.getDurationFrom().getTime() > now
                && p.getDurationTo().getTime() < now
        );
  }

  private long getAvailableFrom(List<Project> projects) {
    return projects.stream()
        .map(p -> p.getDurationTo().getTime())
        .max(Long::compare).orElse(DateTime.now().getMillis());
  }

  private List<CardSkill> getCardSkills(List<Skill> skills) {
    return skills.stream()
        .map(CardSkill::fromSkill)
        .collect(Collectors.toList());
  }

  private List<CardProject> getCardProjects(List<Project> projects) {
    return projects.stream()
        .map(CardProject::fromProject)
        .collect(Collectors.toList());
  }

}
