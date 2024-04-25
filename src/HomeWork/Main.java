package HomeWork;

import java.io.IOException;
import java.time.LocalDate;

import HomeWork.model.FamilyTree;
import HomeWork.model.Human;
import HomeWork.model.IO;
import HomeWork.presenter.Presenter;
import HomeWork.ui.Console;
import HomeWork.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();


        familyTree.addFamilyTree(new Human("Ольга", "Моторина", "Олеговна", "жен", LocalDate.of(1999, 12, 3)));
        familyTree.addFamilyTree(new Human("Виктория", "Юрьевна", "Молчанова", "жен", LocalDate.of(1901, 1, 9)));
        familyTree.getByName("Ольга");

        View view = new Console();
        IO serialize = new IO();
        new Presenter(view, familyTree, serialize);
        view.start();
    }
}

