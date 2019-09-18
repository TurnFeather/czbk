package cn.itcast.proxy.sh;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

	@Override
	public void updatePerson() {
		System.out.println("update person");
	}

	@Override
	public void deletePerson() {
		System.out.println("delete person");
	}

}
