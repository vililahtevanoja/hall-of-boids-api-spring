package fi.lahtevanoja.hallofboids.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "skills")
public class Skill implements Serializable {

  private static final long serialVersionUID = 6956922755128545153L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonBackReference
  private Employee employee;

  @Column
  private String name;

  @Column
  private int rating;

}
