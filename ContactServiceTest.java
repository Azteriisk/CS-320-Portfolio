import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddContactDuplicateId() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testAddContactNull() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testDeleteContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testDeleteContactNull() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }

    @Test
    void testUpdateContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Elm St");

        Contact updated = service.getContact("12345");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    void testUpdateContactPartial() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        // Update only first name, pass null for others
        service.updateContact("12345", "Jane", null, null, null);

        Contact updated = service.getContact("12345");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Doe", updated.getLastName()); // unchanged
        assertEquals("1234567890", updated.getPhone()); // unchanged
        assertEquals("123 Main St", updated.getAddress()); // unchanged
    }

    @Test
    void testUpdateContactNotFound() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("99999", "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    @Test
    void testUpdateContactNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact(null, "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    @Test
    void testUpdateContactInvalidField() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("12345", "TooLongFirstN", null, null, null));
    }
}
