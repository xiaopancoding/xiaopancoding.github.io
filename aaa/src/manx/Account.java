package manx;

public class Account {

    private double balance;
    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void  deposit(double amt) {
        this.balance += amt;
        System.out.println("您存了" + amt);
    }

    public void withdraw(double amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            System.out.println("您提取了" + amt);
        }else {
            System.out.println("余额不足");
        }
    }

}
