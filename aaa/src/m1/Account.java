package m1;

public class Account {
    private int id;
    private double balance;  // 余额
    private double annuallntersRate; // 年利率

    public Account(int id, double balance, double annuallntersRate) {
        this.annuallntersRate = annuallntersRate;
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnuallntersRate() {
        return annuallntersRate;
    }

    public void setAnnuallntersRate(double annuallntersRate) {
        this.annuallntersRate = annuallntersRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMonthlyinterest() {
        return this.annuallntersRate / 12;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("取款成功，您取了" + amount);
            System.out.println("您的余额 " + this.getBalance());
        } else {
            System.out.println("您的余额不足！");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("存款成功，您存了" + amount);
    }

}
