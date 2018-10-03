package ru.edu.concur.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/count")
public class FactorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numStr = req.getParameter("num");
        if (numStr == null) {
            resp.sendRedirect("error.jsp");
            return;
        }
        Integer num = Integer.valueOf(numStr);
        List<Integer> factors = factor(num);
        encodeIntoResponse(resp, req, factors);
    }

    private void encodeIntoResponse(HttpServletResponse resp, HttpServletRequest req, List<Integer> factors) throws ServletException, IOException {
        req.setAttribute("countArray", factors);
        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    private List<Integer> factor(int i) {
        List<Integer> res = new ArrayList<>();
        for (int j = i; j > 0; j--) {
            res.add(j);
        }
        return res;
    }
}
