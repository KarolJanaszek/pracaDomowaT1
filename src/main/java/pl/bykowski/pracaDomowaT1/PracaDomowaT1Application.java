package pl.bykowski.pracaDomowaT1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PracaDomowaT1Application {

	public static void main(String[] args) {
		SpringApplication.run(PracaDomowaT1Application.class, args);
	}

}
