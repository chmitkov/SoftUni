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
import java.util.Map;

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {

    private final HtmlReader htmlReader;
    private static final String HTML_FILE_PATH = "C:\\Users\\9999\\IdeaProjects\\Cats2\\src\\main\\resources\\views\\all.html";

    @Inject
    public AllCatsServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Cat> catsRepo = (Map<String, Cat>) req.getSession().getAttribute("cats");
        StringBuilder sb = new StringBuilder();

        String result = this.htmlReader.readHTML(HTML_FILE_PATH);
        if (catsRepo != null) {
            for (String s : catsRepo.keySet()) {
                sb.append(String.format(
                        "<a href=\"/Cats2_war/cats/profile?name=%s\">%s</a>",
                        s, s))
                        .append("<br />");
            }

            result = this.htmlReader.readHTML(HTML_FILE_PATH)
                    .replace("{{allCats}}", sb.toString());

        } else {
            result = result.replace("{{allCats}}",
                    "There is no Cats in CatRepo");
        }


        resp.getWriter().println(result);
    }
}
