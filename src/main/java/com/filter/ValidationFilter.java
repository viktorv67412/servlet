package com.filter;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/users")
public class ValidationFilter implements Filter {

    private Map<String, String> validationMap = new HashMap<String, String>();

    public void init(FilterConfig filterConfig) {

        InputStream resourceAsStream = ValidationFilter.class.getClassLoader().getResourceAsStream("validation.properties");

        Properties properties = new Properties();

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            validationMap.put(key, value);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String password = request.getParameter("password_ui");
        String login = request.getParameter("login_ui");
        String age = request.getParameter("age_ui");
        String phoneNumber = request.getParameter("phoneNumber_ui");
        String homeAddress = request.getParameter("homeAddress_ui");
        String email = request.getParameter("email_ui");

        String msg = "";

        if (!StringUtils.isEmpty(login)
                && StringUtils.isNotEmpty(password)
                && StringUtils.isNotEmpty(age)
                && StringUtils.isNotEmpty(phoneNumber)
                && StringUtils.isNotEmpty(homeAddress)
                && StringUtils.isNotEmpty(email)) {

            if (!checkEmail(email)) {
                msg += "Your email is not correct\n";
            }
            if (!checkPassword(password)) {
                msg += "To short password\n";
            }
            if (!checkAge(age)) {
                msg += "Must be numbers\n";
            }
            if (!checkPhoneNumber(phoneNumber)) {
                msg += "Your email is not correct\n";
            }

            if (msg.equals("")) {
                chain.doFilter(request, response);
            } else {
                errorMsg(response, msg);
            }
        } else {
            errorMsg(response, ":(");
        }
    }

    private void errorMsg(ServletResponse response, String msg) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(msg);
        writer.flush();
    }

    private boolean checkPhoneNumber(String phoneNumber) {

        String phoneNumber_from_property = validationMap.get("phoneNumber_from_property.regexp");

        Pattern pattern = Pattern.compile(phoneNumber_from_property);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    private boolean checkAge(String age) {

        String age_from_property = validationMap.get("age_from_property.regexp");

        Pattern pattern = Pattern.compile(age_from_property);
        Matcher matcher = pattern.matcher(age);

        return matcher.matches();
    }

    private boolean checkPassword(String password) {
        return (password.length() < 8);
    }

    private boolean checkEmail(String email) throws IOException {

        String email_from_property = validationMap.get("email_from_property.regexp");

        Pattern pattern = Pattern.compile(email_from_property);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public void destroy() {

    }
}
