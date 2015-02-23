package ke.co.greid.usermgmt;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ke.co.greid.model.Person;

@Controller
@ManagedBean(name = "testService")
@ViewScoped
public class TestService implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Person> persons=new ArrayList<Person>();
	
//	@Resource(name="jdbc/openschool")
//	private DataSource ds;

	@Autowired
	private UserMgmtServiceImpl service;

	public TestService() {
		System.out.println("TBean has been Initialized...");
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	
	@PostConstruct
	public void populatePersonList() {
		persons.addAll(service.getPersons());
		System.out.println("About to print the persons");
		System.out.println(persons);
		//doSomething();

	}
	
	
	

	public void setService(UserMgmtServiceImpl service) {
		this.service = service;
	}
	
//	public void doSomething(){
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement ps 
//			= con.prepareStatement(
//			   "select * from countries");
//			ResultSet result =  ps.executeQuery();
//			while(result.next()){
//				System.out.println(result.getString(1));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
