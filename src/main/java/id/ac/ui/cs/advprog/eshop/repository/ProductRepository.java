package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    public Product create(Product product) {
        productData.add(product);
        productMap.put(product.getProductId(), product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        return productMap.get(productId); // Return null if product with given ID is not found
    }

    public Product update(Product updateProduct) {
        Product product = productMap.get(updateProduct.getProductId());
        if (product != null) {
            product.setProductName(updateProduct.getProductName());
            product.setProductQuantity(updateProduct.getProductQuantity());
            return product;
        }
        return null;  // Return null if product with given ID is not found
    }

    public Product delete(Product productToDelete) {
        Product product = productMap.get(productToDelete.getProductId());
        if (product != null) {
            productData.remove(product);
            productMap.remove(product.getProductId());
            return product;
        }
        return null;// Return null if product with given ID is not found
    }
}