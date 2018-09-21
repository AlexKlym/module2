package school;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;

public class SchoolDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/schooldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTCuseSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    private static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    static void createTable() {
        addMySQLToClassPath();
        try (Connection connect = getConnection();
             Statement statement = connect.createStatement()) {
            statement.execute("DROP TABLE school");
            statement.execute("CREATE TABLE IF NOT EXISTS school " +
                    " (id INT NOT NULL AUTO_INCREMENT, " +
                    " classname VARCHAR (3) NOT NULL ," +
                    " pupils INT(3) DEFAULT NULL ," +
                    " teachersFIO VARCHAR(255) NOT NULL, " +
                    " PRIMARY KEY(id) " +
                    ")"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void addRow(String[] values) {
        final String add = "INSERT INTO school (classname, pupils, teacherFIO) VALUES (?, ?, ?)";
        try(Connection connect = getConnection()){
            PreparedStatement statement = connect.prepareStatement(add);{
                statement.setString(1, values[0]);
                statement.setInt(2, Integer.parseInt(values[1]));
                statement.setString(3, values[2]);
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String getClassInfo(String className){
        final String getSt = "SELECT classname, pupils, teacherFIO FROM school WHERE classname = ?";
        String classNam = null;
        String classNum = null;
        String classTeacher = null;

        try(Connection connect = getConnection()){
            PreparedStatement statement = connect.prepareStatement(getSt);
            statement.setString(1, "className");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                classNam = resultSet.getString("classname");
                classNum = resultSet.getString("pupils");
                classTeacher = resultSet.getString("teacherFIO");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(classNam == null){
            return "Thee class " + className + " was not found";
        }else{
            return classNam + " " + classNum + " " + classTeacher;
        }
    }


}
