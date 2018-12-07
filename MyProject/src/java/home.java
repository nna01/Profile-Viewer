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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arony
 */
public class home extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            out.println("<html>\n"
                    + "<head>\n"
                    + "    <link rel=\"stylesheet\" href=\"css/styleTable.css\">\n"
                    + "    <link rel=\"stylesheet\" href=\"css/style.css\">\n"
                    + "    <link rel=\"stylesheet\" href=\"css/styleNavBar.css\">\n"
                    + "</head>\n"
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
                    + "        </div>\n"
                    + "\n"
                    + "<h2>See Profiles</h2>");

            ResultSet rsGet1, rsGet2;

            myDBConnection db = new myDBConnection();
            Connection conn = db.getCon();
            Statement stmnt1 = conn.createStatement();
            Statement stmnt2 = conn.createStatement();

            rsGet1 = stmnt1.executeQuery("SELECT * FROM basicinfo");

            out.println("<table>\n"
                    + "  <tr>\n"
                    + "    <th>Name</th>\n"
                    + "    <th>Location</th>\n"
                    + "    <th>Educational Background</th>\n"
                    + "    <th>Full Profile</th>\n"
                    + "  </tr>");

            
            List<String> fnameStr = new ArrayList<String>();
            List<String> locationStr = new ArrayList<String>();
            List<Integer> uidStr = new ArrayList<Integer>();
            
            if (rsGet1.next()) {

                do {
                    uidStr.add(rsGet1.getInt("uid"));
                    fnameStr.add(rsGet1.getString("fname"));
                    locationStr.add(rsGet1.getString("city") + ", " + rsGet1.getString("country"));

                } while (rsGet1.next());

            }
            
            rsGet2 = stmnt2.executeQuery("SELECT * FROM education");
            List<String> univStr = new ArrayList<String>();
            
            if (rsGet2 .next()) {

                do {
                    univStr.add(rsGet2.getString("uniInfo"));


                } while (rsGet2.next());

            }

            for (int i = 0; i < uidStr.size(); i++) {
                
                //out.println("<h2>" + univStr.get(i) + "</h2>");
                
                out.println("<tr>");
                    
                    
                    out.println(new StringBuilder("<td>").append(fnameStr.get(i))
                            .append("</td>").toString());
        
                    
                    out.println(new StringBuilder("<td>").append(locationStr.get(i))
                    .append("</td>").toString());
                    
                    out.println(new StringBuilder("<td>").append(univStr.get(i))
                    .append("</td>").toString());
                    
                    out.println(new StringBuilder("<td>").append("<form action=\"viewPage\" method=\"post\">\n" +
"    <input type=\"hidden\" name=\"uid\" value=\""+ uidStr.get(i)+"\" />\n" +
"    <button type=\"submit\" class=\"button\" name=\"view\" >View</button>  \n" +
" </form>")
                    .append("</td>").toString());
                    
       
                   out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>\n"
                    + "</html>");

        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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
