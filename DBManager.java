import java.sql.*;

class DBManager {
    public static void saveScoreToDB(int score) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quizdb", "root", "password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO scores(score) VALUES(?)");

            ps.setInt(1, score);
            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println("DB Error!");
        }
    }
}