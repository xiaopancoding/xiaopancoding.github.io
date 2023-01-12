package cpm.p.pojo;

public class Clazz {

    private Integer cId;
    private String cName;

    public Clazz() {

    }

    public Clazz(Integer cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
