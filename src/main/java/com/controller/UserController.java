package com.controller;

import com.model.User;
import com.service.UserService;
import com.tasks.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/users", asyncSupported = true)
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public void init() throws ServletException {
        AutowireCapableBeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("login_ui");
        String password = req.getParameter("password_ui");
        String age = req.getParameter("age_ui");
        String phoneNumber = req.getParameter("phoneNumber_ui");
        String homeAddress = req.getParameter("homeAddress_ui");
        String email = req.getParameter("email_ui");

        User user = new User(name, password, age, phoneNumber, homeAddress, email);
        List<User> users = userService.addUser(user);

        AsyncContext asyncContext = req.startAsync(req, resp);
        executorService.submit(new UserTask(asyncContext, users));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> usersList = userService.getAllUsers();
        resp.getWriter().println(usersList);
    }
}
