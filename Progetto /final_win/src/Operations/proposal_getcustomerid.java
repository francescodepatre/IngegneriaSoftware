package Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class proposal_getcustomerid {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public int res(final int idp) {

		int idcus = 0;

		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			Statement stmt = conn.createStatement();
			
			String QUERY = "SELECT ID_customer FROM PROPOSAL WHERE IDProposal = " + idp + ";";
			
			ResultSet rset = stmt.executeQuery(QUERY);
			
			
			while(rset.next()) {
				idcus = rset.getInt("ID_customer");
			}
			

			
			

			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		return idcus;
		}
}
