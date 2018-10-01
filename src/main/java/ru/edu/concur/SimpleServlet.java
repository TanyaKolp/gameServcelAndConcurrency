package ru.edu.concur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/get")
public class SimpleServlet extends HttpServlet {
    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String my = req.getParameter("name");
        req.setAttribute("name", my);
//        req.getRequestDispatcher("page.jsp").forward(req, resp);



        resp.sendRedirect("page.jsp");
//        BigInteger i = extractFromRequest(req);
//        List<BigInteger> factors = factor(i);
//        encodeIntoResponse(resp, factors);
    }

    private void encodeIntoResponse(HttpServletResponse resp, List<BigInteger> factors) {
//        resp.
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
