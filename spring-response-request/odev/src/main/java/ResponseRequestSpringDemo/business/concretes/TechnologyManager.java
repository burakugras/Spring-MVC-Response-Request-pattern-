package ResponseRequestSpringDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ResponseRequestSpringDemo.business.abstracts.TechnologyService;
import ResponseRequestSpringDemo.business.requests.technologyRequests.CreateTechnologyRequest;
import ResponseRequestSpringDemo.business.requests.technologyRequests.UpdateTechnologyRequest;
import ResponseRequestSpringDemo.business.responses.technologyResponses.GetAllTechnologyResponse;
import ResponseRequestSpringDemo.dataAccess.abstracts.LanguageRepository;
import ResponseRequestSpringDemo.dataAccess.abstracts.TechnologyRepository;
import ResponseRequestSpringDemo.entities.concretes.Language;
import ResponseRequestSpringDemo.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies=technologyRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses=new ArrayList<>();
		
		for (Technology technology : technologies) {
			GetAllTechnologyResponse getAllTechnologyResponse=new GetAllTechnologyResponse();
			getAllTechnologyResponse.setId(technology.getId());
			getAllTechnologyResponse.setName(technology.getName());
			getAllTechnologyResponse.setLanguageId(technology.getLanguage().getId());
			getAllTechnologyResponses.add(getAllTechnologyResponse);
		}
		return getAllTechnologyResponses;
	}

	@Override
	public void add(CreateTechnologyRequest request) throws Exception {
		Language language=languageRepository.findById(request.getLanguageId()).orElseThrow(()->new Exception("Programlama dili id numarası bulunmuyor"));
		
		Technology technology=new Technology();
		technology.setName(request.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);		
	}

	@Override
	public void update(UpdateTechnologyRequest request) throws Exception {
		Language language=languageRepository.findById(request.getLanguageId()).orElseThrow(null);		
		
		Technology technology=technologyRepository.findById(request.getId()).orElse(null);
		technology.setName(request.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);		
	}

}
