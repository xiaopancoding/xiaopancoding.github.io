package domain;

// 设计师类

import service.Status;

public class Designer extends Programmer{

    private double bonus;  // 表示奖金

    private Status status;

    public Designer() {

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

}
