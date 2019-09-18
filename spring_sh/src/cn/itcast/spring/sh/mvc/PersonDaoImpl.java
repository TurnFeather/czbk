package cn.itcast.spring.sh.mvc;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person dao");
	}

}
