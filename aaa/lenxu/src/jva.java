


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author zph
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class jva {
    // 学生信息容器
    public static ArrayList<Student> studentList = new ArrayList<>();
    // 用户信息容器
    public static ArrayList<User> userList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 标记变量 用来退出死循环
        boolean flag = true;
        Loop1:  while (flag){
            // 进入登录界面
            loginPanel();
            // 用户录入的数据
            int choose = s.nextInt();
            switch (choose){
                case 1:
                    int count = 3;
                    while (count > 0) {
                        boolean login = login();
                        if (login){
                            System.out.println("登录成功!");
                            break Loop1;
                        }else {
                            if (count == 1){
                                System.out.println("你的账户被锁定,请十五分钟后重试");
                            }else {
                                System.out.println("用户名或者密码不正确,请重新登录,你还有"+(count-1)+"次机会");
                            }
                            count--;
                        }
                    }
                    break ;
                case 2:
                    register();
                    break;
                case 3:
                    forgetPwd();
                    break;
                default:
                    System.out.println("没有这个选项!");
            }
        }

        // 主界面
        Loop:   while(flag){
            // 生成主面板
            masterPanel();
            // 录入用户输入数据
            int input = s.nextInt();
            // 检查用户录入数据
            check(input);
            switch (input){
                // 添加学生
                case 1:
                    boolean flag1 = addStudent(s);
                    if (!flag1){
                        System.out.println("添加学生的id重复,请重新输入!");
                        break;
                    }
                    System.out.println("添加学生信息成功!");
                    break;
                // 删除学生
                case 2:
                    while (true){
                        System.out.println("请输入你要删除学生的id:");
                        String id = s.next();
                        boolean boo = deleteStudent(id);
                        if (boo){
                            break;
                        }
                    }
                    break;
                // 修改学生
                case 3:
                    boolean b = updateStudent(s);
                    if (!b){
                        System.out.println("要修改的学生id不存在，请重新输入!");
                        break;
                    }
                    System.out.println("修改学生信息成功!");
                    break;
                // 查询学生
                case 4:
                    selectStudent();
                    break;
                // 退出系统
                case 5:
                    System.out.println("退出系统成功!欢迎下次光临");
//                    System.exit(0);
                    break Loop;
            }
        }
    }

    /**
     * 忘记密码
     */
    public static void forgetPwd(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入你的用户名:");
        String username = s.next();
        boolean flag = checkUser(username);
        if (!flag){
            System.out.println("该用户不存在,请你重试");
            return;
        }
        System.out.println("请输入你的身份证号:");
        String card = s.next();
        System.out.println("请输入你的手机号:");
        String phone = s.next();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getIdCard().equals(card) && user.getPhone().equals(phone)){
                System.out.println("请输入新密码:");
                String newPwd = s.next();
                userList.get(i).setPassword(newPwd);
                System.out.println("修改成功!");
                return;
            }
        }
        System.out.println("身份证号或者手机号不正确,无修改权限");
    }

    /**
     * 登录
     * @return
     */
    public static boolean login(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入你的用户名:");
        String username = s.next();
        System.out.println("请输入你的密码:");
        String password = s.next();
        String code = getCode();
        System.out.println("我偷偷告诉你,验证码是:"+code);
        while (true) {

            System.out.println("请输入验证码:");
            String inputCode = s.next();
            if (!code.equals(inputCode)){
                System.out.println("验证码不正确请重新输入");
            }else {
                break;
            }
        }

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
//            遍历动态数组里每一个用户  然后找到这个用户名对应的密码
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * 用户注册
     */
    public static void register(){
        User user = new User();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("请输入注册的用户名:");
            String username = s.next();
            String flag = checkUserName(username);
//            如果是false的话  就是说明没有重复的用户名， 反之有重复的
            if (!flag.equals("true")){
                System.out.println(flag);
            }else {
                user.setUsername(username);
                break;
            }
        }

        while (true){
            System.out.println("请输入注册的密码:");
            String password = s.next();
            System.out.println("请重复你的密码:");
            String repeat = s.next();
            if (!password.equals(repeat)){
                System.out.println("两次输入的密码不一致,请重新输入!");
            }else {
                user.setPassword(password);
                break;
            }
        }
        while (true) {
            System.out.println("请输入你的身份证号:");
            String idCard = s.next();
            boolean flag1 = checkCardPattern(idCard);
            if (!flag1){
                System.out.println("输入数据错误,请重新输入");
            }else {
                user.setIdCard(idCard);
                break;
            }
        }
        while (true){
            System.out.println("请输入你的手机号:");
            String phone = s.next();
            boolean flag2 = checkPhonePattern(phone);
            if (!flag2){
                System.out.println("输入数据有误,请重新输入");
            }else {
                user.setPhone(phone);
                break;
            }
        }
        userList.add(user);
        System.out.println("用户注册成功");
    }

    /**
     * 判断用户名是否存在
     * @param name
     */
    public static boolean checkUser(String name){
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }


    /**
     * 判断手机号是否存在
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }

    /**
     * 检查身份证是否存在
     * @param phone
     * @return
     */
    public static boolean checkCard(String card){
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getIdCard().equals(card)){
                return true;
            }
        }
        return false;
    }

    /**
     * 生成随机验证码
     * @return
     */
    public static String getCode(){
        // 创建一个可以存放A-Z和a-z的数组
        char[] chars = new char[52];

        // 将A-Z放到数组中
        int index = 0;
        for (char i = 65; i < 91; i++) {
            chars[index] = i;
            index++;
        }
        // 将a-z放到数组中
        int index1 = 26;
        for (char i = 97;i<123;i++){
            chars[index1] = i;
            index1++;
        }
        // 从chars数组中随机抽4个字母放到数组chars1中
        char[] chars1 = new char[4];
        Random r = new Random();
        for (int i = 0; i < chars1.length; i++) {
            int randomIndex = r.nextInt(chars.length);
            // 从chars中随机选字符放到chars1中
            chars1[i] = chars[randomIndex];
        }
        // 在随机生成0-9的一位数
        int i = r.nextInt(10);
        // 将chars1转换为字符串
        String s = new String(chars1);
        // 将随机生成的数字与字符串拼接
        String s1 = s+i;

        // 将拼接好的字符串变为字符数组
        char[] chars2 = s1.toCharArray();
        // 将字符数组打乱
        for (int j = 0; j < chars2.length; j++) {
            int randomIndex = r.nextInt(chars2.length);
            char c = chars2[j];
            chars2[j] = chars2[randomIndex];
            chars2[randomIndex] = c;
        }
        // 打乱重新变成字符串
        return new String(chars2);
    }

    /**
     * 检查手机号格式
     * @param phone
     * @return
     */
    public static boolean checkPhonePattern(String phone){
        if (checkPhone(phone)){
            System.out.print("手机号已存在,");
            return false;
        }
        if (phone.length() != 11){
            return false;
        }
        if (phone.charAt(0) == '0') {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (!(c >= '0' && c<= '9')){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查身份证格式
     * @param card
     * @return
     */
    public static boolean checkCardPattern(String card){
        if (checkCard(card)){
            System.out.print("身份证号已存在,");
            return false;
        }
        if (card.length() != 18){
            return false;
        }
        if (card.charAt(0) == '0'){
            return false;
        }
        // 遍历前面17为数字
        for (int i = 0; i < card.length()-1; i++) {
            char c = card.charAt(i);
            if (!(c >= '0' && c <= '9')){
                return false;
            }
        }
        // 最后一位只能为数字或者X或者x
        char c = card.charAt(17);
        if(!(c >= '0' && c <= '9' || c == 'x' || c == 'X')){
            return false;
        }
        return true;
    }

    /**
     * 检查用户输入的用户名格式进行校验
     * @param name
     * @return
     */
    public static String checkUserName(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(name)) {
                return "用户名已存在";
            }
        }
        if (name.length() < 3 || name.length() > 15) {
            return "用户名长度必须在3-15个字符之间";
        }
        if (!checkPattern(name)) {
            return "用户名只能由字母和数字组成,且不能全是数字";
        }
        return "true";
    }


    /**
     * 检查用户名格式
     * @param name
     * @return
     */
    public static boolean checkPattern(String name){
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            // 得到名字的每一个字符
            char c = name.charAt(i);
            if(!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')){
                return false;
            }
            if (c >= '0' && c <= '9'){
                count++;
            }
            if(count == name.length()){
                return false;
            }
        }
        return true;
    }

    /**
     * 生成登录界面
     */
    public static void loginPanel(){
        System.out.println("欢迎来到学生管理系统");
        System.out.println("1: 登录");
        System.out.println("2: 注册");
        System.out.println("3: 忘记密码");
        System.out.println("请选择你要进行的操作(1-3):");
    }

    /**
     * 生成主面板
     */
    public static void masterPanel(){
        System.out.println("\"----------欢迎来到学生管理系统----------\"");
        System.out.println("\"1: 添加学生\"");
        System.out.println("\"2: 删除学生\"");
        System.out.println("\"3: 修改学生\"");
        System.out.println("\"4: 查询学生\"");
        System.out.println("\"5: 退出系统\"");
        System.out.println("\"请输入你的选择:(1-5)\"");
    }

    /**
     * 对用户录入数据进行简单校验
     * @param input
     */
    public static void check(int input){
        if (!(input >=1 && input <= 5)){
            System.out.println("你输入的数据有误,请重新输入!");
        }
    }

    /**
     * 检查id是否重复
     * @param list
     * @param id
     * @return
     */
    public static boolean checkId(ArrayList<Student> list,String id){
        for (Student student : list) {
            if (student.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    /**
     * 根据学生id找到在集合中的索引
     * @param id
     * @return
     */
    public static int findIndex(String id){
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加学生
     * @param s
     * @return
     */
    public static boolean addStudent(Scanner s){
        Student student = new Student();
        System.out.println("请输入学生ID:");
        String id = s.next();
        boolean flag = checkId(studentList, id);
        if (!flag){
            return false;
        }
        student.setId(id);
        System.out.println("请输入学生姓名:");
        String name = s.next();
        student.setName(name);
        System.out.println("请输入学生年龄:");
        int age = s.nextInt();
        student.setAge(age);
        System.out.println("请输入学生的家庭地址:");
        String address = s.next();
        student.setAddress(address);


        studentList.add(student);



        return true;
    }

    /**
     * 查询所有学生信息
     */
    public static void selectStudent(){
        if (studentList.size() == 0){
            System.out.println("当前无学生信息~~~");
        }
        System.out.println("-------------------学生信息表-------------------");
        System.out.println("id\t\t\t\t姓名\t\t\t年龄\t\t\t家庭住址");
        for (Student student : studentList) {
            System.out.println(student.getId()+"\t\t"
                    +student.getName()+"\t\t\t"
                    +student.getAge()+"\t\t\t"
                    +student.getAddress()
            );
        }
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    public static boolean deleteStudent(String id){
        int index = findIndex(id);
        if (index < 0){
            System.out.println("id不存在，请重新输入要删除学生的id");
            return false;
        }else {

            studentList.remove(index);



            System.out.println("删除学生成功!");
            return true;
        }
    }

    /**
     * 修改学生信息
     * @param s
     * @return
     */
    public static boolean updateStudent(Scanner s){
        Student student = new Student();
        System.out.println("请输入你要修改的学生ID:");
        String id = s.next();
        int index = findIndex(id);
        boolean flag = checkId(studentList, id);
        if (flag){
            return false;
        }
        student.setId(id);
        System.out.println("请输入学生姓名:");
        String name = s.next();
        student.setName(name);
        System.out.println("请输入学生年龄:");
        int age = s.nextInt();
        student.setAge(age);
        System.out.println("请输入学生的家庭地址:");
        String address = s.next();
        student.setAddress(address);
        studentList.set(index,student);
        return true;
    }
}

/**
 * 学生类
 */
@SuppressWarnings("all")
class Student{
    private String id;
    private String name;
    private int age;
    private String address;


    public Student() {
    }

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}

/**
 * 用户类
 */
@SuppressWarnings("all")
class User{
    private String username;
    private String password;
    private String idCard;
    private String phone;


    public User() {
    }

    public User(String username, String password, String idCard, String phone) {
        this.username = username;
        this.password = password;
        this.idCard = idCard;
        this.phone = phone;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", idCard = " + idCard + ", phone = " + phone + "}";
    }
}