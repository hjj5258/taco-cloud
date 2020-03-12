package com.example.tacocloud.controller;

import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.domain.Ingredient.Type;
import com.example.tacocloud.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hjj
 * @create 2020-03-09 12:25
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    /**
     * 展示表单
     *
     * @param model
     * @return
     */
    @GetMapping()
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "面粉玉米饼", Type.WRAP),
                new Ingredient("COTO", "玉米饼", Type.WRAP),
                new Ingredient("GRBF", "碎牛肉", Type.PROTEIN),
                new Ingredient("CARN", "馅料", Type.PROTEIN),
                new Ingredient("TMTO", "西红柿丁", Type.VEGGIES),
                new Ingredient("LETC", "生菜", Type.VEGGIES),
                new Ingredient("CHED", "干酪", Type.CHEESE),
                new Ingredient("JACK", "杰克牌奶酪", Type.CHEESE),
                new Ingredient("SLSA", "萨尔萨牌沙司", Type.SAUCE),
                new Ingredient("SRCR", "酸奶油", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping()
    public String Save() {
        return "design";
    }


    /**
     * 过滤类型
     * @param ingredients
     * @param type
     * @return
     */
    private List<Ingredient> filterByType(
            List<Ingredient> ingredients,
            Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
