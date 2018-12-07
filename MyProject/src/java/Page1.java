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
public class Page1 extends HttpServlet {

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
                
                //session
                session.setAttribute("email",email);
                session.setAttribute("fname",fname);
                session.setAttribute("city",city);
                session.setAttribute("country",country);
                session.setAttribute("phone",phone);
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
                
                //session
                session.setAttribute("school",school);
                session.setAttribute("schoolInfo",schoolInfo);
                session.setAttribute("hschool",hschool);
                session.setAttribute("hschoolInfo",hschoolInfo);
                session.setAttribute("university",university);
                session.setAttribute("uniInfo",uniInfo);
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
                
                //session
                session.setAttribute("skill1",skill1);
                session.setAttribute("skill2",skill2);
                session.setAttribute("skill3",skill3);
                session.setAttribute("skill4",skill4);
                session.setAttribute("skill5",skill5);
                session.setAttribute("skill6",skill6);
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
                
                //session
                session.setAttribute("acc1",acc1);
                session.setAttribute("acc2",acc2);
                session.setAttribute("acc3",acc3);
                session.setAttribute("acc4",acc4);
                session.setAttribute("acc5",acc5);
                session.setAttribute("acc6",acc6);
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
                
                //session
                session.setAttribute("in1",in1);
                session.setAttribute("in2",in2);
                session.setAttribute("in3",in3);
                session.setAttribute("in4",in4);
                session.setAttribute("in5",in5);
                session.setAttribute("in6",in6);
            }

            rsGet.close();

        } catch (SQLException ex) {
            Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        session = request.getSession();
        String name = (String) session.getAttribute("uname");
        String pass = (String) session.getAttribute("password");

        userName = request.getParameter("username");
        password = request.getParameter("password");

        String signupbtn = null, savebtn=null;

        try {
            signupbtn = request.getParameter("signup");
            savebtn = request.getParameter("save");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = response.getWriter()) {

            if (signupbtn != null) {

                fname = request.getParameter("fname");
                email = request.getParameter("email");

                connectDB();

                try {

                    ResultSet results, rsGet;
                    stmnt.executeUpdate("insert into userlogin(username,password) values('" + userName + "','" + password + "')");

                    results = stmnt.executeQuery("SELECT uid FROM userlogin where username='" + userName + "'and password='" + password + "'");

                    if (results.next()) {

                        uid = results.getInt("uid");
                        stmnt.executeUpdate("insert into basicinfo(uid,email,fname) values(" + uid + ",'" + email + "','" + fname + "')");
                        stmnt.executeUpdate("insert into education(uid) values(" + uid + ")");
                        stmnt.executeUpdate("insert into interest(uid) values(" + uid + ")");
                        stmnt.executeUpdate("insert into skillinfo(uid) values(" + uid + ")");
                        stmnt.executeUpdate("insert into accomplishment(uid) values(" + uid + ")");
                    }

                    results.close();

                } catch (SQLException ex) {

                    Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else if(savebtn != null)
            {
                connectDB();
                email = request.getParameter("email");
                fname = request.getParameter("fname");
                city = request.getParameter("city");
                country = request.getParameter("country");
                phone = request.getParameter("phone");
                
                school =request.getParameter("school");
                schoolInfo = request.getParameter("schoolInfo");
                hschool = request.getParameter("hschool");
                hschoolInfo = request.getParameter("hschoolInfo");
                university = request.getParameter("university");
                uniInfo = request.getParameter("uniInfo");
                
                skill1 = request.getParameter("skill1");
                skill2 = request.getParameter("skill2");
                skill3 = request.getParameter("skill3");
                skill4 = request.getParameter("skill4");
                skill5 = request.getParameter("skill5");
                skill6 = request.getParameter("skill6");
                
                acc1 = request.getParameter("acc1");
                acc2 = request.getParameter("acc2");
                acc3 = request.getParameter("acc3");
                acc4 = request.getParameter("acc4");
                acc5 = request.getParameter("acc5");
                acc6 = request.getParameter("acc6");
                
                in1 = request.getParameter("in1");
                in2 = request.getParameter("in2");
                in3 = request.getParameter("in3");
                in4 = request.getParameter("in4");
                in5 = request.getParameter("in5");
                in6 = request.getParameter("in6");
                
                ResultSet results, rsGet;
                try {
                    stmnt.executeUpdate("update basicinfo set email = '"+email+
                                                            "',fname= '"+fname+
                                                            "',city= '"+city+
                                                            "',country= '"+country+
                                                            "',phone= '"+phone+
                                                             "' where uid = "+uid);
                    
                    stmnt.executeUpdate("update education set school = '"+school+
                                                            "',schoolInfo= '"+schoolInfo+
                                                            "',hschool= '"+hschool+
                                                            "',hschoolInfo= '"+hschoolInfo+
                                                            "',university= '"+university+
                                                            "',uniInfo= '"+uniInfo+
                                                            "' where uid = "+uid);
                    
                       stmnt.executeUpdate("update skillinfo set skill1 = '"+skill1+
                                                            "',skill2= '"+skill2+
                                                            "',skill3= '"+skill3+
                                                            "',skill4= '"+skill4+
                                                            "',skill5= '"+skill5+
                                                            "',skill6= '"+skill6+
                                                            "' where uid = "+uid);
                       
                       stmnt.executeUpdate("update accomplishment set acc1 = '"+acc1+
                                                            "',acc2= '"+acc2+
                                                            "',acc3= '"+acc3+
                                                            "',acc4= '"+acc4+
                                                            "',acc5= '"+acc5+
                                                            "',acc6= '"+acc6+
                                                            "' where uid = "+uid);
                       
                       stmnt.executeUpdate("update interest set in1 = '"+in1+
                                                            "',in2= '"+in2+
                                                            "',in3= '"+in3+
                                                            "',in4= '"+in4+
                                                            "',in5= '"+in5+
                                                            "',in6= '"+in6+
                                                            "' where uid = "+uid);
                       
                       
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
                }

                    
                
                
            }

            try {
                connectDB();
                ResultSet results;

                results = stmnt.executeQuery("SELECT uid FROM userlogin where username='" + name + "'and password='" + pass + "'");
                if (results.next()) {

                    uid = results.getInt("uid");
                }

                results.close();

            } catch (SQLException ex) {

                Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
            }

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
                    + "  <p> Username " + name + "</p>\n"
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
                    + "  <form action=\"Page2\" method=\"post\">\n"
                    + "    \n"
                    + "    <button type=\"submit\" name=\"update\">Update</button>\n"
                    + "   \n"
                    + "  </form>\n"
                    + " \n"
                    + "</div>\n"
                    + " \n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");

            // out.println("<h1>Servlet BookingPage at " + name + "</h1>");
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
