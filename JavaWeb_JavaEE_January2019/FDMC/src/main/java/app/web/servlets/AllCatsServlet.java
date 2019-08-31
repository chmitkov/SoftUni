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

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {
    private static final String ALL_CATS_HTML_FILE_PATH = "C:\\Users\\9999\\Desktop\\FDMC\\src\\main\\resources\\views\\htmls\\all-cats.html";
    private final HtmlReader htmlReader;

    @Inject
    public AllCatsServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder links = new StringBuilder();
        Map<String, Cat> cats = (Map<String, Cat>) req.getSession().getAttribute("cats");
        if (cats.size() == 0) {
            links.append("There are no cats in my list");
        } else {
            cats.keySet()
                    .forEach(key -> links
                            .append(String.format("<a href=\"/FDMC_war_exploded/cats/profile?catName=%s\">%s</a><br/>", key, key))
                            .append(System.lineSeparator()));
        }

        String result = this.htmlReader.readHtmlFile(ALL_CATS_HTML_FILE_PATH)
                .replace("{{allCats}}", links.toString());
        resp.getWriter()
                .println(result);
    }
}
