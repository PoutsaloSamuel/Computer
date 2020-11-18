package hh.swd20.Computer.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Computer.domain.Category;
import hh.swd20.Computer.domain.CategoryRepository;
import hh.swd20.Computer.domain.Component;
import hh.swd20.Computer.domain.ComponentRepository;

@Controller
public class ComputerController {

	@Autowired
	private ComponentRepository repository;

	@Autowired
	private CategoryRepository repository2;

	// show all books
	@RequestMapping(value = "/componentlist", method = RequestMethod.GET)
	public String getComponents(Model model) {
		List<Component> components = (List<Component>) repository.findAll();
		model.addAttribute("components", components);

		return "computerhtml";
	}

	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// RESTful service to get all components
	@RequestMapping(value = "/components", method = RequestMethod.GET)
	public @ResponseBody List<Component> componentListRest() {
		return (List<Component>) repository.findAll();
	}

	// RESTful service to get a component by id
	@RequestMapping(value = "/components/{ComponentId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Component> findComponentRest(@PathVariable("ComponentId") Long ComponentId) {
		return repository.findById(ComponentId);
	}

	// RESTful service to save a new component

	// show all categories
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategorys(Model model) {
		List<Category> categorys = (List<Category>) repository2.findAll();
		model.addAttribute("categorys", categorys);

		return "categorylist";
	}

	// Add a category
	@RequestMapping(value = "/add")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categorys", repository2.findAll());
		return "newcategory";
	}

	// Add a component
	@RequestMapping(value = "/addcomponent")
	public String addComponent(Model model) {
		model.addAttribute("component", new Component());
		model.addAttribute("components", repository.findAll());
		model.addAttribute("category", new Category());
		model.addAttribute("categorys", repository2.findAll());
		return "newcomponent";
	}

	// Save categories
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Category category) {
		repository2.save(category);
		return "redirect:categorylist";
	}

	// Save components
	@RequestMapping(value = "/savecomponent", method = RequestMethod.POST)
	public String save(Component component) {
		repository.save(component);
		return "redirect:componentlist";
	}

	// Delete a component
	@RequestMapping(value = "/delete/{ComponentId}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteComponent(@PathVariable("ComponentId") Long ComponentId, Model model) {
		repository.deleteById(ComponentId);
		return "redirect:../componentlist";
	}

	// Delete a category
	@RequestMapping(value = "/deletee/{CategoryId}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCategory(@PathVariable("CategoryId") Long CategoryId, Model model) {
		repository2.deleteById(CategoryId);
		return "redirect:../categorylist";
	}

}
