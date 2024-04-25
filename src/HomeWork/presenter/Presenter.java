package HomeWork.presenter;

import HomeWork.model.FamilyTree;
import HomeWork.model.Human;
import HomeWork.model.IO;
import HomeWork.model.comporator.HumanComparatorByAge;
import HomeWork.model.comporator.HumanComparatorByName;
import HomeWork.ui.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private IO serialize;
    private FamilyTree<Human> familyConnect;
    private HumanComparatorByAge sortAge;
    private HumanComparatorByName sortName;

    public Presenter(View view, FamilyTree<Human> familyConnect, IO serialize) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        this.sortName = sortName;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String surname, String middlename, String sex, LocalDate age) {
        familyConnect.addFamilyTree(new Human(name, surname, middlename, sex, age));
        view.print("Новый человек добавлен");
    }

    public void familyPrint() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Человек не найден");
        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        familyConnect.saveObj(serialize);
        view.print("Семейное древо сохранено");
    }

    public void loadFamily() {
        serialize.load("TreeFamily.data");
    }

    public void sortFamilyName() {
        familyConnect.getFamilyTree().sort(sortName);
        view.print("Сортировка по имени завершена");
        view.print(familyConnect.toString());
    }

    public void sortFamilyAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка по возрасту завершена");
        view.print(familyConnect.toString());
    }
}