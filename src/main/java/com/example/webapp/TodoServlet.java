package com.example.webapp;

import model.entity.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    public List<Task> list = new ArrayList<>();

    public void init() {
        list.add(new Task(1, "đi học"));
        list.add(new Task(2, "đi ngủ"));
        list.add(new Task(3, "đi chơi"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("vào đây -- get");
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            int idDel = Integer.parseInt(request.getParameter("id"));
            for (Task t : list
            ) {
                if (t.getId() == idDel) {
                    list.remove(t);
                    break;
                }
            }
        } else if (action != null && action.equals("edit")) {
            int idEdit = Integer.parseInt(request.getParameter("id"));
            for (Task t : list) {
                if (t.getId() == idEdit) {
                    request.setAttribute("taskEdit", t);
                    break;
                }
            }
            request.getRequestDispatcher("views/updatelist.jsp").forward(request, response);
        }
        showAllList(request, response);
    }

    public void showAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equals("Add")) {
            String newTask = request.getParameter("task");
            int id = list.size() == 0 ? 1 : (list.get(list.size() - 1).getId() + 1);
            list.add(new Task(id, newTask));
            showAllList(request, response);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("task");
            for (Task task : list
            ) {
                if (task.getId() == id) {
                    task.setTaskName(name);
                    break;
                }
            }
            showAllList(request, response);
        }

    }
}
