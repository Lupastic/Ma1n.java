import java.sql.*;
import java.util.Scanner;

public class Personal {

    Scanner scanner = new Scanner(System.in);
    public  void addBooksForSale() throws SQLException {
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
    public void search() throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        String sql = "SELECT * FROM bookcriteria WHERE bookTitle LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String Seller = rs.getString("username");
            String book = rs.getString("bookTitle");
            double price = rs.getDouble("price");
            String delivery_time = rs.getString("delivery_time");
            System.out.println("Seller: " + Seller + ", book: " + book + ", Price: $" + price + ", delivery_time: " + delivery_time);
        }
        rs.close();
        pstmt.close();
    }
    public void Buy_book() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseUtil.getConnection();
        System.out.print("Enter name of book: ");
        double keyword = scanner.nextInt();
        String sql1 = "SELECT * FROM bookcriteria WHERE bookTitle LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql1);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();
        Statement statement= connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql1);
        String Saller = resultset.getString("username");
        String title = resultset.getString("bookTitle");
        double price = resultset.getDouble("price");
        String delivery_time = resultset.getString("delivery_time");

        String sql2 = "INSERT INTO shopping_cart (Saller, title, price, delivery_time) VALUES (?, ?, ?, ?)";
        pstmt.setString(1, Saller);
        pstmt.setString(2, title);
        pstmt.setString(3, price);
        pstmt.setString(4, delivery_time);
        int rowsInserted = pstmt.executeUpdate();
        System.out.println(rowsInserted + " book(s) inserted on your cart.");
        pstmt.close();
        rs.close();
        pstmt.close();
    }

}
