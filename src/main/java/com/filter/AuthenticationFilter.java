package com;

import com.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebFilter(urlPatterns = "/users/*")
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String password = req.getParameter("password_ui");
        String login = req.getParameter("login_ui");

        if (!StringUtils.isEmpty(login) && StringUtils.isNotEmpty(password)) {

            InputStream resourceAsStream = UserService.class.getClassLoader().getResourceAsStream("users.properties");

            Properties properties = new Properties();
            properties.load(resourceAsStream);

            String adminLogin = properties.getProperty("login_from_property");
            String adminPassword = properties.getProperty("password_from_property");
            if (login.equals(adminLogin) && password.equals(adminPassword)) {
                chain.doFilter(req, resp);
            } else {
                errorMsg(resp, "Sorry, you aren't admin user!!!");
            }
        } else {
            errorMsg(resp, "ERROR!!!");
        }
    }

    private void errorMsg(ServletResponse resp, String x) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(x);
        writer.flush();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}