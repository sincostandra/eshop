package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;
    private int idCnt = 0;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        product.setProductId(String.valueOf(idCnt++));
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/edit/{productId}") // Added productId path variable
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "EditProduct"; // Assuming you have a separate view for editing
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        service.update(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        Product product = service.findById(productId);
        service.delete(product);
        return "redirect:/product/list";
    }
}
