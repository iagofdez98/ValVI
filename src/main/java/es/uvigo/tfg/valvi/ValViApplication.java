package es.uvigo.tfg.valvi;

import es.uvigo.tfg.valvi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import es.uvigo.tfg.valvi.repository.UserRepository;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//public class ValViApplication implements CommandLineRunner {
public class ValViApplication {

  public static void main(String[] args) {
    SpringApplication.run(ValViApplication.class, args);
  }

//  @Autowired
//  UserRepository userRepository;
//
//  @Override
//  public void run(String... args) throws Exception {
//    this.userRepository.save(User.builder().username("iagofm").password("iagofm").build());
//  }
}
