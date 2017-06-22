package fi.lahtevanoja.springtest.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class CardsResponse {

  @JsonProperty("_data")
  private List<Card> data;

  public CardsResponse() {
    this.data = new ArrayList<>();
  }

  public CardsResponse(List<Card> cards) {
    this.data = cards;
  }

  public CardsResponse(Card card) {
    this.data = new ArrayList<Card>(1);
    this.data.add(card);
  }

  @JsonIgnore
  public List<Card> getData() {
    return data;
  }

  public void setData(List<Card> data) {
    this.data = data;
  }
}
