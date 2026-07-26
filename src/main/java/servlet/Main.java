package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;
import model.User;
import model.PostMutterLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        ServletContext application = getServletContext();
        List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
        if(mutterList == null) {
            mutterList = new ArrayList<>();
            application.setAttribute("mutterList", mutterList);
        }
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser == null) {
            response.sendRedirect("index.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        // Handle POST requests
        String text = request.getParameter("text");
        if(text != null && text.length() != 0) {
            ServletContext application = getServletContext();
            List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");

            Mutter mutter = new Mutter(loginUser.getName(), text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter, mutterList);
            application.setAttribute("mutterList", mutterList);
        } else {
            request.setAttribute("errorMsg", "つぶやきが入力されていません");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    }
    
}
