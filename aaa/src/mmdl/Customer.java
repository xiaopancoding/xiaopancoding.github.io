package mmdl;

public class Customer {
    private int id;
    private String phone;
    private String email;
    private String name;
    private int age;
    private String gender;
    Customer next;

    /**
     * @setAge:设置年龄
     * @setEmail:设置邮箱
     * @setGender:设置性别
     * @setPhone:设置电话号码
     * @getAge：获取年龄
     * @getPhone：获取电话号码
     * @getName：获取姓名
     * @getEmail：获取邮箱
     * @getGender：获取性别
     *
     */

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

}