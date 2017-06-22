package fi.lahtevanoja.hallofboids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class HallOfBoidsApplication {

  public static void main(String[] args) {
    SpringApplication.run(HallOfBoidsApplication.class, args);
  }
}
