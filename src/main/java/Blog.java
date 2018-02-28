import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Blog extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        int id = Integer.parseInt(request.getParameter("blogid"));
        String data = request.getParameter("blogdata");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "root");
            preparedStatement = connection.prepareStatement("insert into blog (blogid,blogdetails) values("+id+",'"+data+"')");
            preparedStatement.execute();
            printWriter.write("Your data is stored");

        } catch (Exception ex) {
            printWriter.write("Your data is not stored please try again with new BlogID"+ex.toString());
            System.out.println(ex);
        }

    }
}