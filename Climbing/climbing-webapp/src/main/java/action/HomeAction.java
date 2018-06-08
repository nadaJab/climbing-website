package action;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	private String name;
	private String firstName;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
