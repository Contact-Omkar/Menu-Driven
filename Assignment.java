//Menu Driven - Book Table

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Assignment {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/assignment";
		String user = "root";
		String passwd = "root";
		Connection c = DriverManager.getConnection(url, user, passwd);
		Scanner s = new Scanner(System.in);
		while(true) {
		System.out.println("Book Details");
		System.out.println("1: Add Book");
		System.out.println("2: Remove Book");
		System.out.println("3: Update Book Name");
		System.out.println("4: Update Book Author Name");
		System.out.println("5: Update Book Prize");
		System.out.println("6: Search Book By Name");
		System.out.println("7: Exit");
		System.out.print("Enter Your Choice: ");
		int choice = s.nextInt();
		if (choice == 1) {
			System.out.print("Enter Book Id: ");
			int id = s.nextInt();
			System.out.print("Enter Book Name: ");
			String name = s.next();
			System.out.print("Enter Author Name: ");
			String author = s.next();
			System.out.print("Enter prize: ");
			int prize = s.nextInt();
			String query = "insert into book(id,name,author_name,prize) values(?,?,?,?);";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setString(3, author);
			stmt.setInt(4, prize);
			stmt.executeUpdate();
			System.out.println("Book Added");
		}else if (choice == 2) {
			System.out.print("Enter Id of Book that Need to be Remove: ");
			int id = s.nextInt();
			String query = "delete from book where id = (?);";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Book Removed");
		}else if (choice == 3) {
			System.out.print("Enter Id of book need to Update: ");
			int id = s.nextInt();
			System.out.print("Enter book name need: ");
			String book =s.next();
			String query = "update book set name = '" +book+ "' where id = (?);";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Details Updated");
		}else if (choice == 4) {
			System.out.print("Enter Id of Book: ");
			int id = s.nextInt();
			System.out.print("Enter New Author Name: ");
			String author = s.next();
			String query = "update book set author_name = '" +author+ "'where id = (?);";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Author Details Update");
		}else if (choice == 5) {
			System.out.print("Enter Id of book: ");
			int id = s.nextInt();
			System.out.print("Enter New Prize of Book: ");
			int prize = s.nextInt();
			String query = "update book set prize ='" +prize+  "'where id = (?);";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Prize Updated");
		}else if (choice == 6) {
			System.out.print("Enter Book Name: ");
			String name = s.next();
			String query = "select * from book where name = ?;";
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			System.out.println("Id: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Author: " + rs.getString("author_name") + ", Prize: " + rs.getInt("prize"));
			}
		}else if (choice == 7) {
				System.out.println("Successfully Exit.. GoodBye.. ");
				break;
		}else {
			System.out.println("Enter valid Choice");
		}
		}
		}
	}