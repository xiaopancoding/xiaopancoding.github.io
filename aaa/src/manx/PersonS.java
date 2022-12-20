package manx;

public class PersonS {
    String name;
    char sex;
    int age;
    public PersonS() {

    }

    public PersonS(String name, char sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat() {
        System.out.println("吃饭");
    }
}
