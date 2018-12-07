/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arony
 */
public class viewPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    int uid = 0;
    String userName = "", password = "";
    String email = "", fname = "", city = "", country = "", phone = "";
    String acc1 = "", acc2 = "", acc3 = "", acc4 = "", acc5 = "", acc6 = "";
    String school = "", schoolInfo = "", hschool = "", hschoolInfo = "", university = "", uniInfo = "";
    String in1 = "", in2 = "", in3 = "", in4 = "", in5 = "", in6 = "";
    String skill1 = "", skill2 = "", skill3 = "", skill4 = "", skill5 = "", skill6 = "";
    Connection conn;
    Statement stmnt;
    HttpSession session;

    public void connectDB() {
        try {
            myDBConnection db = new myDBConnection();
            conn = db.getCon();
            stmnt = conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getBasicInfo() {
        try {

            connectDB();
            ResultSet rsGet;

            //get basic info in variables
            rsGet = stmnt.executeQuery("SELECT * FROM basicinfo where uid=" + uid + "");

            if (rsGet.next()) {

                email = rsGet.getString("email");
                fname = rsGet.getString("fname");
                city = rsGet.getString("city");
                country = rsGet.getString("country");
                phone = rsGet.getString("phone");
                
            }

            rsGet.close();
        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getEducationInfo() {
        try {

            connectDB();
            ResultSet rsGet;

            //get education info in variables
            rsGet = stmnt.executeQuery("SELECT * FROM education where uid=" + uid + "");

            if (rsGet.next()) {

                school = rsGet.getString("school");
                schoolInfo = rsGet.getString("schoolInfo");
                hschool = rsGet.getString("hschool");
                hschoolInfo = rsGet.getString("hschoolInfo");
                university = rsGet.getString("university");
                uniInfo = rsGet.getString("uniInfo");
                
            }

            rsGet.close();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getSkillInfo() {
        try {

            connectDB();
            ResultSet rsGet;

            //get education info in variables
            rsGet = stmnt.executeQuery("SELECT * FROM skillinfo where uid=" + uid + "");

            if (rsGet.next()) {

                skill1 = rsGet.getString("skill1");
                skill2 = rsGet.getString("skill2");
                skill3 = rsGet.getString("skill3");
                skill4 = rsGet.getString("skill4");
                skill5 = rsGet.getString("skill5");
                skill6 = rsGet.getString("skill6");
                
            }

            rsGet.close();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getAccomplishInfo() {
        try {

            connectDB();
            ResultSet rsGet;

            //get education info in variables
            rsGet = stmnt.executeQuery("SELECT * FROM accomplishment where uid=" + uid + "");

            if (rsGet.next()) {

                acc1 = rsGet.getString("acc1");
                acc2 = rsGet.getString("acc2");
                acc3 = rsGet.getString("acc3");
                acc4 = rsGet.getString("acc4");
                acc5 = rsGet.getString("acc5");
                acc6 = rsGet.getString("acc6");
                
            }

            rsGet.close();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getInterestInfo() {
        try {

            connectDB();
            ResultSet rsGet;

            //get education info in variables
            rsGet = stmnt.executeQuery("SELECT * FROM interest where uid=" + uid + "");

            if (rsGet.next()) {

                in1 = rsGet.getString("in1");
                in2 = rsGet.getString("in2");
                in3 = rsGet.getString("in3");
                in4 = rsGet.getString("in4");
                in5 = rsGet.getString("in5");
                in6 = rsGet.getString("in6");
                
            }

            rsGet.close();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {

            
            uid = Integer.parseInt(request.getParameter("uid"));
            
            
          //get basic info
          getBasicInfo();

            //getEducation info
          getEducationInfo();

            //get Interest info
           getInterestInfo();

            //get accomplishment info
           getAccomplishInfo();

            //get skill info
           getSkillInfo();
           
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
                    + "  <h2>Your Profile</h2>\n"
                    + "  <p> Full Name " + fname + "</p>\n"
                    + "  <p> Username " + uid + "</p>\n"
                    + "  <p> Email " + email + "</p>\n"
                    + "  <p>City " + city + "</p>\n"
                    + "  <p>Country " + country + "</p>\n"
                    + "  <p>Contact No. " + phone + "</p>\n"
                    + "  \n"
                    + "  <h1>Education</h1>\n"
                    + "  <p>University " + university + "</p>\n"
                    + "  <p> " + uniInfo + "</p>\n"
                    + "  <p>High School " + hschool + "</p>\n"
                    + "  <p> " + hschoolInfo + "</p>\n"
                    + "  <p>School " + school + "</p>\n"
                    + "  <p> " + schoolInfo + "</p>\n"
                    + "  \n"
                    + "  <h1>Skills & Endorsements</h1>\n"
                    + "  <p> " + skill1 + "</p>\n"
                    + "  <p> " + skill2 + "</p>\n"
                    + "  <p> " + skill3 + "</p>\n"
                    + "  <p> " + skill4 + "</p>\n"
                    + "  <p> " + skill5 + "</p>\n"
                    + "  <p> " + skill6 + "</p>\n"
                    + "  \n"
                    + "  <h1>Accomplishments</h1>\n"
                    + "  <p> " + acc1 + "</p>\n"
                    + "  <p> " + acc2 + "</p>\n"
                    + "  <p> " + acc3 + "</p>\n"
                    + "  <p> " + acc4 + "</p>\n"
                    + "  <p> " + acc5 + "</p>\n"
                    + "  <p> " + acc6 + "</p>\n"
                    + "  \n"
                    + "  <h1>Interest</h1>\n"
                    + "  <p> " + in1 + "</p>\n"
                    + "  <p> " + in2 + "</p>\n"
                    + "  <p> " + in3 + "</p>\n"
                    + "  <p> " + in4 + "</p>\n"
                    + "  <p> " + in5 + "</p>\n"
                    + "  <p> " + in6 + "</p>\n"
                    + "</div>\n"
                    + " \n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");
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
