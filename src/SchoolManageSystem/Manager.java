package SchoolManageSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager extends Person {
    private static final List<Manager> managers = new ArrayList<>();

    public Manager() {}

    public Manager(String name, int age) {
        super(name, age);
    }

    public static boolean add(String name, int age) {
        if (name == null || name.trim().isEmpty() || age < 0) {
            return false;
        }
        managers.add(new Manager(name.trim(), age));
        return true;
    }

    public static List<Manager> search(String name) {
        List<Manager> result = new ArrayList<>();
        for (Manager manager : managers) {
            if (manager.getName().equals(name)) {
                result.add(manager);
            }
        }
        return result;
    }

    public static boolean update(String oldName, String newName, int newAge) {
        if (newName == null || newName.trim().isEmpty() || newAge < 0) {
            return false;
        }
        for (Manager manager : managers) {
            if (manager.getName().equals(oldName)) {
                manager.setName(newName.trim());
                manager.setAge(newAge);
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String name) {
        Iterator<Manager> iterator = managers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static List<Manager> getAll() {
        return new ArrayList<>(managers);
    }

    @Override
    public String toString() {
        return "管理员[" + super.toString() + "]";
    }
}
