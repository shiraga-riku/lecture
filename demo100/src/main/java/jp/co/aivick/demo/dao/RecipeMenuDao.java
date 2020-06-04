package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.RecipeMenu;
@ConfigAutowireable
@Dao
public interface RecipeMenuDao {
	@BatchInsert
	int[] insert(List<RecipeMenu> recipeMenu);
	

}
