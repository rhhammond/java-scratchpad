package com.rhhammond;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class CustomerTest extends TestCase {

    @Test
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

    @Test
    public void testEmptyBuilder(){
        Customer c = new Customer.CustomerBuilder().build();
        assertNull(c.getFirstName());
        assertNull(c.getLastName());
        assertNull(c.getTitle());
        assertThat(c.toString(), containsString("title=<null>"));
        assertThat(c.toString(), containsString("firstName=<null>"));
        assertThat(c.toString(), containsString("lastName=<null>"));
    }
}
