package pl.bykowski.pracaDomowaT1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.bykowski.pracaDomowaT1.model.Product;
import pl.bykowski.pracaDomowaT1.repository.ShopRepository;
import pl.bykowski.pracaDomowaT1.service.ProductService;

@Controller
@Profile("Pro")
public class ShopPro implements ShopRepository {

    @Value("${tax}")
    private double tax;
    @Value("${discount}")
    private double discount;
    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sumBasketPrice() {
        Double sum = productService.getProductList().stream().mapToDouble(Product::getPrice).sum();
        System.out.println(String.format("Cena produktów w koszyku wynosi netto: %1.2f PLN, " +
                "butto: %1.2f PLN", sum, addTax(sum)));
        System.out.println(String.format("Twój rabat to %1.0f procent. " +
                        "Wartość koszyka netto po rabacie to: %1.2f PLN. " +
                        "Wartość koszyka brutto po rabacie to: %1.2f PLN.",
                (1-discount)*100, addDiscount(sum), addDiscount(addTax(sum))));
    }

    private Double addTax(Double price) {
        return price * tax;
    }

    private Double addDiscount(Double price) {
        return price * discount;
    }
}
