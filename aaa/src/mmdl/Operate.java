package mmdl;

import java.util.*;

public class Operate {

    Scanner cin = new Scanner(System.in);

    Customer head;
    Customer tail;
    private boolean flag = true;

    public Operate(Customer head) {
        this.head = head;
        this.tail = head;
    }

    public void addCustomer() {
        while (true) {
            Customer cust = new Customer();
            System.out.print("请输入您的编号：");
            cust.setId(cin.nextInt());
            System.out.print("请输入您的姓名：");
            cin.nextLine();
            cust.setName(cin.nextLine());
            System.out.print("请输入您的性别：");
            cust.setGender(cin.nextLine());
            System.out.print("请输入您的年龄：");
            cust.setAge(cin.nextInt());
            System.out.print("请输入您的电话号码：");
            cin.nextLine();
            cust.setPhone(cin.nextLine());
            System.out.print("请输入您的邮箱：");
            cust.setEmail(cin.nextLine());
            if (this.flag) {
                this.tail = cust;
            }else {
                this.tail.next = cust;
                this.tail = cust;
            }
            if (this.flag) {
                this.head = this.tail;
                this.flag = false;
            }

            System.out.print("请问您还需要再添加吗(Y/N): ");
            if (!new Continue().continue_2()) {
                break;
            }
        }
    }

    public void deleteCustomer(Operate operate) {
        Customer h1 = operate.head;
        Customer h2 = operate.head;
        if (h1 == null) {
            System.out.println("目前还没有添加客户！！！");
            System.out.println("请按任意键返回！");
            cin.nextLine();
        }
        else {
            System.out.print("请输入您的电话号码：");
            String str = cin.nextLine();
            if (h1.getPhone().equals(str)) {
                h1 = h1.next;
                operate.head = h1;
                if (h1 == null) {
                    head = null;
                    this.flag = true;
                }
            } else {
                if (h1.next == null) {
                    System.out.println("没有找到客户您！！！");
                    System.out.println("请按任意键返回！");
                    cin.nextLine();
                }
                else {
                    boolean res = false;
                    while (h1.next != null) {
                        if (h1.next.getPhone().equals(str)) {
                            h1.next = h1.next.next;
                            res = true;
                            break;
                        }
                        h1 = h1.next;
                    }
                    if (!res) {
                        System.out.println("没有找到客户您！！！");
                        System.out.println("请按任意键返回！");
                        cin.nextLine();
                    }
                }
            }
        }
    }

    public void modifyCustomer(Operate operate) {
        Customer h = operate.head;
        if (h == null) {
            System.out.println("目前还没有添加客户！！！");
            System.out.println("请按任意键返回！");
            cin.nextLine();
        }
        else {
            System.out.print("请输入您的电话号码：");
            String str = cin.nextLine();
            boolean res = false;
            while (h != null) {
                if (h.getPhone().equals(str)) {
                    System.out.println("请输入您想要修改什么！！");
                    System.out.print("姓名\t\t性别\t\t年龄\t\t电话号码\t\t邮箱:  ");
                    String str1 = cin.nextLine();
                    if (str1.equals("姓名")) {
                        System.out.print("请输入正确的姓名：");
                        h.setName(cin.nextLine());
                    }
                    else if (str1.equals("性别")) {
                        System.out.print("请输入正确的性别：");
                        h.setGender(cin.nextLine());
                    }
                    else if (str1.equals("年龄")) {
                        System.out.print("请输入正确的年龄：");
                        h.setAge(cin.nextInt());
                        cin.nextLine();
                    }
                    else if (str1.equals("电话号码")) {
                        System.out.print("请输入正确的电话号码：");
                        h.setPhone(cin.nextLine());
                    }
                    else if (str1.equals("邮箱")) {
                        System.out.print("请输入正确的邮箱：");
                        h.setEmail(cin.nextLine());
                    }
                    else {
                        System.out.println("输入错误！！！");
                        System.out.println("请按任意键返回！");
                        cin.nextLine();
                        return;
                    }
                    res = true;
                }
                h = h.next;
            }
            if (!res) {
                System.out.println("没有找到客户您！！！");
                System.out.println("请按任意键返回！");
                cin.nextLine();
            }
        }
    }

    public void searchCustomer(Operate operate) {
        Customer h = operate.head;
        if (h == null) {
            System.out.println("目前还没有添加客户！！！");
            System.out.println("请按任意键返回！");
            cin.nextLine();
        }
        else {
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话号码\t\t邮箱");
            while (h != null) {
                System.out.println(h.getId() + "\t\t" + h.getName() + "\t\t" + h.getGender() + "\t\t" + h.getAge() + "\t\t" + h.getPhone() + "\t\t" + h.getEmail() + "\t\t");
                h = h.next;
            }
            System.out.println("请按任意键返回！");
            cin.nextLine();
        }
    }
}


