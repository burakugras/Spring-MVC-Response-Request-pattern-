package ResponseRequestSpringDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ResponseRequestSpringDemo.business.abstracts.LanguageService;
import ResponseRequestSpringDemo.business.requests.languageRequests.CreateLanguageRequest;
import ResponseRequestSpringDemo.business.requests.languageRequests.UpdateLanguageRequest;
import ResponseRequestSpringDemo.business.responses.languageResponses.GetAllLanguageResponse;
import ResponseRequestSpringDemo.dataAccess.abstracts.LanguageRepository;
import ResponseRequestSpringDemo.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages=new ArrayList<>();
		List<GetAllLanguageResponse> getLanguagesResponses=new ArrayList<>();
		languages=languageRepository.findAll();
		
		for (Language language : languages) {
			GetAllLanguageResponse getAllLanguageResponse=new GetAllLanguageResponse();
			getAllLanguageResponse.setId(language.getId());
			getAllLanguageResponse.setName(language.getLanguageName());
			getLanguagesResponses.add(getAllLanguageResponse);
			
		}
		return getLanguagesResponses;
	}

	@Override
	public void add(CreateLanguageRequest request) throws Exception {
		if (request.getName().isEmpty() || request.getName().isBlank()) {
			throw new Exception("Programlama ismi boş bırakılamaz.");
		}
		else if (languageRepository.existsByLanguageName(request.getName())) {
			throw new Exception(request.getName()+"İsim zaten bulunuyor");
		}
		else {
			Language language=new Language();
			language.setLanguageName(request.getName());
			languageRepository.save(language);
		}		
	}

	@Override
	public void update(UpdateLanguageRequest request) throws Exception {
		if (request.getName().isEmpty() || request.getName().isBlank()) {
			throw new Exception("Programlama ismi boş bırakılamaz.");
		}
		else if (languageRepository.existsByLanguageName(request.getName())) {
			Language language=languageRepository.findById(request.getId()).orElseThrow(()-> new Exception("Id bulunmuyor"));
			language.setLanguageName(request.getName());
			languageRepository.save(language);
		}
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
	}

}
