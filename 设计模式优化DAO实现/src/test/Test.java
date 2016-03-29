package test;

import java.sql.SQLException;
import java.util.List;

import dao.PersonDAO;
import dao.impl.PersonDAOImpl;
import domain.Person;

public class Test {
	public static void main(String[] args) {
//		PersonDAO dao = new PersonDAOImpl();
		PersonDAO dao = new PersonDAOImpl();
		try {
//			dao.add(new Person("小黑",19,"是一个很黑很黑的人"));
//			Person p = dao.findById(2);
			List<Person> persons = dao.findAll();
			System.out.println(persons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
