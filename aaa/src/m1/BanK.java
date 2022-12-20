package m1;



public class BanK {
    private String id;
    private String password;
    private int balence;
    private static double li;
    private static double small;
    public BanK() {
        li = 0.001;
        small = 1000.0;
    }


    public BanK(String id, String password, int balence) {
        this.balence = balence;
        this.id = id;
        this.password = password;
    }

//    public String getPassword() {
//        return password;
//    }

    public static double getSmall() {
        return small;
    }

    public void setBalence(int balence) {
        this.balence = balence;
    }

    public String getId() {
        return id;
    }

    public int getBalence() {
        return balence;
    }

    public static double getLi() {
        return li;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
