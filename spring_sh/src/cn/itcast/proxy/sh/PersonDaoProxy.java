package cn.itcast.proxy.sh;

public class PersonDaoProxy implements PersonDao {
	private PersonDao personDao;
	private Transaction transaction;
	public PersonDaoProxy(PersonDao personDao,Transaction transaction)
	{
		this.personDao = personDao;
		this.transaction = transaction;
	}
	
	@Override
	public void savePerson() {
		transaction.beginTransaction();
		personDao.savePerson();
		transaction.commit();
	}

	@Override
	public void updatePerson() {
		transaction.beginTransaction();
		personDao.updatePerson();
		transaction.commit();
	}

	@Override
	public void deletePerson() {
		transaction.beginTransaction();
		personDao.deletePerson();
		transaction.commit();
	}

}
