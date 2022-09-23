package java1;
import java.util.*;


public class java_1 {
    public static void main(String[] args) {

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
