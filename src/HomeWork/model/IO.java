package HomeWork.model;

import HomeWork.ui.Comm.Save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IO implements Load, Save {

    // Загрузка
    @Override
    public Serializable load(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRestored = (Serializable) objectInputStream.readObject();
            System.out.println("\nСемейное древо загружено !\n");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    // Сохранение
    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
