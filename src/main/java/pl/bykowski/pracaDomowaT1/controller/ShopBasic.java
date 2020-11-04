package pl.bykowski.pracaDomowaT1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.bykowski.pracaDomowaT1.model.Product;
import pl.bykowski.pracaDomowaT1.repository.ShopRepository;
import pl.bykowski.pracaDomowaT1.service.ProductService;

@Controller
@Profile("Start")
public class ShopBasic implements ShopRepository {

    private ProductService productService;

    @Autowired
    public ShopBasic(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sumBasketPrice() {
        Double sum = productService.getProductList().stream().mapToDouble(Product::getPrice).sum();
        System.out.println(String.format("Cena netto produktów w koszyku wynosi: %1.2f PLN", sum));
    }
}
