package ru.edu.concur.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/count")
public class FactorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger num = extractFromRequest(req);
        if (num == null) {
            resp.sendRedirect("error.jsp");
            return;
        }
        List<BigInteger> factors = factor(num);
        encodeIntoResponse(resp, req, factors);
    }

    private void encodeIntoResponse(HttpServletResponse resp, HttpServletRequest req, List<BigInteger> factors) throws ServletException, IOException {
        req.setAttribute("countArray", factors);
        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

    private BigInteger extractFromRequest(HttpServletRequest req) {
        String num = req.getParameter("num");
        return new BigInteger(num);
    }

    private List<BigInteger> factor(BigInteger i) {
        List<BigInteger> bigIntegers = new ArrayList<>();
        for (BigInteger j = i; j.compareTo(BigInteger.ZERO) > 0; j.subtract(BigInteger.ONE)) {
            bigIntegers.add(j);
        }
        return bigIntegers;
    }
}
