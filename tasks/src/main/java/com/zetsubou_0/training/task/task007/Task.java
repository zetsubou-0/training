package com.zetsubou_0.training.task.task007;

import com.zetsubou_0.training.task.task007.been.Animal;
import com.zetsubou_0.training.task.task007.been.AnimalType;

import java.util.*;

public interface Task {

    /**
     * Написать метод для получения нового листа,
     * итерация по которому происходит в обратном порядке,
     * оригинальный лист остается без изменений
     * @param animals входной лист с животными
     * @return лист в обратном порядке
     */
    List<Animal> reverse(final List<Animal> animals);

    /**
     * Получить коллекцию животных,содержащию животных только 1-го типа
     * @param animals входной лист с животными
     * @param type тип животного
     * @return коллекция с животными одного типа
     */
    List<Animal> getAnimalsByType(final List<Animal> animals, final AnimalType type);

    /**
     * Получить коллекцию неповоряющихся животных
     * @param animals входной лист с животными
     * @return коллекция неповоряющихся животных
     */
    List<Animal> getUniqueList(final List<Animal> animals);

    /**
     * Получить пары ключ-значение, тип живоного и отсортированное множество уникальныхживотных
     * @param animals входной лист с животными
     * @return пары ключ-значение, тип живоного и отсортированное множество уникальныхживотных
     */
    Map<AnimalType, SortedSet<Animal>> sortAnimals(final List<Animal> animals);
}
