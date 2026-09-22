package SchoolManageSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student extends Person {
    private static final List<Student> students = new ArrayList<>();

    public Student() {}

    public Student(String name, int age) {
        super(name, age);
    }

    public static boolean add(String name, int age) {
        if (name == null || name.trim().isEmpty() || age < 0) {
            return false;
        }
        students.add(new Student(name.trim(), age));
        return true;
    }

    public static List<Student> search(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public static boolean update(String oldName, String newName, int newAge) {
        if (newName == null || newName.trim().isEmpty() || newAge < 0) {
            return false;
        }
        for (Student student : students) {
            if (student.getName().equals(oldName)) {
                student.setName(newName.trim());
                student.setAge(newAge);
                return true;
            }
        }
        return false;
    }

    public static boolean delete(String name) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static List<Student> getAll() {
        return new ArrayList<>(students);
    }

    @Override
    public String toString() {
        return "学生[" + super.toString() + "]";
    }
}
