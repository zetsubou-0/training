package com.zetsubou_0.training.task.task007.been;

public class Animal {

    private final AnimalType type;

    private final String name;

    private final int age;

    public Animal(final AnimalType type, final String name, final int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public AnimalType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age || type != animal.type) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
