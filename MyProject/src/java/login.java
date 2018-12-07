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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arony
 */
public class login extends HttpServlet {

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
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String loginbtn = null, signupbtn = null,logoutbtn=null;
        
        HttpSession session1 = request.getSession();
        
        if(session1!=null) {
                    session1.invalidate();
                }
                
        try
        {
            loginbtn = request.getParameter("loginButton");
            signupbtn  = request.getParameter("signup");
            logoutbtn = request.getParameter("logout");
            
        }catch(Exception e)
        {
           e.printStackTrace();
        }
        
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            
            myDBConnection db=new myDBConnection();
            Connection conn=db.getCon();
           
            if(loginbtn!=null)
            {
                Statement stmnt= conn.createStatement();
            
                ResultSet results;
                //stmnt.executeUpdate("insert into userlogin(username,password) values('"+userName+"','"+password+"')");
                results=stmnt.executeQuery("SELECT * FROM userlogin where username='"+userName+"'and password='"+password+"'");
            
                if(results.next()){
                
                //staffname = results.getString("username");
                //request.getRequestDispatcher("BookingPage").include(request, response);
                
                
                HttpSession session=request.getSession();
                session.setAttribute("uname",userName);
                session.setAttribute("password",password);
                
             
                //response.sendRedirect("home");
                request.getRequestDispatcher("home").include(request, response);
                
                }else{
                    //request.getRequestDispatcher("BookingPage").include(request, response);
                    response.sendRedirect("index.html");
                }

                results.close();
            }
            else if(signupbtn!=null)
            {   
                userName = request.getParameter("uname");  
                password = request.getParameter("password");
                
                HttpSession session2=request.getSession();
                session2.setAttribute("uname",userName);
                session2.setAttribute("password",password);
                
                response.sendRedirect("SignUpPage");
            }
            else if(logoutbtn!=null)
            {   
                HttpSession session = request.getSession();
                if(session!=null) {
                    session.invalidate();
                }
                
                request.getRequestDispatcher("index.html").forward(request, response);
               // response.sendRedirect("index.html");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
