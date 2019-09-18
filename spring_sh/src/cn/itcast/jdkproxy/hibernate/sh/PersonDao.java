package cn.itcast.jdkproxy.hibernate.sh;

import java.io.Serializable;

public interface PersonDao {
	public void savePerson(Person person);
	public void updatePerson(Serializable id);
	public void deletePerson(Serializable id);
}
