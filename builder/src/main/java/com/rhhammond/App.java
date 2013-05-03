package com.rhhammond;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String EXIT = "Q";
    private static final String PRINT = "P";
    private static final String NEW = "N";

    public static Console c = System.console();

    public static void main( String[] args )
    {

        String choice = null;
        List<Customer> customers = new ArrayList<Customer>();

        loop: while(true) {

            choice = c.readLine("(N)ew Customer, (P)rint Customers, or (Q)uit? ");

            if(EXIT.equalsIgnoreCase(choice)){
                break loop;
            } else if(NEW.equalsIgnoreCase(choice)){
                customers.add(newCustomer());
            } else if(PRINT.equalsIgnoreCase(choice)){
                for(Customer customer : customers) System.out.println(customer);
            }
        }
    }

    private static Customer newCustomer() {
        return new Customer.CustomerBuilder()
                .title(c.readLine("Title: "))
                .firstName(c.readLine("First Name: "))
                .lastName(c.readLine("Last Name: "))
                .build();

    }
}
