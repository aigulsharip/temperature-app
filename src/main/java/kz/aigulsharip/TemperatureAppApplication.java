package kz.aigulsharip;

import kz.aigulsharip.models.Temparature;
import kz.aigulsharip.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemperatureAppApplication implements CommandLineRunner {

	@Autowired
	TemperatureRepository temperatureRepository;

	public static void main(String[] args) {
		SpringApplication.run(TemperatureAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (temperatureRepository.findAll().isEmpty()) {
			temperatureRepository.save(new Temparature("Paris", "26.5"));
			temperatureRepository.save(new Temparature("Almaty", "30.5"));

			temperatureRepository.save(new Temparature("London", "24.5"));
			temperatureRepository.save(new Temparature("Barcelona", "34.5"));
			temperatureRepository.save(new Temparature("Astana", "21.5"));
			temperatureRepository.save(new Temparature("Copenhagen", "20.5"));
			temperatureRepository.save(new Temparature("Berlin", "25.5"));
			temperatureRepository.save(new Temparature("Oslo", "22.5"));
			temperatureRepository.save(new Temparature("Tokyo", "25.6"));
			temperatureRepository.save(new Temparature("Brussels", "29.5"));




		}

//		for (Temparature temp: temperatureRepository.findAll()) {
//			System.out.println(temp);
//		}
	}
}
