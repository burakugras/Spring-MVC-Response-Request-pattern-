package ResponseRequestSpringDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ResponseRequestSpringDemo.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
	
}
