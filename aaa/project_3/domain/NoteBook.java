package domain;

public class NoteBook implements Equipment{

    private String model;  // 机器型号
    private double price;

    public NoteBook() {

    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

}
