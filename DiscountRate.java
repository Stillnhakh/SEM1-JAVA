public interface DiscountRate {

    double getServiceMemberDiscount();

    double getProductMemberDiscount();
}

public enum CustomerType {
    PREMIUM, GOLD, SILVER, NORMAL
}

public class Customer implements DiscountRate {

    private String customerName;
    private CustomerType customerType;

    public Customer(String customerName, CustomerType customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getServiceMemberDiscount() {
        switch (customerType) {
            case PREMIUM:
                return 0.2;
            case GOLD:
                return 0.15;
            case SILVER:
                return 0.1;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductMemberDiscount() {
        switch (customerType) {
            case PREMIUM:
                return 0.1;
            case GOLD:
                return 0.1;
            case SILVER:
                return 0.1;
            default:
                return 0.0;
        }
    }
}

public class Sale {

    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
        calculateTotalExpense();
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
        calculateTotalExpense();
    }

    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }

    private void calculateTotalExpense() {
        // Consider adding logic to handle discounts here,
        // either by incorporating the DiscountRate interface
        // or implementing your own discount calculation logic.
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Total Expense: $" + getTotalExpense());
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer("Sovisal", CustomerType.NORMAL);
        Customer c2 = new Customer("Sokchea", CustomerType.PREMIUM);
        Customer c3 = new Customer("Sokpov", CustomerType.GOLD);
        Customer c4 = new Customer("Vitou", CustomerType.SILVER);

        Sale sale_c1 = new Sale(c1, "2024-02-11");
        Sale sale_c2 = new Sale(c2, "2024-02-12");
        Sale sale_c3 = new Sale(c3, "2024-02-13");
        Sale sale_c4 = new Sale(c4, "2024-02-14");

        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(50); // Setting service expense for sale_c1

        // Similarly, set expenses for other sales
        sale_c2.setProductExpense(150);
        sale_c2.setServiceExpense(75);
        sale_c3.setProductExpense(200);
        sale_c3.setServiceExpense(100);
        sale_c4.setProductExpense(250);
        sale_c4.setServiceExpense(125);

        // Display sale information
        sale_c1.displayInfo();
        sale_c2.displayInfo();
        sale_c3.displayInfo();
        sale_c4.displayInfo();
    }
}


