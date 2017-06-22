package fi.lahtevanoja.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import fi.lahtevanoja.springtest.card.Card;
import fi.lahtevanoja.springtest.card.CardsResponse;
import fi.lahtevanoja.springtest.models.Employee;
import fi.lahtevanoja.springtest.repositories.EmployeeRepository;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final EmployeeRepository employeeRepository;

    @Autowired
    CardController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{cardId}")
    CardsResponse getCardById(@PathVariable long cardId) {
        Employee employee = this.employeeRepository.findOne(cardId);
        Card card = new Card(employee);
        return new CardsResponse(card);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/")
    List<Card> getCards() {
        return new ArrayList<>();
    }
}
