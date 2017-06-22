package fi.lahtevanoja.springtest.card;

import fi.lahtevanoja.springtest.models.Employee;
import java.util.List;
import java.util.stream.Collectors;
import org.joda.time.DateTime;

public class Card {

  private long id;

  private CardEmployeeInfo info;

  private String image;

  private String motto;

  private boolean available;
  private boolean inProcess;
  private List<CardSkill> skills;
  private List<CardProject> projects;
  private long availableFrom;

  Card() {
  }

  public Card(Employee employee) {
    this.id = employee.getId();
    this.info = new CardEmployeeInfo(employee);
    this.image = employee.getImage();
    this.motto = employee.getMotto();
    this.skills = employee.getSkills().stream()
        .map(CardSkill::new)
        .collect(Collectors.toList());
    this.projects = employee.getProjects().stream()
        .map(CardProject::new)
        .collect(Collectors.toList());
    this.available = projects.stream().noneMatch(CardProject::isCurrent);
    this.availableFrom = projects.stream()
        .map(CardProject::getDuration)
        .map(CardProjectDuration::getTo)
        .max(Long::compareTo)
        .orElse(new DateTime().getMillis());
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public CardEmployeeInfo getInfo() {
    return info;
  }

  public void setInfo(CardEmployeeInfo info) {
    this.info = info;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getMotto() {
    return motto;
  }

  public void setMotto(String motto) {
    this.motto = motto;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public boolean isInProcess() {
    return inProcess;
  }

  public void setInProcess(boolean inProcess) {
    this.inProcess = inProcess;
  }

  public List<CardSkill> getSkills() {
    return skills;
  }

  public void setSkills(List<CardSkill> skills) {
    this.skills = skills;
  }

  public List<CardProject> getProjects() {
    return projects;
  }

  public void setProjects(List<CardProject> projects) {
    this.projects = projects;
  }

  public long getAvailableFrom() {
    return availableFrom;
  }

  public void setAvailableFrom(long availableFrom) {
    this.availableFrom = availableFrom;
  }
}
