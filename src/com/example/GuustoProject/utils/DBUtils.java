package com.example.GuustoProject.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.GuustoProject.beans.UserAccount;
import com.example.GuustoProject.beans.MerchantData;
import com.example.GuustoProject.conn.ConnectionUtils;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select username,password from user_account where username = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select password from user_account where username = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("password");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static void insertMerchantData(Connection conn, MerchantData merchantData) throws SQLException {
		String sql = "insert into clientData(name,type,range,country) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		int index = 1;
		pstm.setString(index++, merchantData.getName());
		pstm.setString(index++, merchantData.getType());
		pstm.setString(index++, merchantData.getRange());
		pstm.setString(index++, merchantData.getCountry());

		pstm.executeUpdate();
	}

	public static List<MerchantData> queryMerchantData(Connection conn) throws SQLException {
		String sql = "Select name,type,range,country from merchantData";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<MerchantData> list = new ArrayList<MerchantData>();
		while (rs.next()) {
			String name = rs.getString("name");
			String type = rs.getString("type");
			String range = rs.getString("range");
			String country = rs.getString("country");
			
			MerchantData webForm = new MerchantData();
			webForm.setName(name);
			webForm.setType(type);
			webForm.setRange(range);
			webForm.setCountry(country);
			list.add(webForm);
		}
		return list;
	}
	
	public static void populateMerchantData() throws IOException, ClassNotFoundException, SQLException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sanke\\workspace\\GuustoProject\\Guusto_merchants_Canada.txt"));
		String line = "";  
		String sql = "insert into merchantData (name,type,range,country) values (?,?,?,?)";
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		while ((line = br.readLine()) != null) {  
			if (line.startsWith("*"))
				pstm.setString(1, line.substring(1));
			pstm.setString(2, br.readLine());
			pstm.setString(3, br.readLine());
			pstm.setString(4, "Canada");
			pstm.addBatch();
		}
		pstm.executeBatch();
		br.close();
	}
}