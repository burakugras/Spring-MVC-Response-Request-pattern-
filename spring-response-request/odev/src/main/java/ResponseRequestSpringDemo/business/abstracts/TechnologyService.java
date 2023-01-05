package ResponseRequestSpringDemo.business.abstracts;

import java.util.List;

import ResponseRequestSpringDemo.business.requests.technologyRequests.CreateTechnologyRequest;
import ResponseRequestSpringDemo.business.requests.technologyRequests.UpdateTechnologyRequest;
import ResponseRequestSpringDemo.business.responses.technologyResponses.GetAllTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();
	void add(CreateTechnologyRequest request)throws Exception;
	void update(UpdateTechnologyRequest request)throws Exception;
	void delete(int id);
}
