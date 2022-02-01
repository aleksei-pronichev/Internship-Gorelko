package crud;

import connection.JdbcUtils;
import crudInterface.ICrud;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud implements ICrud {
    @Override
    public void create(Student student) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into student values (" + student.getId() + ", '" + student.getName() + "', '" + student.getSurname() + "', " + student.getAge() + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    @Override
    public Student read(int id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        Student student = new Student();

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM student where id_student = " + id;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println();
                student.setId(rs.getInt("id_student"));
                student.setName(rs.getString("name_student"));
                student.setSurname(rs.getString("surname_student"));
                student.setAge(rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
        return student;
    }

    @Override
    public void update(int id, int age) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "UPDATE student SET age = " + age + " WHERE id_student = " + id;
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "DELETE FROM student WHERE id_student = " + id;
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }
}
