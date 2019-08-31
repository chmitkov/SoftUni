package app.web.servlets;

import app.util.HtmlReader;
import domain.entities.Cat;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/cats/create")
public class CreateServlet extends HttpServlet {
    private final static String CREATE_HTML_FILE_PATH = "C:\\Users\\9999\\Desktop\\FDMC\\src\\main\\resources\\views\\htmls\\cat-create.html";
    private final HtmlReader htmlReader;

    @Inject
    public CreateServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter()
                .println(this.htmlReader.readHtmlFile(CREATE_HTML_FILE_PATH));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = new Cat(
                req.getParameter("name"),
                req.getParameter("breed"),
                req.getParameter("color"),
                Integer.parseInt(req.getParameter("age"))
        );

        if (req.getSession().getAttribute("cats") == null) {
            req.getSession().setAttribute("cats", new HashMap<String, Cat>());
        }

        HashMap<String, Cat> cats = (HashMap<String, Cat>) req.getSession().getAttribute("cats");
        cats.putIfAbsent(cat.getName(), cat);

        resp.sendRedirect(String.format("/FDMC_war_exploded/cats/profile?catName=%s", cat.getName()));
    }
}