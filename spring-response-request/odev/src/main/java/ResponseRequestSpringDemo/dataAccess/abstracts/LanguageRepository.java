package ResponseRequestSpringDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ResponseRequestSpringDemo.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

	boolean existsByLanguageName(String name);
}
