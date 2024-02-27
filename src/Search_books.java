import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Search_books {

    public void Search() throws SQLException {
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
        pstmt.setString(1, "%" + keyword + "%");
        Manipulations manipulations = new Manipulations();
        Personal personal = new Personal();
        while (true) {
            System.out.println("buy a new book");
            System.out.println("buy used book");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice1) {
                case 1:
                    Manipulations.viewAllBooks();
                    break;

                case 2:

                    while (true) {
                        System.out.println("\n1. View books");
                        System.out.println("2. go back");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                personal.search();
                                break;
                            case 2:
                                System.out.println("Exiting...");
                                return;
                            default:
                                System.out.println("Invalid choice, please try again.");

                        }
                    }
            }
        }
    }
}