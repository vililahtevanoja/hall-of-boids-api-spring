package fi.lahtevanoja.hallofboids.card;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CardProjectDuration {

  @JsonProperty
  private long from;

  @JsonProperty
  private long to;

}
