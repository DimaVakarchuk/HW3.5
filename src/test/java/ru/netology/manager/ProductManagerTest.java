package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final static Repository repository = new Repository();
    private final static ProductManager manager = new ProductManager(repository);

    static Product first = new Book(1, "Super book", 1, "Super Author");
    static Product second = new Book(2, "Great book", 2, "Great Author");
    static Product third = new Book(3, "Interesting book", 3, "Interesting Author");
    static Product fourth = new Book(4, "Strange book", 4, "Strange Author");
    static Product fifth = new Book(5, "Old book", 5, "Old Author");
    static Product sixth = new Smartphone(6, "Iphone11", 6, "Apple");
    static Product seventh = new Smartphone(7, "Mi9Lite", 7, "Xiaomi");
    static Product eighth = new Smartphone(8, "Reno3", 8, "Oppo");
    static Product ninth = new Smartphone(9, "8X", 9, "Honor");
    static Product tenth = new Smartphone(10, "6Pro", 10, "Realme");
    
    static {
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
        Product[] expected = {new Book(2, "Great book", 2, "Great Author")};
        Product[] actual = manager.searchBy("Great Author");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookTitle() {
        Product[] expected = {new Book(3, "Interesting book", 3, "Interesting Author")};
        Product[] actual = manager.searchBy("Interesting book");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneBrand() {
        Product[] expected = {new Smartphone(10, "6Pro", 10, "Realme")};
        Product[] actual = manager.searchBy("Realme");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneModel() {
        Product[] expected = {new Smartphone(10, "6Pro", 10, "Realme")};
        Product[] actual = manager.searchBy("6Pro");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAnotherBrand() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

}