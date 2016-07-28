package com.zetsubou_0.training.test.task007;

import com.zetsubou_0.training.task.task007.Task;
import com.zetsubou_0.training.task.task007.been.Animal;
import com.zetsubou_0.training.task.task007.been.AnimalType;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskTest extends BaseTest<Task> {

    @Test
    public void shouldReturnReverseListWithoutChangeOriginal() {
        Animal cat = new Animal(AnimalType.CAT, "neko", 1);
        Animal dog = new Animal(AnimalType.DOG, "wanko", 3);
        Animal crocodile = new Animal(AnimalType.OTHER, "wani", 5);
        List<Animal> animals = new LinkedList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(crocodile);

        Iterator<Animal> iterator = animals.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(cat, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(dog, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(crocodile, iterator.next());
        assertFalse(iterator.hasNext());

        List<Animal> result = sut.reverse(animals);
        iterator = result.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(crocodile, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(dog, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(cat, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldReturnOnlyCats() {
        Animal cat = new Animal(AnimalType.CAT, "neko", 1);
        Animal dog = new Animal(AnimalType.DOG, "wanko", 3);
        Animal crocodile = new Animal(AnimalType.OTHER, "wani", 5);
        Animal cat2 = new Animal(AnimalType.CAT, "neko", 11);
        Animal dog2 = new Animal(AnimalType.DOG, "wanko", 13);
        Animal crocodile2 = new Animal(AnimalType.OTHER, "wani", 15);
        Animal cat3 = new Animal(AnimalType.CAT, "neko", 21);
        Animal dog3 = new Animal(AnimalType.DOG, "wanko", 23);
        Animal crocodile3 = new Animal(AnimalType.OTHER, "wani", 25);
        Animal bird = new Animal(AnimalType.OTHER, "wani", 34);

        List<Animal> animals = new LinkedList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(crocodile);
        animals.add(cat2);
        animals.add(dog2);
        animals.add(crocodile3);
        animals.add(cat3);
        animals.add(crocodile2);
        animals.add(bird);
        animals.add(dog3);

        List<Animal> cats = sut.getAnimalsByType(animals, AnimalType.CAT);

        assertEquals(3, cats.size());
        assertTrue(cats.contains(cat));
        assertTrue(cats.contains(cat2));
        assertTrue(cats.contains(cat3));
    }
}
