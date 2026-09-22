public class Member{
    private String name;
    private String gender;
    private int age;

    public Member(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args){
        Member member = new Member();
        member.setName("Alan");
        member.setGender("Male");
        member.setAge(18);
        System.out.println("Name: " + member.getName());
        System.out.println("Gender: " + member.getGender());
        System.out.println("Age: " + member.getAge());
    }
}
