package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {

		Book s1 = new Book("Booktitle","Samuel Poutsalo", 1999, "isbdfn", 10);
		Book s2 = new Book("Kirje2","Samuel Poutsalo", 2003, "isbhn", 20);
		Book s3 = new Book("Kirja","Samuel Poutsalo", 2079, "isbjn", 30);
		
		
		repository.save(s1);
		repository.save(s2);
		repository.save(s3);
	};
	
	
}
}
