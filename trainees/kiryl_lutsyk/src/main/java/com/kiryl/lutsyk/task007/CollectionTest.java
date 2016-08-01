package com.kiryl.lutsyk.task007;

import com.zetsubou_0.training.task.task007.Task;
import com.zetsubou_0.training.task.task007.been.Animal;
import com.zetsubou_0.training.task.task007.been.AnimalType;

import java.util.*;

public class CollectionTest implements Task {

    public List<Animal> reverse(final List<Animal> animals) {
        List<Animal> result = new LinkedList<>(animals);
        Collections.reverse(result);
        return result;
    }

    public List<Animal> getAnimalsByType(final List<Animal> animals, final AnimalType type) {
        List<Animal> result = new LinkedList<>();
        for (Animal animal : animals) {
            if (animal.getType() == type) {
                result.add(animal);
            }
        }
        return result;
    }

    public List<Animal> getUniqueList(final List<Animal> animals) {
        Set<Animal> animalSet = new HashSet<>(animals);
        return new LinkedList<>(animalSet);
    }

    public Map<AnimalType, SortedSet<Animal>> sortAnimals(final List<Animal> animals) {
        Map<AnimalType, SortedSet<Animal>> result = new HashMap<>();
        for (AnimalType type : AnimalType.values()) {
            List<Animal> animalList = getAnimalsByType(animals, type);
            SortedSet<Animal> sortedAnimals = new TreeSet<>((animal1, animal2) ->
                    animal1.getAge() - animal2.getAge());
            sortedAnimals.addAll(animalList);
            result.put(type, sortedAnimals);
        }
        return result;
    }

}
