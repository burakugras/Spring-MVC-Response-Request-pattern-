package ResponseRequestSpringDemo.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologyResponse {

	private int id;
	private String name;
	private int languageId;
	
}
