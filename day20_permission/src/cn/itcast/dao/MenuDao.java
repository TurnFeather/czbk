package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Menu;

public interface MenuDao {
	public void addMenu(Menu m);
	public List<Menu> findAllMenu();
	public Menu fineMenuById(String menuId);
	public void updateMeun(Menu m);
	public void deleteMenu(String menuId);
}
