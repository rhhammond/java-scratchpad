package com.rhhammond;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class CustomerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CustomerTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CustomerTest.class );
    }

    public void testBuilder()
    {
        Customer c = new Customer.CustomerBuilder()
                .title("Mr.")
                .firstName("Robert")
                .lastName("Hammond")
                .build();

        assertEquals("Mr.", c.getTitle());
        assertEquals("Robert", c.getFirstName());
        assertEquals("Hammond", c.getLastName());

        assertThat(c.toString(), containsString("title=Mr."));
        assertThat(c.toString(), containsString("firstName=Robert"));
        assertThat(c.toString(), containsString("lastName=Hammond"));
    }
}
