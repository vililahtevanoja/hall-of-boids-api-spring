package fi.lahtevanoja.springtest.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import fi.lahtevanoja.springtest.models.Skill;
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
public class CardSkill {

  @JsonProperty
  private String name;

  @JsonProperty
  private int rating;

  public static CardSkill fromSkill(Skill skill) {
    return new CardSkill(skill.getName(), skill.getRating());
  }
}
