package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import be.pxl.ja.streamingservice.exception.InvalidDateException;
import java.time.LocalDate;

public class ProfileSetDateOfBirthTest {
    private Profile profile;

    @BeforeEach
    public void init() {
        profile = new Profile("new_profile");
    }

    @Test
    public void shouldReturnCorrectDate() {
        LocalDate dateOfBirth = LocalDate.now();

        profile.setDateOfBirth(dateOfBirth);

        assertEquals(dateOfBirth, profile.getDateOfBirth());
    }

    @Test
    public void shouldThrowInvalidDateException() {
        LocalDate dateOfBirth = LocalDate.now().plusDays(1);

        assertThrows(InvalidDateException.class, () -> {
            profile.setDateOfBirth(dateOfBirth);
        });
    }
}
