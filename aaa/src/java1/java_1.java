package java1;


import java.util.*;

public class java_1 {
    public static void main(String [] args) {
        Scanner cin = new Scanner(System.in);
        Student2[] std = new Student2[10];
        for (int i = 0; i < std.length; i ++) std[i] = new Student2();   // 这是关键， 也就是说这里是声明每一个数组元素是Student对象
        // 就相当于 c++中结构体类型了， 只不过在c++中不用一一声明这是什么类型的， 因为在java中都是对象
        for (int i = 1; i <= 3; i ++) {
            std[i].number = cin.nextInt();
            std[i].score = cin.nextInt();
            std[i].state = cin.nextInt();
        }
        for (int i = 1; i <= 3; i ++)
            System.out.println(std[i].number);


        // 这是文档注释


        /**
         * @miaoshu : nizhiadao
         * @发违法
         * @发发
         *
         */

//        int a = cin.nextInt();
//        Student s1 = new Student();
//        s1.name = "潘建民";
//        s1.age = 20;
//        s1.major = "学习";
////        Student p1 = s1;
////        p1.name = "潘";
//        System.out.printf("%s\n", s1.name);
//        System.out.printf("%d\n", s1.age);
//        System.out.printf("%s\n", s1.major);
    }
}
class Student2 {
    int number;
    int state;
    int score;
}

class Student1 {
    String name;  // 属性
    int age;    // 属性
    String major;   // 属性
    public String interests() {  // 这里称为方法  在其他语言里叫做函数
        return name;
    }
    public int get_age() {
        return age;
    }
    public String get_major() {
        return major;
    }
}

//public class java_1 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        float target = input.nextFloat();
//        input.nextLine();
//        String str1 = input.nextLine();
//        System.out.println(str1);
//        int[] arr = new int[5];
//        for (int i = 0; i < a; i++) {
//            arr[i] = input.nextInt();
//        }

//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//            if (arr[mid] > target)
//                right = mid - 1;
//            else if (arr[mid] < target)
//                left = mid + 1;
//            else {
//                System.out.println(mid);
//                break;
//            }
//        }
//        for (int i = 0; i < a-1; i++){
//            int min = i;
//            for (int j = i+1; j < a; j++){
//                if (arr[min] > arr[j])
//                    min = j;
//            }
//            int t = arr[i];
//            arr[i] = arr[min];
//            arr[min] = t;
//        }
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < a; i++){
//            int min = 0;
//            for (int j = 1; j < a; j++){
//                if (arr[min] > arr[j]){
//                    int temp = arr[min];
//                    arr[min] = arr[j];
//                    arr[j] = temp;
//                }
//                min = j;
//            }
//        }
//        for (int i = 1; i < a; i++){
//            int j = i - 1;
//            int temp = arr[i];
//            while (j >= 0 && temp < arr[j]){
//                arr[j+1] = arr[j];
//                j--;
//            }
//            arr[j+1] = temp;
//        }
//        System.out.println(Arrays.toString(arr));
//
//    }
//
//}

//import java.util.*;
//
//public class java_1 {
//    public static void main(String args) {
//
//    }
//}
