package hh.swd20.Computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Computer.domain.Category;
import hh.swd20.Computer.domain.CategoryRepository;
import hh.swd20.Computer.domain.Component;
import hh.swd20.Computer.domain.ComponentRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ComputerRepositoryTest {
	
	@Autowired
	private ComponentRepository componentRepository;
	private CategoryRepository categoryRepository;
	
	@Test	// Testataanko löytääkö kirjan
	public void findbyTitleShouldReturnComponent() {
		List<Component> components = componentRepository.findByModel("I7");
		
		assertThat(components).hasSize(1);
		assertThat(components.get(0).getBrand()).isEqualTo("Intel");
	}
	
	@Test // Testaus toimiiko uuden kirjan lisäys ja tallennus
	public void createNewBook() {
		
		Category category = new Category("GPU");
		
		Component component = new Component("RX 6800", "AMD", 2020, "Jimms.com", 500, category);
		componentRepository.save(component);
	}
	
	@Test // Kirjan poistaminen Id:n 5 perusteella
	public void deletebyId() {
	
	componentRepository.deleteById((long) 10);
	
	assertThat(componentRepository.findById((long) 10)).isEmpty();
	

}
}