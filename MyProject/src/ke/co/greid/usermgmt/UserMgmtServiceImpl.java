package ke.co.greid.usermgmt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import ke.co.greid.model.Person;

@ManagedBean(name="userService")
@ApplicationScoped
@Component
public class UserMgmtServiceImpl implements IUserMgmtService,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserMgmtServiceImpl() {
		System.out.println("User Management has been auto wired");
	}

	@Override
	public List<Person> getPersons() {
		List<Person> list=new ArrayList<Person>();
		list.add(new Person("Stanslaus", "301 Kisumu", 27));
		list.add(new Person("Edwin", "301 Nakuru", 29));
		list.add(new Person("Wamalwa", "44 Witete", 45));
		return list;
	}
	public void someOtherMethod(){
		System.out.println("This is a demp");
	}

}
