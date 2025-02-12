package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productId;  // numeric primary key that auto-increments
    private String productName;
    private int productQuantity;

}
