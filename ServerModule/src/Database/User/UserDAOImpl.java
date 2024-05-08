package Database.User;

import DataTypes.User;
import Database.Connection.DatabaseConnection;
import Database.Effort.EffortDAO;
import Database.Effort.EffortDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl extends DatabaseConnection implements UserDAO
{
  private static UserDAOImpl instance;

  private UserDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized UserDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new UserDAOImpl();
    }
    return instance;
  }

  @Override public User create(String username, String password)
      throws SQLException
  {
    try (Connection connection = getConnection())

    {
      PreparedStatement statement = connection.prepareStatement(
          "insert into User(username, password) VALUES (?,?);");
      statement.setString(1, username);
      statement.setString(2, password);
      statement.executeUpdate();
      return new User(username, password);
    }

  }

  @Override public User readByLoginInfo(String username, String password)
      throws SQLException
  {
    return null;
  }

  @Override public Connection getConnection() throws SQLException
  {

    return super.getConnection();
  }
}
