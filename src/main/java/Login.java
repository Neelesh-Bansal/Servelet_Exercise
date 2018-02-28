import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();

        if(username.equals("neelesh") && password.equals("root")){

            response.sendRedirect("/blog.jsp");

        }
        else {
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request,response);
            printWriter.write("<p style='color:red'>Please Enter Correct Credential</p>");
        }


    }
}
