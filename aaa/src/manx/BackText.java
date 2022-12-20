package manx;

public class BackText {
    public static void main(String[] args) {
        Back back = new Back();
        back.addCustomer("Ton", "join");
        System.out.println(back.getNumberOfCustomer());
        back.getCustomers(1).setAccount(new Account(2000));
        System.out.println(back.getCustomers(1).getAccount().getBalance());
        back.getCustomers(1).getAccount().withdraw(500);
        System.out.println(back.getCustomers(1).getAccount().getBalance());
    }

    public static class Cls {
        public static void clean() {
            try {
                String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.println("\033c");
                }
            } catch (Exception exception) {
                //  Handle exception.
            }
        }
    }
}
