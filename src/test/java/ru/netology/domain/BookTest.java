package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    Book third = new Book(3, "Interesting book", 3, "Interesting Author");

    @Test
    void shouldCoincidenceOfName() {
        assertTrue(third.matches("Interesting book"));
    }

    @Test
    void shouldCoincidenceOfAuthor() {
        assertTrue(third.matches("Interesting Author"));
    }

    @Test
    void shouldNameDoestMatch() {
        assertFalse(third.matches("Scientific book"));
    }

    @Test
    void shouldAuthorDoestMatch() {
        assertFalse(third.matches("Scientific Author"));
    }

}
