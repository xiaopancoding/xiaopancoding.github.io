package mmdl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer hn = new Customer();
        hn = null;
        Operate people = new Operate(hn);
        Scanner cin = new Scanner(System.in);
        while (true) {

            System.out.println("----------客户信息管理软件----------");
            System.out.println("            1. 添加客户            ");
            System.out.println("            2. 修改客户            ");
            System.out.println("            3. 删除客户            ");
            System.out.println("            4. 客户列表            ");
            System.out.println("            5. 退   出             ");
            System.out.println("----------------------------------");
            System.out.print("请输入您想要服务序号：");
            char t = cin.next().charAt(0);
            Continue t1 = new Continue(t);
            t1.continue_1();
            switch (t) {
                case '1' -> people.addCustomer();
                case '2' -> people.modifyCustomer(people);
                case '3' -> people.deleteCustomer(people);
                case '4' -> people.searchCustomer(people);
                case '5' -> System.exit(0);
            }
//            System.out.print("请问还需要其他服务吗(Y/N)！！！");
//            if (!t1.continue_2()) break;
        }
    }
}
