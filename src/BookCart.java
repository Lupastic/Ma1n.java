import java.util.HashMap;
import java.util.Map;
public class BookCart {
    private Map<String, Integer> cart;
    public BookCart() {
        cart = new HashMap<>();
    }
    public void addToCart(String bookTitle) {
        cart.put(bookTitle, cart.getOrDefault(bookTitle, 0) + 1);
    }
    public void removeFromCart(String bookTitle) {
        if (cart.containsKey(bookTitle)) {
            int quantity = cart.get(bookTitle);
            if (quantity > 1) {
                cart.put(bookTitle, quantity - 1);
            } else {
                cart.remove(bookTitle);
            }
        }
    }
    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart:");
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " p.");
            }
        }
    }

    public static void main(String[] args) {
        BookCart cart = new BookCart();
        cart.addToCart("Book 1");
        cart.addToCart("Book 2");
        cart.addToCart("Book 1");
        cart.addToCart("Book 3");

        cart.displayCart();

        cart.removeFromCart("Book 1");
        cart.removeFromCart("Book 2");

        cart.displayCart();
    }
}
