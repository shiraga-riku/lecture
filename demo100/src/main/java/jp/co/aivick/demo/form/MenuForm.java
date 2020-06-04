package jp.co.aivick.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MenuForm {
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String type;

	@NotNull
	private Integer price;
	
	private String[] recipe;
	
	public String[] getRecipe() {
		return recipe;
	}
	
	public void setRecipe(String[] recipe) {
		this.recipe=recipe;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
