package Operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * The class {@code SqlSelectDemo} provides a simple demo
 * of the use of SQL that creates a table and selects some rows.
 *
**/

public class SqlSelectcDemo
{
  private static final String DBURL =
      "jdbc:mysql://localhost:3306/bookShop?";
  private static final String ARGS =
      "createDatabaseIfNotExist=true&serverTimezone=UTC";
  private static final String LOGIN = "root";
  private static final String PASSWORD = "root";

  public static void main(String[] args)
  {
    try (Connection conn = DriverManager.getConnection(
           DBURL + ARGS , LOGIN, PASSWORD);
         Statement stmt = conn.createStatement();)
    {
      String create = "create table if not exists books " +
          "(id int not null, " +
          " title VARCHAR(50), " +
          " author VARCHAR(50), " +
          " price float, " +
          " copies int, " +
          " primary key ( id ))";

      stmt.executeUpdate(create);

      String strSelect = "select title, price, copies from books";
      System.out.println("The SQL statement is: " + strSelect + "\n");

      ResultSet rset = stmt.executeQuery(strSelect);

      System.out.println("The records selected are:\n");

      int rowCount = 0;

      while (rset.next())
      {
        String title = rset.getString("title");
        double price = rset.getDouble("price");
        int copies   = rset.getInt("copies");

        System.out.println(title + ", " + price + ", " + copies);
        rowCount++;
      }

      System.out.println("\nTotal number of records = " + rowCount);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
