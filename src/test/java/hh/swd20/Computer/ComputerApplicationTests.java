package hh.swd20.Computer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Computer.web.ComputerController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ComputerApplicationTests {
	
	@Autowired
	private ComputerController componentController;

	@Test
	void contextLoads() {
		assertThat(componentController).isNotNull();
	}

}
