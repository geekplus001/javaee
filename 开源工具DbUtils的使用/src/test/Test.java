package test;

import java.sql.SQLException;

import dao.PersonDAO;
import dao.PersonDaoImpl;

public class Test {

	public static void main(String[] args) throws SQLException {
		PersonDAO dao = new PersonDaoImpl();
//		dao.add(new Person("̬��",20,"̬�Ⱦ���һ��"));
//		dao.update(new Person(1,"С��",18,"ϴ���׵�С��"));
//		dao.delete(4);
//		Person p = dao.findById(1);
//		System.out.println(p);
//		List<Person> persons = dao.findAll();
//		System.out.println(persons);
		long count = dao.personCount();
		System.out.println(count);
	}

}
