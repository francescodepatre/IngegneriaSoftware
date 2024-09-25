package Operations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Proposal_result {

	private final String DBURL = "jdbc:mysql://localhost:3306/winery_db?";
	private final String LOGIN = "root";
	private final String PASSWORD = "FraCheAnt01.";
	
	public void res(final int idp, final int id_sel) {

		LocalDate dat = LocalDate.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dat.format(form);

		Date today = Date.valueOf(date);

		try {
			
			Connection conn = DriverManager.getConnection(DBURL, LOGIN, PASSWORD);
			
			String add_sign = "update proposal set proposal.Seller_sign = "+ id_sel + ", proposal.Date_compilation = '"+ today + "' where proposal.IDProposal = "+ idp + ";" ;
			PreparedStatement pstmt = conn.prepareStatement(add_sign);

			pstmt.executeUpdate(add_sign);
			

			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
}
