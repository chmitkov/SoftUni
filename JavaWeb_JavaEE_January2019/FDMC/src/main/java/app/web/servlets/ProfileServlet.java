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
import java.util.Map;

@WebServlet("/cats/profile")
public class ProfileServlet extends HttpServlet {

    private static final String PROFILE_HTML_FILE_PATH = "C:\\Users\\9999\\Desktop\\FDMC\\src\\main\\resources\\views\\htmls\\profile.html";
    private static final String NON_EXISTENT_FILE_PATH = "C:\\Users\\9999\\Desktop\\FDMC\\src\\main\\resources\\views\\htmls\\non-existent-cat.html";
    private final HtmlReader htmlReader;

    @Inject
    public ProfileServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = ((Map<String, Cat>) req.getSession().getAttribute("cats"))
                .get(req.getParameter("catName"));


        String result = cat == null
                ? this.htmlReader.readHtmlFile(NON_EXISTENT_FILE_PATH)
                .replace("{{name}}", req.getParameter("catName"))
                : this.htmlReader.readHtmlFile(PROFILE_HTML_FILE_PATH)
                .replace("{{name}}", cat.getName())
                .replace("{{breed}}", cat.getBreed())
                .replace("{{color}}", cat.getColor())
                .replace("{{age}}", cat.getAge() + "");

        resp.getWriter()
                .println(result);
    }
}
