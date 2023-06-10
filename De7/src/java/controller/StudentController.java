
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.DTDConstants;
import model.StudentMD;

@WebServlet(name = "StudentController", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {

    private StudentMD data;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        data = new StudentMD();
        response.setContentType("text/html;charset=UTF-8");
        data.id = request.getParameter("id");
        data.name = request.getParameter("name");
        data.dob = request.getParameter("dob");
        data.department = request.getParameter("department");
        PrintWriter out = response.getWriter();
        if (request.getParameter("reset") != null) {
            response.sendRedirect("index.html");
        }
        if (data.id.length() > 0 && data.name.length() > 0 && data.dob.length() > 0 && data.CheckDB()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"get\" action=\"student\">\n"
                    + "            <button name = \"confirm\">Confirm</button>\n"
                    + "            <input type=\"submit\" value=\"Back\" name = \"back\"><br/>\n"
                    + "            <h1>id</h1>" + data.id + "<br/>\n"
                    + "            <h1>name</h1>" + data.name + "<br/>\n"
                    + "            <h1>dob</h1>" + data.dob + "<br/>\n"
                    + "            <h1>department</h1>" + data.department + "<br/>\n"
                    + "        </form>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <style>\n"
                    + "        .button {\n"
                    + "            margin: 20px;\n"
                    + "            background-color: greenyellow;\n"
                    + "            color: black;\n"
                    + "        }\n"
                    + "    </style>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <form method=\"post\" action=\"student\">\n"
                    + "            <button class=\"button\" name = \"add\">Add</button>\n"
                    + "            <input type=\"submit\" value=\"Reset\" class=\"button\" name = \"reset\"><br/>\n"
                    + "            id <input type = \"text\" name = \"id\"> " + (data.id.length() == 0 ? "Thong tin bi bo trong" : !data.CheckDB() ? "Id vua nhap bi trung trong DB" : "") + "<br/>\n"
                    + "            name <input type = \"text\" name = \"name\">" + (data.name.length() == 0 ? "Thong tin bi bo trong" : "") + "<br/>\n"
                    + "            dob yyyy-mm-dd <input type=\"text\" name = \"dob\">" + (data.dob.length() == 0 ? "Thong tin bi bo trong" : "") + "<br/>\n"
                    + "            department\n"
                    + "            <select name=\"department\">\n"
                    + "                <option>toa A2</option>\n"
                    + "                <option>toa A3</option>\n"
                    + "                <option>toa A4</option>\n"
                    + "                <option>toa A5</option>\n"
                    + "            </select>\n"
                    + "        </form>\n"
                    + "        \n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("back") != null) {
            HttpSession session = request.getSession();
            String department = (String) session.getAttribute("department");

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <style>\n"
                    + "        .button {\n"
                    + "            margin: 20px;\n"
                    + "            background-color: greenyellow;\n"
                    + "            color: black;\n"
                    + "        }\n"
                    + "    </style>\n"
                    + "    <head>\n"
                    + "        <title>TODO supply a title</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <form method=\"post\" action=\"student\">\n"
                    + "            <button class=\"button\" name = \"add\">Add</button>\n"
                    + "            <input type=\"submit\" value=\"Reset\" class=\"button\" name = \"reset\"><br/>\n"
                    + "            id <input type = \"text\" name = \"id\"><br/>\n"
                    + "            name <input type = \"text\" name = \"name\"><br/>\n"
                    + "            dob yyyy-mm-dd <input type=\"text\" name = \"dob\"><br/>\n"
                    + "            department\n"
                    + "            <select name=\"department\">\n"
                    + "                <option" + (department.equalsIgnoreCase("toa A2") ? " selected" : "") + ">toa A2</option>\n"
                    + "                <option" + (department.equalsIgnoreCase("toa A3") ? " selected" : "") + ">toa A3</option>\n"
                    + "                <option" + (department.equalsIgnoreCase("toa A4") ? " selected" : "") + ">toa A4</option>\n"
                    + "                <option" + (department.equalsIgnoreCase("toa A5") ? " selected" : "") + ">toa A5</option>\n"
                    + "            </select>\n"
                    + "        </form>\n"
                    + "        \n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        } else {
              try ( PrintWriter out = response.getWriter()) {

                out.print(data.AddStudent());
                response.sendRedirect("index.html");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("department", request.getParameter("department"));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
