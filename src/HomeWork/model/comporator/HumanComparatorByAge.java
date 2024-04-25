package HomeWork.model.comporator;

import java.time.LocalDate;
import java.util.Comparator;

import HomeWork.model.Human;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        LocalDate date1 = o1.getAge();
        LocalDate date2 = o2.getAge();

        return date1.compareTo(date2);
    }

}