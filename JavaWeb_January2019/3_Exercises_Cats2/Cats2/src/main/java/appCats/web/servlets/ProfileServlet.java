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

@WebServlet("/cats/profile")
public class ProfileServlet extends HttpServlet {

    private final HtmlReader htmlReader;
    private static final String HTML_FILE_PATH = "C:\\Users\\9999\\IdeaProjects\\Cats2\\src\\main\\resources\\views\\profile.html";
    private static final String ERROR_HTML_PATH = "C:\\Users\\9999\\IdeaProjects\\Cats2\\src\\main\\resources\\views\\cat-not-found.html";

    @Inject
    public ProfileServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }


    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = null;
        Map<String, Cat> catRepo = (Map<String, Cat>) (req.getSession().getAttribute("cats"));
        String searchedCatName = req.getQueryString().split("=")[1];
        if (catRepo.containsKey(searchedCatName)) {
            cat = catRepo.get(searchedCatName);
        }

        String htmlContent = "";
        if (cat != null) {
            htmlContent = this.htmlReader.readHTML(HTML_FILE_PATH)
                    .replace("{{name}}", cat.getName())
                    .replace("{{breed}}", cat.getBreed())
                    .replace("{{color}}", cat.getColor())
                    .replace("{{age}}", cat.getAge().toString());
        } else {
            htmlContent = this.htmlReader.readHTML(ERROR_HTML_PATH)
                    .replace("{{name}}", searchedCatName);
        }

        resp.getWriter().println(htmlContent);
    }
}
