import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Personal {
    Scanner scanner = new Scanner(System.in);
    public  void addBooksForSale() throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        while (true) {
            System.out.println("Enter your name: ");
            String username = scanner.nextLine();
            System.out.println("Enter the title of the book: ");
            String bookTitle = scanner.nextLine();
            System.out.println("Enter the price: ");
            double price = scanner.nextDouble();
            System.out.println("Enter the delivery time (Factory_New/Minimal_Wear/Field-Tested/Battle-Scarred): ");
            String deliveryTime = scanner.nextLine();
            String sql = "INSERT INTO bookcriteria (username,bookTitle, price, deliveryTime) VALUES (?, ?, ?)";
                System.out.println("Book added for sale successfully.");

            System.out.print("Do you want to add another book for sale? (yes/no): ");
            String addAnotherBook = scanner.nextLine().toLowerCase();
            if (!addAnotherBook.equals("yes")) {
                break;
            }
        }
}
}
