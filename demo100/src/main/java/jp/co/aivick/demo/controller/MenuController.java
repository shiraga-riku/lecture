package jp.co.aivick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.MenuForm;
import jp.co.aivick.demo.service.MenuService;
import jp.co.aivick.demo.service.RecipeService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	MenuService menuService;
	@Autowired
	RecipeService recipeService;

	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("menuForm", new MenuForm());
		List<Recipe> recipe = recipeService.findAll();
		model.addAttribute("recipeList", recipe);
		return "menu/create.html";
	}

	@PostMapping("/create")
	public String create(@Validated MenuForm menuForm, BindingResult bindingResult, Model model) {
		//バリデーションをした結果がbindingResultに入る
		if (bindingResult.hasErrors()) {
			return "menu/create.html";
		}

		Menu menu = new Menu(null,menuForm.getName(),menuForm.getType(),menuForm.getPrice());
		
//		menu.setName(menuForm.getName());
//		menu.setType(menuForm.getType());
//		menu.setPrice(menuForm.getPrice());
		
		menuService.create(menu,menuForm.getRecipe());

		return "redirect:/";
	}
}
