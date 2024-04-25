package HomeWork.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class Description implements Serializable, Comparable<Description> {
    private String name;
    private String surname;
    private String middlename;
    private String sex;
    private LocalDate age;
    private Description mother;
    private Description father;
    private List<Description> children;

    public Description(String name, String surname, String middlename, String sex, LocalDate age, Description mother, Description father) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Description(String name, String surname, String middlename, String sex, LocalDate age) {
        this(name, surname, middlename, sex, age, null, null);
    }

    public void addChild(Description child) {
        if (!children.contains(child)) {
            this.children.add(child);
            if (this.sex == "муж.") {
                child.father = this;
            } else
                child.mother = this;
        }
    }

    public String printChildren() {
        String res = "\nДети: ";
        if (!this.children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                res += children.get(i).name + ",";
            }
        } else
            res += "\nнет";
        return res;
    }

    @Override
    public String toString() {
        String res = "\nИмя: " + name + "\nФамилия: " + surname + "\nОтчество: " + middlename + "\nПол: " + sex + "\nДата рождения: " + age;
        if (this.mother != null) {
            res += "\nМать: " + mother.name;
        } else
            res += "\nМать: нет";

        if (this.father != null) {
            res += "\nОтец: " + father.name + ",";
        } else
            res += "\nОтец: нет,";

        res += printChildren();

        return res;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public Description getFather() {
        return father;
    }

    public Description getMother() {
        return mother;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = LocalDate.ofEpochDay(age);
    }

    @Override
    public int compareTo(Description o) {
        return name.compareToIgnoreCase(o.name);
    }
}