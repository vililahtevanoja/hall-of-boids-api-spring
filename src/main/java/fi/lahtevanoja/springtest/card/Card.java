package fi.lahtevanoja.springtest.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class Card {

  @JsonProperty
  private long id;

  @JsonProperty
  private CardEmployeeInfo info;

  @JsonProperty
  private String image;

  @JsonProperty
  private String motto;

  @JsonProperty
  private boolean available;

  @JsonProperty
  private boolean inProcess;

  @JsonProperty
  private List<CardSkill> skills;

  @JsonProperty
  private List<CardProject> projects;

  @JsonProperty
  private long availableFrom;

}
