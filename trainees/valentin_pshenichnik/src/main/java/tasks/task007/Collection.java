package tasks.task007;

import com.zetsubou_0.training.task.task007.Task;
import com.zetsubou_0.training.task.task007.been.Animal;
import com.zetsubou_0.training.task.task007.been.AnimalType;

import java.util.*;

/**
 * Created by Torus on 08.09.2016.
 */
public class Collection implements Task {
    @Override
    public List<Animal> reverse(List<Animal> animals) {
        List<Animal> newAnimal = new ArrayList<>();
        ListIterator<Animal> listIterator = animals.listIterator();
        while (listIterator.hasPrevious()){
            newAnimal.add(listIterator.previous());
        }
        return newAnimal;
    }

    @Override
    public List<Animal> getAnimalsByType(List<Animal> animals, AnimalType type) {

        List<Animal> newList = new ArrayList<>();
        for (Animal animal:animals) {
            if (animal.getType().equals(1)){
                newList.add(animal);
            }
        }
        return newList;
    }

    @Override
    public List<Animal> getUniqueList(List<Animal> animals) {
        Set<Animal> set = new HashSet<>();
        List<Animal> newList = new ArrayList<>();
        for (Animal animal: animals) {
            set.add(animal);
        }
        for (Animal animal: set) {
            newList.add(animal);
        }
        return newList;
    }

    @Override
    public Map<AnimalType, SortedSet<Animal>> sortAnimals(List<Animal> animals) {
        SortedSet<Animal> set = new TreeSet<>();
        Map<AnimalType, SortedSet<Animal>> map = new HashMap<>();
        for (Animal animal: animals) {
            set.add(animal);
            map.put(animal.getType(),set);
        }

        return map;
    }
}
