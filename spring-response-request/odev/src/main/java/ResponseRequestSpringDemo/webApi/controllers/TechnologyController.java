package ResponseRequestSpringDemo.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ResponseRequestSpringDemo.business.abstracts.TechnologyService;
import ResponseRequestSpringDemo.business.requests.technologyRequests.CreateTechnologyRequest;
import ResponseRequestSpringDemo.business.requests.technologyRequests.UpdateTechnologyRequest;
import ResponseRequestSpringDemo.business.responses.technologyResponses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

	private TechnologyService technologyService;	
	
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest)throws Exception{
		technologyService.add(createTechnologyRequest);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}
		
	@PutMapping("/update")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest)throws Exception{
		technologyService.update(updateTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	
	
	
}
