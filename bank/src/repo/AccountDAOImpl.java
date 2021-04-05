package repo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bank.Account;
import util.ConnectionUtility;


public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account findById(int id) {
		try (Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE account_id = "+id+";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Account acc = new Account();
				acc.setId(result.getInt("account_id"));
				acc.setBalance(result.getDouble("balance"));
				acc.setType(result.getString("acc_type"));
				acc.setOwner(null);
				return acc;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		try (Connection conn = ConnectionUtility.getConnection()){
			String sql = "UPDATE accounts SET balance = ?, owner_fk = ? WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, account.getBalance());
			statement.setNull(++index, java.sql.Types.INTEGER);
			statement.setInt(++index, account.getId());
			
			statement.execute();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



}