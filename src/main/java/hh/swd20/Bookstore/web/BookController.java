package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository repository2;
	
	// show all books
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books =  (List<Book>) repository.findAll();
		model.addAttribute("books", books);
		
		return "bookhtml";
	}
	
	//Login page
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//RESTful service to get all books
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	//RESTful service to get a book by id
	@RequestMapping(value="/books/{BookId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("BookId") Long BookId) {
		return repository.findById(BookId);
	}
	
	
	//RESTful service to save a new book
	// Not part of the homework
	
	// show all categories
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public String getCategorys(Model model) {
		List<Category> categorys =  (List<Category>) repository2.findAll();
		model.addAttribute("categorys", categorys);
		
		return "categorylist";
	}
	
	//Add a category
	@RequestMapping(value = "/add")
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
    	model.addAttribute("categorys", repository2.findAll());
        return "newcategory";
    } 
	
	//Add a book
	@RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("books", repository.findAll());
    	model.addAttribute("category", new Category());
    	model.addAttribute("categorys", repository2.findAll());
        return "newbook";
    }   
	
	//Save categories
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Category category) {
		repository2.save(category);
		return "redirect:categorylist";
	}
	
	//Save books
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	//Delete a book
	@RequestMapping(value = "/delete/{BookId}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("BookId") Long BookId, Model model) {
    	repository.deleteById(BookId);
        return "redirect:../booklist";
    }  
	
	
}
