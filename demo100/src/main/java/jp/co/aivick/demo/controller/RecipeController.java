package jp.co.aivick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.RecipeForm;
import jp.co.aivick.demo.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	RecipeService recipeService;

	@GetMapping("/list")
	public String list(Model model) {

		List<Recipe> recipe = recipeService.findAll();
		model.addAttribute("recipeList", recipe);

		return "recipe/list.html";
	}

	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("recipeForm", new RecipeForm());
		return "recipe/create.html";
	}

	@PostMapping("/create")
	public String create(@Validated RecipeForm recipeForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "recipe/create.html";
		}

		Recipe recipe = new Recipe();
		recipe.setName(recipeForm.getName());
		recipe.setKcal(recipeForm.getKcal());
		Recipe createdRecipe = recipeService.create(recipe);

		return "redirect:/recipe/update/" + createdRecipe.getId();
	}
	
	@GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") String id, Model model) {
        Recipe recipe = recipeService.findBy(id);
        RecipeForm recipeForm = new RecipeForm();
        recipeForm.setId(recipe.getId());
        recipeForm.setName(recipe.getName());
        recipeForm.setKcal(recipe.getKcal());
        model.addAttribute("recipeForm", recipeForm);
        return "recipe/update.html";
    }
	
	@PostMapping("/update/{id}")
	public String Update(@PathVariable("id") String id, @Validated RecipeForm recipeForm,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "recipe/update.html";
        }
		Recipe recipe = recipeService.findBy(id);
        recipe.setName(recipeForm.getName());
        recipe.setKcal(recipeForm.getKcal());
        recipeService.update(recipe);

        return "redirect:/recipe/update/" + id;
	}

	@GetMapping("/search")
	public String search(@RequestParam(name = "search", required = false) String recipe, Model model) {
		if (recipe==null) {
			return "recipe/search.html";
		}
		List<Recipe> recipes = recipeService.search(recipe);
		model.addAttribute("recipeList", recipes);
		return "recipe/search.html";
	}

}