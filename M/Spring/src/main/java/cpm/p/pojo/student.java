package cpm.p.pojo;

import java.util.Arrays;

public class student {

    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String[] str;
    private Clazz clazz;

    public student() {

    }

    public student(Integer id, String name, String gender, Integer age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", str=" + Arrays.toString(str) +
                ", clazz=" + clazz +
                '}';
    }
}
