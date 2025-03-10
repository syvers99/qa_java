package com.example;

import java.util.List;

public class ConfigConst {
    public static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");
    public static final String  PREDATOR = "Хищник";
    public static final String  INSECT = "Жук";
    public static final String  HERBIVORE = "Травоядное";
    public static final List<String> HERBIVORE_FOOD = List.of("Трава", "Различные растения");
    public static final String MALE = "Самец";
    public static final String  FEMALE = "Самка";
    public static final String CAT_SOUND = "Мяу";
    public static final String  FELINE = "Кошачьи";
    public static final String EMPTY_VALUE = "";
    public static final String NULL_VALUE = null;
    public static final String  FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, " +
            "кошачьи, псовые, медвежьи, куньи";
    public static final String  ANIMAL_EXCEPTION_MESSAGE = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    public static final String MANE_EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";
}
