package fi.lahtevanoja.springtest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

  private static final long serialVersionUID = 5974102306797353902L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @JsonProperty("firstname")
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @JsonProperty("lastname")
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String title;

  @Column
  private String image;

  @Column(nullable = false)
  private String motto;

  @OneToMany(mappedBy = "employee")
  private List<Skill> skills = new ArrayList<Skill>();

  @OneToMany(mappedBy = "employee")
  private List<Project> projects = new ArrayList<Project>();

}

