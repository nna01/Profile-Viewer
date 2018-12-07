/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arony
 */
public class SignUpPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
                if(session!=null) {
                    session.invalidate();
                }
            /* TODO output your page here. You may use following sample code. */

            out.println("<html>\n"
                    + "<head>\n"
                    + "   <link rel=\"stylesheet\" href=\"css/styleNavBar.css\">\n"
                    + "   <link rel=\"stylesheet\" href=\"css/style.css\">\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    \n"
                    + "    <div class=\"navbar\">\n"
                    
                    + "\n"
                    + "            <div class=\"dropdown\">\n"
                    + "                <form action=\"index.html\" method=\"post\">\n"
                    + "                    <button class=\"dropbtn\">Login Page</button>\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    
                    + "\n"
                    + "        </div>"
                    + "  <div class=\"center\">\n"
                    + "  \n"
                    + "  <h2>Sign Up for an Account</h2>\n"
                    + "  <form onsubmit=\"return myFunction()\" action=\"Page1\" method=\"post\">\n"
                    + "   <input type=\"email\" name=\"email\" title=\"email\" placeholder=\"Email\" required/>\n"
                    + "    <input type=\"text\" name=\"username\" title=\"username\" placeholder=\"Username\" required/>\n"
                    + "    <input type=\"password\" name=\"password\" title=\"username\" placeholder=\"Password\" required/>\n"
                    + "    <input type=\"text\" name=\"fname\" title=\"Full Name\" placeholder=\"Full Name\" />\n"
                    + "    <p id=\"demo\"></p>\n"
                    + "    <button type=\"submit\" name=\"signup\">Sign Up</button>\n"
                    + "   \n"
                    + "  </form>\n"
                    + "</div>\n"
                    + "    \n"
                    + "    <script>\n"
                    + "function myFunction() {\n"
                    + "    var x, text;\n"
                    + "\n"
                    + "    // Get the value of the input field with id=\"numb\"\n"
                    + "    x = document.getElementById(\"username\");\n"
                    + "\n"
                    + "    // If x is Not a Number or less than one or greater than 10\n"
                    + "    if (x.includes(\"@\")) {\n"
                    + "        text = \"Invalid Name\";\n"
                    + "    } \n"
                    + "    document.getElementById(\"demo\").innerHTML = text;\n"
                    + "}\n"
                    + "</script>\n"
                    + " \n"
                    + "</body>\n"
                    + "\n"
                    + "</html>\n"
                    + "");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
