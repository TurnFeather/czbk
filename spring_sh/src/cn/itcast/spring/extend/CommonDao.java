package cn.itcast.spring.extend;

public class CommonDao {
	private String abc;
	public void saveEntity()
	{
		System.out.println("save entity");
	}
	
	public void updateEntity(){
		System.out.println("update entity");
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}
}
