package HomeWork.ui;

import java.time.LocalDate;
import java.util.Scanner;

import HomeWork.presenter.Presenter;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;
    private String surname;
    private String middlename;

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go) {
            header();
            menuUi();
            System.out.print("Выберите действие: ");
            String command = scan.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Введите число: ");
            }
        }
    }

    private void header() {
        System.out.println("   - Семейное древо -");
    }

    private void menuUi() {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew() {
        System.out.print("Введите имя: ");
        String name = scan();
        System.out.print("Введите фамилию: ");
        surname = scan();
        System.out.print("Введите отчество: ");
        middlename = scan();
        System.out.print("Введите пол (муж./жен.):  ");
        String sex = scan();
        System.out.print("Введите возраст:  ");
        LocalDate age = LocalDate.ofEpochDay(Integer.parseInt(scan()));
        presenter.addHumanNew(name, surname, middlename, sex, age);
    }

    public void familyPrint() {
        presenter.familyPrint();
    }

    public void humanSearch() {
        System.out.print("Введите имя человека для поиска: ");
        String name = scan();
        presenter.humanSearch(name);
    }

    public void saveFamily() {
        presenter.saveFamily();
    }

    public void loadFamily() {
        presenter.loadFamily();
    }

    public void sortFamilyName() {
        presenter.sortFamilyName();
    }

    public void sortFamilyAge() {
        presenter.sortFamilyAge();
    }

    public void end() {
        go = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}