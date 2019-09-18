package cn.itcast.spring.sh.mvc;

public class PersonServiceImpl implements PersonService {
	private PersonDao personDao;
	@Override
	public void savePerson()
	{
		this.personDao.savePerson();
	}
	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
