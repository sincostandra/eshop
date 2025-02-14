package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerDeleteTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setup() {}

    @Test
    void testDeleteProduct_positive() {
        String productId = "1";
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("Test Product");
        product.setProductQuantity(10);
        when(service.findById(productId)).thenReturn(product);

        String viewName = controller.deleteProduct(productId);

        verify(service).findById(productId);
        verify(service).delete(product);
        assertEquals("redirect:/product/list", viewName);
    }

    @Test
    void testDeleteProduct_negative() {

        String productId = "produktidakeksis";
        when(service.findById(productId)).thenReturn(null);

        String viewName = controller.deleteProduct(productId);

        verify(service).findById(productId);
        verify(service).delete(null);
        assertEquals("redirect:/product/list", viewName);
    }
}
