/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Business.Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase_Access_Business_Logic {

	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private String columnValue = null;
	private static DataBase_Access_Business_Logic INSTANCE = null;

	private DataBase_Access_Business_Logic(String propertyFile) {
		try {
			String connectionString = ReadPropertyFile.getInstance(propertyFile).getProperty("connectionstring");
			connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			System.out.println("Error creating DB connection" + e.getMessage());
		}
	}

	/**
	 * Gets the single instance of DataBase_Access_Business_Logic.
	 *
	 * @param propertyFile
	 *            - Absolute Path of the property file containing the
	 *            key(connectionstring) value(connection string in the format -
	 *            <h2>"jdbc:sqlserver://<HostName or
	 *            IP>\\SqlInstanceName:PortNumber;instanceName=SqlInstanceName;integratedSecurity=false;user=UserNameForDB;password=PasswordForDB;")</h2>
	 * @return single instance of DataBase_Access_Business_Logic
	 */
	public static DataBase_Access_Business_Logic getInstance(String propertyFile) {
		return INSTANCE = new DataBase_Access_Business_Logic(propertyFile);
	}
	/**
	 * Instantiates a new access database.
	 *
	 * @param connectionString
	 *            {@link String} the connection string
	 */
	/*
	 * public DataBase_Access_Business_Logic(String connectionString) { try {
	 * connection = DriverManager.getConnection(connectionString); } catch
	 * (SQLException e) { System.out.println("Error creating DB connection"
	 * +e.getMessage()); } }
	 */

	/**
	 * Gets the single column value from the Database
	 *
	 * @param columnName
	 *            {@link String} the column name
	 * @param dbQuery
	 *            {@link String} the db query
	 * @return the single column value {@link String}
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public String getSingleColumnValue(String columnName, String dbQuery) {

		try {
			preparedStatement = connection.prepareStatement(dbQuery);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				columnValue = resultSet.getString(columnName);
			}

		} catch (SQLException sqe) {
			System.out.println(sqe.getMessage());
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error closing DB connection \n" + e.getMessage());
			}
		}
		return columnValue;
	}
}
