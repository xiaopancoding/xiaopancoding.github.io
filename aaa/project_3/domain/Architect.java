package domain;

// 架构师类

public class Architect extends Designer {

    private int stock; // 奖励的股票数量


    public Architect() {

    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }


}
