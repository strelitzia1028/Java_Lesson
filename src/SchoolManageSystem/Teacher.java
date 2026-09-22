package SchoolManageSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teacher extends Person {
    private static final List<Teacher> teachers = new ArrayList<>();

    public Teacher() {}

    public Teacher(String name, int age) {
        super(name, age);
    }

    public static boolean add(String name, int age) {
        if (name == null || name.trim().isEmpty() || age < 0) {
            return false;
        }
        teachers.add(new Teacher(name.trim(), age));
        return true;
    }

    public static List<Teacher> search(String name) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(name)) {
                result.add(teacher);
            }
        }
        return result;
    }

    public static boolean update(String oldName, String newName, int newAge) {
        if (newName == null || newName.trim().isEmpty() || newAge < 0) {
            return false;
        }
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(oldName)) {
                teacher.setName(newName.trim());
                teacher.setAge(newAge);
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String name) {
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static List<Teacher> getAll() {
        return new ArrayList<>(teachers);
    }

    @Override
    public String toString() {
        return "教师[" + super.toString() + "]";
    }
}
