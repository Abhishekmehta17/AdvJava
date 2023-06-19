package pojos;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntityBookAuth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public BaseEntityBookAuth() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
