package fi.lahtevanoja.hallofboids;

import fi.lahtevanoja.hallofboids.controllers.CardController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
@JsonTest
public class CardControllerTests {

  @Autowired
  private MockMvc mvc;


}
