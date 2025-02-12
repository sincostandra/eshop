package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Return null if product with given ID is not found
    }

    public Product update(Product updateProduct) {
        for (Product product : productData) {
            if (product.getProductId().equals(updateProduct.getProductId())) {
                // update
                product.setProductName(updateProduct.getProductName());
                product.setProductQuantity(updateProduct.getProductQuantity());
                return product;
            }
        }
        return null; // Return null if product with given ID is not found
    }

    public Product delete(Product productToDelete) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(productToDelete.getProductId())) {
                iterator.remove();
                return product; // Return the deleted product
            }
        }
        return null; // Return null if product with given ID is not found
    }
}
