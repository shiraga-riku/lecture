package jp.co.aivick.demo.controller;

import java.util.List;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.RecipeForm;
import jp.co.aivick.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController{
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


}