import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RectangleTest {
    @Test                                                              // Hinweis an JUnit: diese Methode ist ein Test
    void shouldComputePerimeter() {                                    // Methode (kein static!) ist immer void und package-private
        int perimeter = Rectangle.computePerimeter(5, 4);              // Methodenaufruf mit width = 5 und height = 4
        Assertions.assertEquals(18, perimeter, "Perimeter is not 18"); // prüft, ob erwarteter Wert in Variable perimeter steht
    }

    @Test
    void shouldComputePerimeterForNegativeParams() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Rectangle.computePerimeter(-1, -1);
        }, "Negative perimeter should result in ArithmeticException");
    }

    @Test
    void shouldComputePerimeterWithAWidthOfZero() {
        int perimeter = Rectangle.computePerimeter(0, 4);
        Assertions.assertEquals(0, perimeter, "Width can not be 0");
    }
}