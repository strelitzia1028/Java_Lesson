public class Member {
    String name;
    int age;
    int height;
    int weight;

    public Member(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        System.out.println(name + " " + age + " " + height + " " + weight);
    }

    public static void main(String[] args) {
        Member new_member = new Member("Jack", 18, 175, 60);
    }
}