package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public ProductService() {
        products.add(new DigitalProduct(nextId++, "Fire and Blood", 18.88, "/hod/fireandblood", 45.32));

        products.add(new PhysicalProduct(nextId++, "Cupboard", 26.66, 8.5, "5x8x3"));
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> getProductByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public String deleteProduct(Long id) {
        Boolean isDeleted = products.removeIf(p -> p.getId().equals(id));
        if (isDeleted) {
            return "Product deleted successfully.";
        } else {
            return "Product not found";
        }
    }
}
