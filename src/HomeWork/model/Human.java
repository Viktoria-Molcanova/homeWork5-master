package HomeWork.model;

import java.io.Serial;
import java.time.LocalDate;

public class Human extends Description {
    @Serial
    private static final long serialVersionUID = 1L;

    public Human(String name, String surname, String middlename, String sex, LocalDate age) {
        super(name,surname,middlename, sex, age);
    }

    public Human(String name, String surname, String middlename, String sex, LocalDate age, Description mather, Description father) {
        super(name,surname,middlename, sex, age);
    }
}
