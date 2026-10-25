// A PhysicalProduct IS-A Product because it is a specific, tangible type of Product that inherits all core traits of the base Product class.
// A class that would NOT pass this test is ShoppingCart.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{

    private double weightKg;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public PhysicalProduct() {}

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
