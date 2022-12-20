package domain;


// 程序员类

import service.Status;

public class Programmer extends Employee{

    private int memberld;  // 成员
    private Equipment equipment;  // 设备

    private Status status = Status.FREE;

    public Programmer() {

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMemberld() {
        return memberld;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }
}
