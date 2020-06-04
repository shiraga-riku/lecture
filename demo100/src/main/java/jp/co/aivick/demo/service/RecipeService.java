package jp.co.aivick.demo.service;

import java.util.List;
import jp.co.aivick.demo.dao.RecipeDao;
import jp.co.aivick.demo.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {
	@Autowired
	private RecipeDao recipeDao;

	public Recipe findBy(String id) {
		return recipeDao.find(id);
	}

	public List<Recipe> findAll() {
		return this.recipeDao.findAll();
	}

	@Transactional
	public Recipe create(Recipe recipe) {
		recipeDao.insert(recipe);
		return recipe;
	}

	@Transactional
	public Recipe update(Recipe recipe) {
		recipeDao.update(recipe);
		return recipe;
	}
}
