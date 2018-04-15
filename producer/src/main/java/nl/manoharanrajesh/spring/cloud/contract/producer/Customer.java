package nl.manoharanrajesh.spring.cloud.contract.producer;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.math.BigDecimal;

public class Customer {

    private final String id;
    private final String fullName;
    private final BigDecimal balance;


    @JsonCreator
    public Customer(final String id,final String fullName, final BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    /**
     * Getter for property 'fullName'.
     *
     * @return Value for property 'fullName'.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Getter for property 'balance'.
     *
     * @return Value for property 'balance'.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                '}';
    }
}