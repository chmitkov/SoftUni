package appCats.web.servlets;

import appCats.domain.entities.Cat;
import appCats.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cats/create")
public class CreateServlet extends HttpServlet {

    private final HtmlReader htmlReader;
    private static final String HTML_FILE_PATH = "C:\\Users\\9999\\IdeaProjects\\Cats2\\src\\main\\resources\\views\\create.html";

    @Inject
    public CreateServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(htmlReader.readHTML(HTML_FILE_PATH));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = new Cat(
                req.getParameter("name"),
                req.getParameter("breed"),
                req.getParameter("color"),
                Integer.valueOf(req.getParameter("age"))
        );

        if (req.getSession().getAttribute("cats") == null) {
            req.getSession().setAttribute("cats", new LinkedHashMap<String, Cat>());
        }

        ((Map<String, Cat>) (req.getSession().getAttribute("cats")))
                .putIfAbsent(cat.getName(), cat);

        resp.sendRedirect(String.format("/Cats2_war/cats/profile?name=%s", cat.getName()));
    }
}
