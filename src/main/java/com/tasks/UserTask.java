package com.tasks;

import com.model.User;

import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class UserTask implements Runnable {

    private AsyncContext asyncContext;
    private List<User> users;

    public UserTask(AsyncContext asyncContext, List<User> users) {
        this.asyncContext = asyncContext;
        this.users = users;
    }

    public void run() {

        try {
            PrintWriter writer = asyncContext.getResponse().getWriter();
            writer.println(Arrays.toString(users.toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            asyncContext.complete();
        }
    }
}
