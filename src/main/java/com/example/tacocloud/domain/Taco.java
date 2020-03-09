package com.example.tacocloud.domain;

import lombok.Data;

import java.util.List;

/**
 * @author hjj
 * @create 2020-03-09 12:40
 */
@Data
public class Taco {
    private String name;
    private List<String> ingredients;
}
