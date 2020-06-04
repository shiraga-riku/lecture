package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import org.seasar.doma.Table;

@Entity
@Table(name = "recipe_menu")
public class RecipeMenu {
	@Column(name = "menu_id")
	private Integer menu_id;

	@Column(name = "recipe_id")
	private Integer recipe;

	public Integer getMenuId() {
		return menu_id;
	}

	public void setMenuId(Integer id) {
		this.menu_id = id;
	}

	public Integer getRercipeId() {
		return recipe;
	}

	public void setRecipeId(Integer id) {
		this.recipe = id;
	}
}
//レコードを表している