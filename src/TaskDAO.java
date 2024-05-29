import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tasklist";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    public static List<Task> findAll() {
        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM tasks";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setContent(rs.getString("content"));
                task.setCreated_at(rs.getTimestamp("created_at"));
                task.setUpdated_at(rs.getTimestamp("updated_at"));
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public static Task find(int id) {
        Task task = null;
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM tasks WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                task = new Task();
                task.setId(rs.getInt("id"));
                task.setContent(rs.getString("content"));
                task.setCreated_at(rs.getTimestamp("created_at"));
                task.setUpdated_at(rs.getTimestamp("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public static void create(Task task) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO tasks (content) VALUES (?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, task.getContent());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Task task) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "UPDATE tasks SET content = ? WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, task.getContent());
            pStmt.setInt(2, task.getId());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
