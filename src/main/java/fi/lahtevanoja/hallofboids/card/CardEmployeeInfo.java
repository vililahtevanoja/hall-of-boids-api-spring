package fi.lahtevanoja.hallofboids.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import fi.lahtevanoja.hallofboids.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CardEmployeeInfo {

  @JsonProperty("firstname")
  private String firstName;

  @JsonProperty("lastname")
  private String lastName;

  @JsonProperty
  private String title;

  public static CardEmployeeInfo fromEmployee(Employee employee) {
    CardEmployeeInfo cei = new CardEmployeeInfo(employee.getFirstName(), employee.getLastName(),
        employee.getTitle());
    return cei;
  }
}
