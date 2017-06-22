package fi.lahtevanoja.hallofboids.controllers;

import fi.lahtevanoja.hallofboids.card.Card;
import fi.lahtevanoja.hallofboids.card.CardBuilder;
import fi.lahtevanoja.hallofboids.card.CardsResponse;
import fi.lahtevanoja.hallofboids.repositories.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

  @Autowired
  CardBuilder cardBuilder;

  @Autowired
  EmployeeRepository employeeRepository;

  @RequestMapping(method = RequestMethod.GET,
      path = "/{cardId}",
      produces = MediaTypes.HAL_JSON_VALUE)
  ResponseEntity<CardsResponse> getCardById(@PathVariable long cardId) {
    Card card = cardBuilder.buildForEmployeeId(cardId);
    return new ResponseEntity<>(new CardsResponse(card), HttpStatus.OK);
  }


  @RequestMapping(method = RequestMethod.GET,
      produces = MediaTypes.HAL_JSON_VALUE)
  ResponseEntity<CardsResponse> getCards() {
    List<Long> ids = employeeRepository.getIds();
    List<Card> cards = ids.stream()
        .map(id -> cardBuilder.buildForEmployeeId(id))
        .collect(Collectors.toList());
    return new ResponseEntity<CardsResponse>(new CardsResponse(cards), HttpStatus.OK);
  }
}
