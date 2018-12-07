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
public class Page2 extends HttpServlet {

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

        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        
        String email,fname ,city="city" ,country="country" ,phone="phone";
 
        
        email = (String) session.getAttribute("email");
        fname = (String) session.getAttribute("fname");
        city = (String) session.getAttribute("city");
        country = (String) session.getAttribute("country");
        phone = (String) session.getAttribute("phone");

        String school = (String) session.getAttribute("school");
        String schoolInfo = (String) session.getAttribute("schoolInfo");
        String hschool = (String) session.getAttribute("hschool");
        String hschoolInfo = (String) session.getAttribute("hschoolInfo");
        String university = (String) session.getAttribute("university");
        String uniInfo = (String) session.getAttribute("uniInfo");

        String skill1 = (String) session.getAttribute("skill1");
        String skill2 = (String) session.getAttribute("skill2");
        String skill3 = (String) session.getAttribute("skill3");
        String skill4 = (String) session.getAttribute("skill4");
        String skill5 = (String) session.getAttribute("skill5");
        String skill6 = (String) session.getAttribute("skill6");

        String acc1 = (String) session.getAttribute("acc1");
        String acc2 = (String) session.getAttribute("acc2");
        String acc3 = (String) session.getAttribute("acc3");
        String acc4 = (String) session.getAttribute("acc4");
        String acc5 = (String) session.getAttribute("acc5");
        String acc6 = (String) session.getAttribute("acc6");

        String in1 = (String) session.getAttribute("in1");
        String in2 = (String) session.getAttribute("in2");
        String in3 = (String) session.getAttribute("in3");
        String in4 = (String) session.getAttribute("in4");
        String in5 = (String) session.getAttribute("in5");
        String in6 = (String) session.getAttribute("in6");

        try (PrintWriter out = response.getWriter()) {
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
                    + "            <div class=\"dropdown\">\n"
                    + "                <form action=\"index.html\" method=\"post\">\n"
                    + "                    <button class=\"dropbtn\">Logout </button>\n"
                    + "                </form>\n"
                    + "            </div> \n"
                    + "\n"
                    + "            <div class=\"dropdown\">\n"
                    + "                <form action=\"home\" method=\"post\">\n"
                    + "                    <button class=\"dropbtn\">Home</button>\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <div class=\"dropdown\">\n"
                    + "                <form action=\"Page1\" method=\"post\">\n"
                    + "                    <button class=\"dropbtn\">Own Profile</button>\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    + "\n"
                    + "        </div>"
                    + "  <div class=\"center\">\n"
                    + "  <h2>Update Your Profile</h2>\n"
                    + "  <form action=\"Page1\" method=\"post\">\n"
                    + "    \n"
                    + "    <input type=\"text\" name=\"fname\" title=\"FullName\" placeholder=\"Full Name\" value="+fname+">\n"
                    + "    <input type=\"text\" name=\"username\" title=\"Username\" placeholder=\"Username\" value="+uname+">\n"
                    + "    <input type=\"text\" name=\"email\" title=\"Email\" placeholder=\"Email\" value="+email+">\n"
                    + "    <input type=\"text\" name=\"city\" title=\"City\" placeholder=\"City\" value="+city+">\n"
                    + "    <input type=\"text\" name=\"country\" title=\"Country\" placeholder=\"Country\" value="+country+">\n"
                    + "    <input type=\"text\" name=\"phone\" title=\"Phone\" placeholder=\"Phone No.\" value="+phone+">\n"
                    + "    \n"
                    + "    <h1>Education</h1>\n"
                    + "    <input type=\"text\" name=\"school\" title=\"school\" placeholder=\"School\" value="+school+">\n"
                    + "    <input type=\"text\" name=\"schoolInfo\" title=\"schoolInfo\" placeholder=\"Description\" value="+schoolInfo+">\n"
                    + "    <input type=\"text\" name=\"hschool\" title=\"hschool\" placeholder=\"High School\" value="+hschool+">\n"
                    + "    <input type=\"text\" name=\"hschoolInfo\" title=\"hschoolInfo\" placeholder=\"Description\" value="+hschoolInfo+">\n"
                    + "    <input type=\"text\" name=\"university\" title=\"university\" placeholder=\"University\" value="+university+">\n"
                    + "    <input type=\"text\" name=\"uniInfo\" title=\"uniInfo\" placeholder=\"Description\" value="+uniInfo+">\n"
                    + "    \n"
                    + "    <h1>Skills & Endorsements</h1>\n"
                    + "    <input type=\"text\" name=\"skill1\" title=\"skill1\" placeholder=\"\" value="+skill1+">\n"
                    + "    <input type=\"text\" name=\"skill2\" title=\"skill2\" placeholder=\"\" value="+skill2+">\n"
                    + "    <input type=\"text\" name=\"skill3\" title=\"skill3\" placeholder=\"\" value="+skill3+">\n"
                    + "    <input type=\"text\" name=\"skill4\" title=\"skill4\" placeholder=\"\" value="+skill4+">\n"
                    + "    <input type=\"text\" name=\"skill5\" title=\"skill5\" placeholder=\"\" value="+skill5+">\n"
                    + "    <input type=\"text\" name=\"skill6\" title=\"skill6\" placeholder=\"\" value="+skill6+">\n"
                    + "    \n"
                    + "    <h1>Accomplishments</h1>\n"
                    + "    \n"
                    + "    <input type=\"text\" name=\"acc1\" title=\"acc1\" placeholder=\"\" value="+acc1+">\n"
                    + "    <input type=\"text\" name=\"acc2\" title=\"acc2\" placeholder=\"\" value="+acc2+">\n"
                    + "    <input type=\"text\" name=\"acc3\" title=\"acc3\" placeholder=\"\" value="+acc3+">\n"
                    + "    <input type=\"text\" name=\"acc4\" title=\"acc4\" placeholder=\"\" value="+acc4+">\n"
                    + "    <input type=\"text\" name=\"acc5\" title=\"acc5\" placeholder=\"\" value="+acc5+">\n"
                    + "    <input type=\"text\" name=\"acc6\" title=\"acc6\" placeholder=\"\" value="+acc6+">\n"
                    + "    \n"
                    + "    <h1>Interest</h1>\n"
                    + "    \n"
                    + "    <input type=\"text\" name=\"in1\" title=\"in1\" placeholder=\"\" value="+in1+">\n"
                    + "    <input type=\"text\" name=\"in2\" title=\"in2\" placeholder=\"\" value="+in2+">\n"
                    + "    <input type=\"text\" name=\"in3\" title=\"in3\" placeholder=\"\" value="+in3+">\n"
                    + "    <input type=\"text\" name=\"in4\" title=\"in4\" placeholder=\"\" value="+in4+">\n"
                    + "    <input type=\"text\" name=\"in5\" title=\"in5\" placeholder=\"\" value="+in5+">\n"
                    + "    <input type=\"text\" name=\"in6\" title=\"in6\" placeholder=\"\" value="+in6+">\n"
                    + "    \n"
                    + "    <button type=\"submit\" name=\"save\" >Save</button>\n"
                    + "   \n"
                    + "  </form>\n"
                    + "</div>\n"
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
