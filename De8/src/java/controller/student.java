
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

public class student extends HttpServlet {

    private Student db;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.db = new Student();
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet student</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action = \"student\" method = \"post\">");
            out.println("<table border=\"2\">\n" +
                        "  <tr>\n"
                    + "    <th>id</th>\n"
                    + "    <th>name</th>\n"
                    + "    <th>dob</th>\n"
                    + "    <th>department</th>\n"
                    + "    <th>approved</th>\n"
                    + "    <th>Action</th>\n"
                    + "  </tr>\n");
            for (int i = 0; i < db.id.size(); i++) {
                out.println("<tr>\n"
                        + "    <td>" + db.id.get(i) + "</td>\n"
                        + "    <td>" + db.name.get(i) + "</td>\n"
                        + "    <td>" + db.dob.get(i) + "</td>\n"
                        + "    <td>" + db.department.get(i) + "</td>\n"
                        + "    <td>" + db.approved.get(i) + "</td>\n"
                        + "    <td><button name = \"" + db.id.get(i) + "a" + "\" method=\"post\">approve</button>\n"
                        + "        <button name = \"" + db.id.get(i) + "d"+ "\" method=\"post\">delete</button></td>\n"
                        + "  </tr>\n"
                );
            }
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    private void Approve(HttpServletRequest request){
        for (String i : this.db.id){
            if (request.getParameter(i + "a") != null){
                db.Approve(i);
                break;
            }
        }
    }
    
    private void Delete(HttpServletRequest request){
        for (String i : this.db.id){
            if (request.getParameter(i + "d") != null){
                db.Delete(i);
                break;
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Approve(request);
        Delete(request);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
