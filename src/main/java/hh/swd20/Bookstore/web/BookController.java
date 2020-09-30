package hh.swd20.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books =  (List<Book>) repository.findAll();
		model.addAttribute("books", books);
		
		return "bookhtml";
	}
	
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public String getCategorys(Model model) {
		List<Category> categorys =  (List<Category>) repository2.findAll();
		model.addAttribute("categorys", categorys);
		
		return "categorylist";
	}
	
	
}
