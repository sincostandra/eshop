package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Test Product");
        product.setProductQuantity(100);

        // Stub repository.create agar mengembalikan produk yang sama
        when(productRepository.create(product)).thenReturn(product);

        Product created = productService.create(product);
        verify(productRepository, times(1)).create(product);
        assertEquals(product, created);
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);

        List<Product> productList = Arrays.asList(product1, product2);
        // Mengembalikan iterator dari list
        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();
        verify(productRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertTrue(result.contains(product1));
        assertTrue(result.contains(product2));
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Test Product");
        product.setProductQuantity(100);

        when(productRepository.findById("1")).thenReturn(product);

        Product found = productService.findById("1");
        verify(productRepository, times(1)).findById("1");
        assertEquals(product, found);
    }

    @Test
    void testUpdate() {
        Product original = new Product();
        original.setProductId("1");
        original.setProductName("Old Name");
        original.setProductQuantity(10);

        Product updated = new Product();
        updated.setProductId("1");
        updated.setProductName("New Name");
        updated.setProductQuantity(20);

        when(productRepository.update(updated)).thenReturn(updated);

        Product result = productService.update(updated);
        verify(productRepository, times(1)).update(updated);
        assertEquals(updated, result);
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Test Product");
        product.setProductQuantity(100);

        when(productRepository.delete(product)).thenReturn(product);

        Product deleted = productService.delete(product);
        verify(productRepository, times(1)).delete(product);
        assertEquals(product, deleted);
    }
}
