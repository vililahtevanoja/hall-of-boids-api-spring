package fi.lahtevanoja.hallofboids.card;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

public class CardsResponse {

  @JsonProperty("_data")
  private List<Card> data;


  public CardsResponse(Card card) {
    this.data = Lists.newArrayList(card);
  }

  public CardsResponse(List<Card> cards) {
    this.data = Lists.newArrayList(cards);
  }
}
