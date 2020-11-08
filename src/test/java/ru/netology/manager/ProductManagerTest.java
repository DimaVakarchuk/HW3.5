package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final Repository repository = new Repository();
    private final ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Супер книга", 1, "Супер Автор");
    Product second = new Book(2, "Отличная книга", 2, "Отличный Автор");
    Product third = new Book(3, "Интересная книга", 3, "Интересный Автор");
    Product fourth = new Book(4, "Странная книга", 4, "Странный автор");
    Product fifth = new Book(5, "Старая книга", 5, "Старый автор");
    Product sixth = new Smartphone(6, "Iphone11", 6, "Apple");
    Product seventh = new Smartphone(7, "Mi9Lite", 7, "Xiaomi");
    Product eighth = new Smartphone(8, "Reno3", 8, "Oppo");
    Product ninth = new Smartphone(9, "8X", 9, "Honor");
    Product tenth = new Smartphone(10, "6Pro", 10, "Realme");

    @BeforeEach
    void setUp() {
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(fourth);
        manager.addProduct(fifth);
        manager.addProduct(sixth);
        manager.addProduct(seventh);
        manager.addProduct(eighth);
        manager.addProduct(ninth);
        manager.addProduct(tenth);
    }

    @Test
    void searchByAuthor() {
        Product[] actual = manager.searchBy("Отличный Автор");
        Product[] expected = {new Book(2, "Отличная книга", 2, "Отличный Автор")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookTitle() {
        Product[] actual = manager.searchBy("Интересная книга");
        Product[] expected = {new Book(3, "Интересная книга", 3, "Интересный Автор")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneBrand() {
        Product[] actual = manager.searchBy("Realme");
        Product[] expected = {new Smartphone(10, "6Pro", 10, "Realme")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneModel() {
        Product[] actual = manager.searchBy("6Pro");
        Product[] expected = {new Smartphone(10, "6Pro", 10, "Realme")};
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchByAnotherBrand() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}