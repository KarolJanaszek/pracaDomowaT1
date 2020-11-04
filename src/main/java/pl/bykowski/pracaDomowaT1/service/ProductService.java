package pl.bykowski.pracaDomowaT1.service;

import org.springframework.stereotype.Service;
import pl.bykowski.pracaDomowaT1.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
        addRandomProduct();
    }

    private void addRandomProduct() {
        for (int i = 0; i <= 4; i++) {
            productList.add(new Product("Towar nr " + i));
            System.out.println(productList.get(i));
        }
    }

    public void addProductToBasket(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
