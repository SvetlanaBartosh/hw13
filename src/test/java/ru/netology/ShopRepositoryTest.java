package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void RemoveOneProduct () {
        ShopRepository repository = new ShopRepository();
        Product item1 = new Product(1, "хлеб", 40);
        Product item2 = new Product(2, "булка", 30);
        Product item3 = new Product(3, "картошка", 20);

        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = {item1, item2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveNonexistentProduct () {
        ShopRepository repository = new ShopRepository();
        Product item1 = new Product(1, "хлеб", 40);
        Product item2 = new Product(2, "булка", 30);
        Product item3 = new Product(3, "картошка", 20);

        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }
}
