package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone tenth = new Smartphone(10, "6Pro", 10, "Realme");

    @Test
    void shouldCoincidenceOfModel() {
        assertTrue(tenth.matches("6Pro"));
    }

    @Test
    void shouldCoincidenceOfBrand() {
        assertTrue(tenth.matches("Realme"));
    }

    @Test
    void shouldModelDoesntMatch() {
        assertFalse(tenth.matches("Reno3"));
    }

    @Test
    void shouldBrandDoestMatch() {
        assertFalse(tenth.matches("Oppo"));
    }

}
