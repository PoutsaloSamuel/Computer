package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository repository2, UserRepository repository3) {
	return (args) -> {
		
		log.info("Tallennus testi");
		Category a1 = new Category("Scifi");
		repository2.save(a1);
		Category a2 = new Category("Comic");
		repository2.save(a2);
		Category a3 = new Category("Drama");
		repository2.save(a3);
		
		repository.save(new Book("Booktitle","Samuel Poutsalo", 1999, "isbdfn", 10, a1));
		repository.save(new Book("Kirje2","Samuel Poutsalo", 2003, "isbhn", 20, a2));
		repository.save(new Book("Kirja","Samuel Poutsalo", 2079, "isbjn", 30, a3));
		
		User user1 = new User("user", "$2y$12$6LmFjyVVsZqwE6H.r3NFWeqlZ/wh/fN/jLnpUQrkzuhg1LF1raLPe","samuel@gmail.com", "USER");
		User user2 = new User("admin", "$2y$10$5ZVBx3XDH6i6FdSltNYIIeJCcw/nH33wKNi7BEvm.8sKIMP7lITWe","random@gmail.com", "ADMIN");
		repository3.save(user1);
		repository3.save(user2);
		
		for (Book book : repository.findAll()) {
			log.info(book.toString());
			
		}
		
		
		
	};
	}
	
	
	
	
}

