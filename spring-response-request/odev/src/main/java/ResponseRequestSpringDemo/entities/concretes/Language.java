package ResponseRequestSpringDemo.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="language")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

	@Id
	@Column(name="language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="language_name")
	private String languageName;
	
	@OneToMany(mappedBy="language")
	private List<Technology> technologies;
}
