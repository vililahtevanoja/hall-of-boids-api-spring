package fi.lahtevanoja.springtest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "projects")
public class Project implements Serializable {

  private static final long serialVersionUID = 5680633555943627948L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonBackReference
  private Employee employee;

  @Column
  private String client;

  @Column
  private String description;

  @Column(name = "duration_from")
  private Date durationFrom;

  @Column(name = "duration_to")
  private Date durationTo;

}
