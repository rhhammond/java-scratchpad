package com.rhhammond;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author: rhammond
 * Created: 5/3/13
 */
public class Customer {

    public static class CustomerBuilder {
        private String title;
        private String firstName;
        private String lastName;

        public CustomerBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CustomerBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private final String title;
    private final String firstName;
    private final String lastName;

    private Customer(CustomerBuilder builder) {
        this.title = builder.title;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getTitle(){
        return title;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("title", title)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }

}
