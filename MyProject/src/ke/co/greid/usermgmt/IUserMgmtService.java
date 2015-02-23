package ke.co.greid.usermgmt;

import java.util.List;

import org.springframework.stereotype.Component;

import ke.co.greid.model.Person;

@Component
public interface IUserMgmtService{
	public List<Person> getPersons();

}
