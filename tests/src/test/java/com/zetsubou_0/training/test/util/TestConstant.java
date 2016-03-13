package com.zetsubou_0.training.test.util;

public class TestConstant {

    public static class Test001 {
        public static final String ZERO_VALUE = "Метод возвращает false для 0";
        public static final String SHOULD_BE_POSITIVE = "Метод возвращает false для положительного значения";
        public static final String SHOULD_BE_NEGATIVE = "Метод возвращает true для отрицательного значения";
    }

    public static class Test002 {
        public static final String ZERO_VALUE = "Метод не возвращает \"zero\" для 0";
        public static final String SHOULD_BE_POSITIVE = "Метод не возвращает \"positive\" для положительного значения";
        public static final String SHOULD_BE_NEGATIVE = "Метод не возвращает \"negative\" для отрицательного значения";
    }

    public static class Test004 {
        public static final String UNEXPECTED_ARRAY = "Возвращается не верный мыссив. Массив должен содержать числа Фибонфччи.";
    }
}
