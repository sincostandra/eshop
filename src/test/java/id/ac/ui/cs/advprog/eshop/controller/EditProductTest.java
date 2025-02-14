package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EditProductTest {

    @Mock
    ProductService service;

    @Mock
    Model model;

    @InjectMocks
    ProductController controller;

    @BeforeEach
    void setup() {}

    // Tests for GET /edit
    @Test
    void testEditProductPage_positive() {
        String productId = "555";
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("le product");
        product.setProductQuantity(10);
        when(service.findById(productId)).thenReturn(product);

        String viewName = controller.editProductPage(productId, model);

        // Assert
        verify(service).findById(productId);
        verify(model).addAttribute("product", product);
        assertEquals("editProduct", viewName);
    }

    @Test
    void testEditProductPage_negative() {
        String productId = "nyariapale";
        when(service.findById(productId)).thenReturn(null);
        String viewName = controller.editProductPage(productId, model);
        verify(service).findById(productId);
        verify(model).addAttribute("product", null);
        assertEquals("editProduct", viewName);
    }

    // Tests for POST /edit
    @Test
    void testEditProductPost_positive() {

        Product product = new Product();
        product.setProductId("idbarule");
        product.setProductName("dahdiupdatele");
        product.setProductQuantity(20);

        String viewName = controller.editProductPost(product, model);

        verify(service).update(product);
        assertEquals("redirect:list", viewName);
    }

    @Test
    void testEditProductPost_negative() {

        Product product = null;
        doThrow(new NullPointerException("Product is null")).when(service).update(product);

        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                controller.editProductPost(product, model)
        );
        assertEquals("Product is null", exception.getMessage());
    }
}
