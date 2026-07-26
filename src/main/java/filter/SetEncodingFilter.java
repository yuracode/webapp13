package filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

@WebFilter("/*")
public class SetEncodingFilter extends HttpFilter implements Filter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain chain)
            throws ServletException,UnsupportedOperationException,IOException {
        System.out.println("SetEncodingFilter: doFilter() called");
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
