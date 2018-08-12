package shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 8/11/2018.
 */
@WebServlet(name = "QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           // request.setAttribute("errorMessage", "Invalid login and password");
           // request.getRequestDispatcher("/QueryServlet.jsp").forward(request,response);
           // request.getRequestDispatcher("/test1.jsp").forward(request,response);
        request.getRequestDispatcher("/Home.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // request.setAttribute("errorMessage", "Invalid login and password");
       // request.getRequestDispatcher("/QueryServlet.jsp").forward(request,response);
       // request.getRequestDispatcher("/test1.jsp").forward(request,response);
        request.getRequestDispatcher("/Home.jsp").forward(request,response);
    }
}
