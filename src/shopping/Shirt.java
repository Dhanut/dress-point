package shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Shirt")
public class Shirt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        //out.println("HI WELCOME !!!!!!!");
        //out.print("Login Name: " + request.getParameter("login_name") + "Password: " + request.getParameter("password"));
        //User object = new User();

        String sleeve = request.getParameter("sleeve");
        String size =request.getParameter("size");
        String color = request.getParameter("color");
        String price = request.getParameter("price");
        System.out.println(sleeve);
        System.out.println(size);
        System.out.println(color);
        System.out.println(sleeve);

//        if(object.isUserdetails(request.getParameter("login_name"),request.getParameter("password"))){
//            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
//        }
//        else{
//            request.setAttribute("errorMessage", "Invalid login and password");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
