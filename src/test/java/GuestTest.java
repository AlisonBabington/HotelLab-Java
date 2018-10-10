import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before() {
        guest = new Guest("Sharon", 500);
    }

    @Test
    public void getName() {
        assertEquals("Sharon", guest.getName());
    }

    @Test
    public void getMoney() {
        assertEquals(500, guest.getMoney());
    }
}
