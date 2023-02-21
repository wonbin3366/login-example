package shop.mtcoding.loginexample.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import shop.mtcoding.loginexample.model.User;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            response.sendRedirect("/loginForm");
            return false;
        }
        return true;
    }
}
