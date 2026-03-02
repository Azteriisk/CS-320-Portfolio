import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreationSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdBoundary() {
        // Exactly 10 characters should succeed
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "JohnJohnJoh", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "DoeDoeDoeDo", "1234567890", "123 Main St"));
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "123456789", "123 Main St"));
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    // Setter tests
    @Test
    void testSetFirstNameSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJoh"));
    }

    @Test
    void testSetLastNameSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeDo"));
    }

    @Test
    void testSetPhoneSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testSetPhoneNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void testSetPhoneInvalidLength() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    @Test
    void testSetAddressSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testSetAddressNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }
}
