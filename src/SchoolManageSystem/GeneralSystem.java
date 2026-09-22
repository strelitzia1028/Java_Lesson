package SchoolManageSystem;

import java.util.List;
import java.util.Scanner;

public class GeneralSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--已进入主系统--");

        while (true) {
            System.out.println("\n输入 0\t退出系统");
            System.out.println("输入 1\t进入学生系统");
            System.out.println("输入 2\t进入教师系统");
            System.out.println("输入 3\t进入管理员系统");

            int choice = readInt(sc, "请输入选项：");
            switch (choice) {
                case 0:
                    System.out.println("\n--已退出主系统--");
                    sc.close();
                    return;
                case 1:
                    studentSystem(sc);
                    break;
                case 2:
                    teacherSystem(sc);
                    break;
                case 3:
                    managerSystem(sc);
                    break;
                default:
                    System.out.println("\n请输入有效选项！");
            }
        }
    }

    // 学生系统
    private static void studentSystem(Scanner sc) {
        System.out.println("\n--已进入学生系统--");
        while (true) {
            System.out.println("\n输入 0\t添加学生");
            System.out.println("输入 1\t搜索和更改学生");
            System.out.println("输入 2\t删除学生");
            System.out.println("输入 3\t查看所有学生");
            System.out.println("输入 4\t返回主系统");

            int op = readInt(sc, "请输入操作：");
            switch (op) {
                case 0: {
                    System.out.print("\n（格式）学生姓名 学生年龄：");
                    String name = sc.next();
                    int age = readInt(sc, "");
                    if (Student.add(name, age)) {
                        System.out.println("\n添加学生成功！");
                    } else {
                        System.out.println("\n添加失败：姓名不能为空，年龄不能为负数！");
                    }
                    break;
                }
                case 1:
                    updateStudent(sc);
                    break;
                case 2: {
                    System.out.print("\n请输入要删除的学生姓名：");
                    String name = sc.next();
                    if (Student.delete(name)) {
                        System.out.println("\n删除学生成功！");
                    } else {
                        System.out.println("\n未找到该学生！");
                    }
                    break;
                }
                case 3:
                    listStudents();
                    break;
                case 4:
                    System.out.println("\n--已返回主系统--");
                    return;
                default:
                    System.out.println("\n请输入有效选项！");
            }
        }
    }

    private static void updateStudent(Scanner sc) {
        System.out.print("\n请输入要搜索的学生姓名：");
        String oldName = sc.next();
        List<Student> found = Student.search(oldName);
        if (found.isEmpty()) {
            System.out.println("\n未找到该学生！");
            return;
        }
        System.out.println("\n找到 " + found.size() + " 个学生：");
        for (Student student : found) {
            System.out.println(student);
        }

        System.out.print("\n请输入新的学生姓名：");
        String newName = sc.next();
        int newAge = readInt(sc, "请输入新的学生年龄：");
        if (Student.update(oldName, newName, newAge)) {
            System.out.println("\n更改学生成功！（同名时只更改第一个）");
        } else {
            System.out.println("\n更改失败：新姓名不能为空，年龄不能为负数！");
        }
    }

    private static void listStudents() {
        List<Student> students = Student.getAll();
        if (students.isEmpty()) {
            System.out.println("\n暂无学生信息。");
            return;
        }
        System.out.println("\n所有学生：");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 教师系统
    private static void teacherSystem(Scanner sc) {
        System.out.println("\n--已进入教师系统--");
        while (true) {
            System.out.println("\n输入 0\t添加教师");
            System.out.println("输入 1\t搜索和更改教师");
            System.out.println("输入 2\t删除教师");
            System.out.println("输入 3\t查看所有教师");
            System.out.println("输入 4\t返回主系统");

            int op = readInt(sc, "请输入操作：");
            switch (op) {
                case 0: {
                    System.out.print("\n（格式）教师姓名 教师年龄：");
                    String name = sc.next();
                    int age = readInt(sc, "");
                    if (Teacher.add(name, age)) {
                        System.out.println("\n添加教师成功！");
                    } else {
                        System.out.println("\n添加失败：姓名不能为空，年龄不能为负数！");
                    }
                    break;
                }
                case 1:
                    updateTeacher(sc);
                    break;
                case 2: {
                    System.out.print("\n请输入要删除的教师姓名：");
                    String name = sc.next();
                    if (Teacher.delete(name)) {
                        System.out.println("\n删除教师成功！");
                    } else {
                        System.out.println("\n未找到该教师！");
                    }
                    break;
                }
                case 3:
                    listTeachers();
                    break;
                case 4:
                    System.out.println("\n--已返回主系统--");
                    return;
                default:
                    System.out.println("\n请输入有效选项！");
            }
        }
    }

    private static void updateTeacher(Scanner sc) {
        System.out.print("\n请输入要搜索的教师姓名：");
        String oldName = sc.next();
        List<Teacher> found = Teacher.search(oldName);
        if (found.isEmpty()) {
            System.out.println("\n未找到该教师！");
            return;
        }
        System.out.println("\n找到 " + found.size() + " 个教师：");
        for (Teacher teacher : found) {
            System.out.println(teacher);
        }

        System.out.print("\n请输入新的教师姓名：");
        String newName = sc.next();
        int newAge = readInt(sc, "请输入新的教师年龄：");
        if (Teacher.update(oldName, newName, newAge)) {
            System.out.println("\n更改教师成功！（同名时只更改第一个）");
        } else {
            System.out.println("\n更改失败：新姓名不能为空，年龄不能为负数！");
        }
    }

    private static void listTeachers() {
        List<Teacher> teachers = Teacher.getAll();
        if (teachers.isEmpty()) {
            System.out.println("\n暂无教师信息。");
            return;
        }
        System.out.println("\n所有教师：");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    // 管理员系统
    private static void managerSystem(Scanner sc) {
        System.out.println("\n--已进入管理员系统--");
        while (true) {
            System.out.println("\n输入 0\t添加管理员");
            System.out.println("输入 1\t搜索和更改管理员");
            System.out.println("输入 2\t删除管理员");
            System.out.println("输入 3\t查看所有管理员");
            System.out.println("输入 4\t返回主系统");

            int op = readInt(sc, "请输入操作：");
            switch (op) {
                case 0: {
                    System.out.print("\n（格式）管理员姓名 管理员年龄：");
                    String name = sc.next();
                    int age = readInt(sc, "");
                    if (Manager.add(name, age)) {
                        System.out.println("\n添加管理员成功！");
                    } else {
                        System.out.println("\n添加失败：姓名不能为空，年龄不能为负数！");
                    }
                    break;
                }
                case 1:
                    updateManager(sc);
                    break;
                case 2: {
                    System.out.print("\n请输入要删除的管理员姓名：");
                    String name = sc.next();
                    if (Manager.delete(name)) {
                        System.out.println("\n删除管理员成功！");
                    } else {
                        System.out.println("\n未找到该管理员！");
                    }
                    break;
                }
                case 3:
                    listManagers();
                    break;
                case 4:
                    System.out.println("\n--已返回主系统--");
                    return;
                default:
                    System.out.println("\n请输入有效选项！");
            }
        }
    }

    private static void updateManager(Scanner sc) {
        System.out.print("\n请输入要搜索的管理员姓名：");
        String oldName = sc.next();
        List<Manager> found = Manager.search(oldName);
        if (found.isEmpty()) {
            System.out.println("\n未找到该管理员！");
            return;
        }
        System.out.println("\n找到 " + found.size() + " 个管理员：");
        for (Manager manager : found) {
            System.out.println(manager);
        }

        System.out.print("\n请输入新的管理员姓名：");
        String newName = sc.next();
        int newAge = readInt(sc, "请输入新的管理员年龄：");
        if (Manager.update(oldName, newName, newAge)) {
            System.out.println("\n更改管理员成功！（同名时只更改第一个）");
        } else {
            System.out.println("\n更改失败：新姓名不能为空，年龄不能为负数！");
        }
    }

    private static void listManagers() {
        List<Manager> managers = Manager.getAll();
        if (managers.isEmpty()) {
            System.out.println("\n暂无管理员信息。");
            return;
        }
        System.out.println("\n所有管理员：");
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }

    // 工具方法
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            if (prompt != null && !prompt.isEmpty()) {
                System.out.print(prompt);
            }
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } else {
                System.out.println("请输入有效数字！");
                sc.nextLine();
            }
        }
    }
}
