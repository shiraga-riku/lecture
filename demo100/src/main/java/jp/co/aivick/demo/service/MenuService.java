package jp.co.aivick.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.demo.dao.MenuDao;
import jp.co.aivick.demo.dao.RecipeMenuDao;
import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.RecipeMenu;

@Service
public class MenuService {
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RecipeMenuDao recipeMenuDao;

	public Menu findBy(String id) {
		return menuDao.find(id);
	}

	public List<Menu> findAll() {
		return this.menuDao.findAll();
	}

	@Transactional
	public Menu create(Menu menu,String[] recipes) {
		Result<Menu> menuresult=menuDao.insert(menu);
		Menu createdmenu=menuresult.getEntity();
		List<RecipeMenu> recipemenu=IntStream.range(0,recipes.length)
				.mapToObj(i->{
					RecipeMenu rm=new RecipeMenu();
					rm.setRecipeId(Integer.parseInt(recipes[i]));
					rm.setMenuId(createdmenu.getId());
					return rm;
				})
				.collect(Collectors.toList());
		recipeMenuDao.insert(recipemenu);
		return createdmenu;
	}

//	@Transactional
//	public Menu update(Menu menu) {
//		menuDao.update(menu);
//		return menu;
//	}

}
