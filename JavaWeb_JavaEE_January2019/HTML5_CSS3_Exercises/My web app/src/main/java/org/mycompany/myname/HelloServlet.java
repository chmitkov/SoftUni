package org.mycompany.myname;

/**
 * Created by anon on 1/10/2017.
 */

import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.getWriter().print("Hello from servlet");
    }
}