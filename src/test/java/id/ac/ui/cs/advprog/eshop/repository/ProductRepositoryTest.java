package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo le");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllMoreThanOneProduct() {
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo le");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        product2.setProductId("a0f9de46-90b1-a0bf-d0821dde9096");
        product2.setProductName("Sampo cik");
        product2.setProductQuantity(100);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());

    }

    @Test
    void testDelete() {
        Product product1 = new Product();
        product1.setProductId("f5dfd5a2-6c5e-468d-873c-03524846f9d9");
        product1.setProductName("Sampo aseli");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        productRepository.delete(product1);

        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit() {
        Product product1 = new Product();
        product1.setProductId("9b0224b9-b382-43aa-829a-f92c998a9ace");
        product1.setProductName("Sampo palsoe");
        product1.setProductQuantity(5);

        productRepository.create(product1);

        product1.setProductName("Sampo asli");
        product1.setProductQuantity(10);

        productRepository.update(product1);

        Product updatedProduct = productRepository.findById(product1.getProductId());
        assertEquals(product1.getProductId(), updatedProduct.getProductId());
        assertEquals("Sampo asli", updatedProduct.getProductName());
        assertEquals(10, updatedProduct.getProductQuantity());
    }
}