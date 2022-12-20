package manx;

public class Back {

    private Customer[] customers;
    private int numberOfCustomer; // 记录客户的个数

    public Back() {
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        Customer cust = new Customer(f, l);
        customers[++ numberOfCustomer] = cust;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
    // 获取指定位置上的客户
    public Customer getCustomers(int index) {
//        return customers[index];
        if (index <= numberOfCustomer && index >= 1)
            return customers[index];
        else return null;
    }

}
