package hh.swd20.Computer.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Long> {
	
	List<Component> findByModel(String model);

}
