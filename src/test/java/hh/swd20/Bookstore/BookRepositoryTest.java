package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;
	
	@Test	// Testataanko löytääkö kirjan
	public void findbyTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByTitle("Booktitle");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Samuel Poutsalo");
	}
	
	@Test // Testaus toimiiko uuden kirjan lisäys ja tallennus
	public void createNewBook() {
		
		Category category = new Category("Mystery");
		
		Book book = new Book("TheBookThatTestedWell", "Samuel Testaaja", 2020, "randomisbn", 47, category);
		bookRepository.save(book);
	}
	
	@Test // Kirjan poistaminen Id:n 5 perusteella
	public void deletebyId() {
	
	bookRepository.deleteById((long) 5);
	
	assertThat(bookRepository.findById((long) 5)).isEmpty();
	

}
}