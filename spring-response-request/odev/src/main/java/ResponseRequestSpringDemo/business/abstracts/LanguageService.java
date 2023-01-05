package ResponseRequestSpringDemo.business.abstracts;

import java.util.List;

import ResponseRequestSpringDemo.business.requests.languageRequests.CreateLanguageRequest;
import ResponseRequestSpringDemo.business.requests.languageRequests.UpdateLanguageRequest;
import ResponseRequestSpringDemo.business.responses.languageResponses.GetAllLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest request) throws Exception;
	void update(UpdateLanguageRequest request)throws Exception;
	void delete(int id);
}
