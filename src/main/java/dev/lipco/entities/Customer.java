package dev.lipco.entities;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerPin;
    private long customerSignupDate;
    private boolean customerActiveAccounts;

    public Customer(){

    }

    public Customer(int customerId, String customerName, String customerPin, long customerSignupDate, boolean customerActiveAccounts) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPin = customerPin;
        this.customerSignupDate = customerSignupDate;
        this.customerActiveAccounts = customerActiveAccounts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(String customerPin) {
        this.customerPin = customerPin;
    }

    public long getCustomerSignupDate() {
        return customerSignupDate;
    }

    public void setCustomerSignupDate(long customerSignupDate) {
        this.customerSignupDate = customerSignupDate;
    }

    public boolean isCustomerActiveAccounts() {
        return customerActiveAccounts;
    }

    public void setCustomerActiveAccounts(boolean customerActiveAccounts) {
        this.customerActiveAccounts = customerActiveAccounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " customerId: " + customerId +
                ", customerName: " + customerName +
                ", customerPin: " + customerPin +
                ", customerSignupDate: "  + customerSignupDate +
                ", customerActiveAccounts: " + customerActiveAccounts +
                '}';
    }
}
