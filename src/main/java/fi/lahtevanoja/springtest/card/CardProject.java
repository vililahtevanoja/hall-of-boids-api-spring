package fi.lahtevanoja.springtest.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import fi.lahtevanoja.springtest.models.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.joda.time.DateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CardProject {

  @JsonProperty
  private String client;

  @JsonProperty
  private String description;

  @JsonProperty
  private CardProjectDuration duration;

  @JsonProperty
  private boolean current;

  public static CardProject fromProject(Project project) {
    String client = project.getClient();
    String description = project.getDescription();
    CardProjectDuration duration = new CardProjectDuration(project.getDurationFrom().getTime(),
        project.getDurationTo().getTime());
    long now = DateTime.now().getMillis();
    boolean isCurrent =
        project.getDurationFrom().getTime() < now && project.getDurationTo().getTime() > now;

    return new CardProject(client, description, duration, isCurrent);
  }
}
