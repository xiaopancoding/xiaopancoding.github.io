package service;

// 封装了员工的状态

public class Status {

    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }


    public static final Status FREE = new Status("FREE");  // 空闲free
    public static final Status VOCATION = new Status("VOCATION");  // 正在休假vocation
    public static final Status BUSY = new Status("BUSY");  // 已经加入团队busy

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }

}
