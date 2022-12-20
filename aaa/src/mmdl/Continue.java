package mmdl;

import java.util.*;

public class Continue {
    Scanner cin = new Scanner(System.in);
    private char t;

    public Continue() {

    }
    public Continue(char t) {
        this.t = t;
    }

    public void continue_1() {
        while (true) {
            if ((int) t > 53 || (int) t < 49) {
                System.out.print("输入错误，请重新输入：");
                this.t = cin.next().charAt(0);
            }
            else {
                break;
            }
        }
    }

    public boolean continue_2() {
        char ch = cin.next().charAt(0);
        while (true) {
            if (ch != 'Y' && ch != 'N') {
                System.out.print("输入错误， 请重新输入：");
                ch = cin.next().charAt(0);
            }else break;
        }
        return ch == 'Y';
    }

}
