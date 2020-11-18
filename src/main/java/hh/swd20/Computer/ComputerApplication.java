package hh.swd20.Computer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Computer.domain.Category;
import hh.swd20.Computer.domain.CategoryRepository;
import hh.swd20.Computer.domain.Component;
import hh.swd20.Computer.domain.ComponentRepository;
import hh.swd20.Computer.domain.User;
import hh.swd20.Computer.domain.UserRepository;

@SpringBootApplication
public class ComputerApplication {
	private static final Logger log = LoggerFactory.getLogger(ComputerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ComputerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ComponentRepository repository, CategoryRepository repository2,
			UserRepository repository3) {
		return (args) -> {

			log.info("Tallennus testi");
			Category a1 = new Category("GPU");
			repository2.save(a1);
			Category a2 = new Category("CPU");
			repository2.save(a2);
			Category a3 = new Category("MOBO");
			repository2.save(a3);
			Category a4 = new Category("RAM");
			repository2.save(a4);
			Category a5 = new Category("PSU");
			repository2.save(a5);
			Category a6 = new Category("SSD");
			repository2.save(a6);
			Category a7 = new Category("HDD");
			repository2.save(a7);

			repository.save(new Component("Ryzen 7 5800X", "AMD", 2020, "Jimms.fi", 240, a2));
			repository.save(new Component("RTX 3090", "NVIDIA", 2020, "verkkokauppa.com", 1400, a1));
			repository.save(new Component("Strix X570-E", "Asus", 2020, "verkkokauppa.com", 349, a3));
			repository.save(new Component("MX500 1TB", "Crucial", 2018, "verkkokauppa.com", 130, a6));
			repository.save(new Component("970 EVO Plus M.2", "Samsung", 2019, "Amazon.com", 90, a6));
			repository.save(new Component("FURY DDR4 2666 8GB", "Kingston", 2017, "Jimms.fi", 50, a4));
			repository.save(new Component("FURY DDR4 2666 8GB", "Kingston", 2017, "Jimms.fi", 50, a4));
			repository.save(new Component("Barracuda 1TB", "Seagate", 2015, "Tori.fi", 20, a7));
			repository.save(new Component("CV650, 80 PLUS", "Corsair", 2014, "Jimms.fi", 50, a5));

			User user1 = new User("user", "$2y$12$6LmFjyVVsZqwE6H.r3NFWeqlZ/wh/fN/jLnpUQrkzuhg1LF1raLPe",
					"samuel@gmail.com", "USER");
			User user2 = new User("admin", "$2y$10$5ZVBx3XDH6i6FdSltNYIIeJCcw/nH33wKNi7BEvm.8sKIMP7lITWe",
					"random@gmail.com", "ADMIN");
			repository3.save(user1);
			repository3.save(user2);

			for (Component component : repository.findAll()) {
				log.info(component.toString());

			}

		};
	}

}
