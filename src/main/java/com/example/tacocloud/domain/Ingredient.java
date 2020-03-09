package com.example.tacocloud.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author hjj
 * @create 2020-03-09 12:17
 * 成分
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    /**
     * 类型
     */
    public static enum Type {

        /**
         * 包裹
         */
        WRAP,
        /**
         * 蛋白质
         */
        PROTEIN,
        /**
         * 蔬菜
         */
        VEGGIES,
        /**
         * 奶酪
         */
        CHEESE,
        /**
         * 沙司
         */
        SAUCE
    }
}
