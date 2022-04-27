/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllUsers;

// @author : 1923636 Ellaine Fontamillas

import Admin.AdminMain;
import Citizen.CitizenMain;
import Clerk.ClerkMain;
import DepartmentSupervisor.DepartmentMain;
import MinistrySupervisor.MinistryViewReport;
import java.sql.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

// @author : 1923636 Ellaine Fontamillas
public class UserDB {
  
    Scanner sc = new Scanner(System.in);
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/feedback_management_system";
    static String user ="root";
    static String pwd = "";
    
    static Connection con;
    static Statement stmt;
    
    public static LoginForm lf = new LoginForm();
    public static AdminMain am = new AdminMain();
    public static CitizenMain cm = new CitizenMain();
    public static ClerkMain clm = new ClerkMain();
    public static DepartmentMain dp = new DepartmentMain();
    public static MinistryViewReport mvr = new MinistryViewReport();
    
    public static final Connection CONNECT(){
        // Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            // register a driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // this will throw an exception 
            // open a connection
            con = DriverManager.getConnection(URL,user,pwd);
        }
        catch(ClassNotFoundException | SQLException e) // Class not found if for JDBC Driver class not found/imported
        {
            JOptionPane.showMessageDialog(null,"JDBC Driver was not imported","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return con;     
    }
    
    // FOR CITIZEN REGISTRATION
    public static void UserRegistration(UserClass uc) // Object is passed, it is neater
    {
        Connection con=CONNECT();
        PreparedStatement preparedStatement = null;
         
        try
        {
            String sql = "INSERT INTO users (PassportID,Name,Surname,Nationality,Phone_Number,Address,City,Date_Of_Birth,Gender,Educational_Qualification,Type,Password) "
                         +"VALUES ('"+uc.getPassportNO()+"','"+uc.getName()+"','"+uc.getSurname()+"','"+uc.getNationality()+"',"+uc.getPhone()+",'"+uc.getAddress()+"','"+uc.getCity()+"','"+uc.getDate()+"','"+uc.getGender()+"','"+uc.getQualification()+"','"+uc.getType()+"','"+uc.getPassword()+"')";
            
            preparedStatement = con.prepareStatement(sql);
            boolean result = preparedStatement.execute();
            if(result == false)
                JOptionPane.showMessageDialog(null,"Registration Successful!");
            
            con.close();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+e.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // FOR ALL USERS WHEN LOGGING IN
    public static void UserLogin(UserClass ud)
    {
      Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE PassportID = '"+ud.getPassportNO()+"' AND Password = '"+ud.getPassword()+"' AND Type = '"+ud.getType()+"'";
            ResultSet rs = stmt.executeQuery(sql); // execute a query
            
            //  While rows are being returned, user type is checked and its GUI is opened
            while(rs.next())
            {// retrieve by column name
               
                JOptionPane.showMessageDialog(null, "Login Successful");
                switch(ud.getType())
                {
                    case "admin":
                        am.setVisible(true);
                        break;
                    case "citizen":
                        cm.setVisible(true);
                        break;
                    case "clerk":
                        clm.setVisible(true);
                        break;
                    case "departmental supervisor":
                        dp.setVisible(true);
                        break;
                    case "ministerial supervisor":
                        mvr.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"You did not select a user type");
                        break;
                }
            }
            
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured while logging in\nPlease check that your details are correct","Error Message",JOptionPane.ERROR_MESSAGE);
            lf.setVisible(true); // Opens the Login Form again
        }   
    }
   
    
    //  FOR ALL USERS TO VIEW THEIR PROFILE
    public static void UserViewProfile(UserClass uc,JTable tbl)
    {
       Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT * FROM users WHERE PassportID = '"+uc.getPassportNO()+"'";
            ResultSet rs = stmt.executeQuery(sql); // execute a query
            DefaultTableModel tb = (DefaultTableModel) tbl.getModel();
            tb.setRowCount(0);
                        
            while(rs.next())
                {
                int Phone = rs.getInt("Phone_Number");
                String Name = rs.getString("Name"),
                       Surname = rs.getString("Surname"),
                       Nationality = rs.getString("Nationality"),
                       phone = Integer.toString(Phone),
                       Address = rs.getString("Address"),
                       City = rs.getString("City"),
                       DOB = rs.getString("Date_Of_Birth"),
                       DCreated = rs.getString("Date_Created"),
                       EQ = rs.getString("Educational_Qualification"),
                       //Type = rs.getString("Type"),
                       Password = rs.getString("Password");
                //char gender = rs
                String[] arr = {Name,Surname,Nationality,phone,Address,City,DOB,DCreated,EQ,Password};
                tb.addRow(arr);
                JOptionPane.showMessageDialog(null,"Table is now showing content","Notification",JOptionPane.INFORMATION_MESSAGE);
            }
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null,"THERE IS NO MORE CONTENT TO SHOW");
            }
            
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    // FOR ALL USERS TO UPDATE THEIR PROFILE
    public static void UserUpdateProfile(UserClass ud)
    {
        Connection con=CONNECT();
        PreparedStatement preparedStatement = null;
        String dob = ud.getDate().toString();
        try
        {
            stmt = con.createStatement();
            String sql = "UPDATE users SET Name = '"+ud.getName()+"'"
                    + ", Surname = '"+ud.getSurname()+"' "
                    + ", Nationality = '"+ud.getNationality()+"' "
                    + ", Phone_Number = "+ud.getPhone()+" "
                    + ", Address = '"+ud.getAddress()+"' "
                    + ", City = '"+ud.getCity()+"' "
                    + ", Date_Of_Birth = '"+dob+"' "
                    + ", Gender = '"+ud.getGender()+"' "
                    + ", Educational_Qualification = '"+ud.getQualification()+"' "
                    + ", Type = '"+ud.getType()+"' "
                    + ", Password = '"+ud.getPassword()+"' "
                    + "WHERE PassportID = '"+ud.getPassportNO()+"'";
            int result = stmt.executeUpdate(sql);
            
            if(result > 0)
                JOptionPane.showMessageDialog(null,"Record successfully updated");
            else
                JOptionPane.showMessageDialog(null,"Error: Updation unsuccessful");
            con.close();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Something went wrong: "+e.getMessage());
        }
    }
    
    // FOR ALL USERS TO SEND FEEDBACK
    public static void UserSendFeedback(FeedbackClass fb)
    {
        Connection con=CONNECT();
        PreparedStatement preparedStatement = null;
         
        try
        {
            String sql = "INSERT INTO feedback (Feedback_No,Feedback_Title,Status,Date_Created,Department_Responsible,Type_Of_Feedback,"
                    + "Person_Responsible,Description,UserID,Department_No,Ministry_No) VALUES ("+fb.getFeedbackNo()+",'"+fb.getFeedbackTitle()+"','"+fb.getStatus()+"',"
                    + "'"+fb.getDate()+"','"+fb.getDepartment()+"','"+fb.getType()+"','"+fb.getPerson()+"','"+fb.getDescription()+"','"+fb.getUserID()+"',"+fb.getDepNo()+", "+fb.getMinNo()+")";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.execute();
            
            JOptionPane.showMessageDialog(null,"Feedback Sent!");
            con.close();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+e.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // FOR CITIZEN TO VIEW FEEDBACK
    public static void UserViewFeedback(FeedbackClass fb, JTable fbtbl,JTable fbtbl2)
    {
       Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT Feedback_No,Feedback_Title,Status,Date_Created,Department_Responsible,Type_Of_Feedback,Person_Responsible,Description,Response,Date_Of_Response"
                    + " FROM feedback WHERE UserID = '"+fb.getUserID()+"'";//+" OR Feedback_No = "+fid;
            ResultSet rs = stmt.executeQuery(sql); // execute a query
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            DefaultTableModel tb1 = (DefaultTableModel) fbtbl2.getModel();
            tb.setRowCount(0);// Refreshes the table
            tb1.setRowCount(0);
           
            while(rs.next())
            {
                //int Id = rs.getInt("PassportID"),Phone = rs.getInt("Phone_Number");
                
                String FeedbackNo = rs.getString("Feedback_No"),
                       FeedbackTitle = rs.getString("Feedback_Title"),
                       Status = rs.getString("Status"),
                       DateCreated = rs.getString("Date_Created"),
                       Department = rs.getString("Department_Responsible"),
                       Type = rs.getString("Type_Of_Feedback"),
                       Assignee = rs.getString("Person_Responsible"),
                       Description = rs.getString("Description"),
                       Response = rs.getString("Response"),
                       DateOfResponse = rs.getString("Date_Of_Response");
                  
                String[] arr = {FeedbackNo,FeedbackTitle,Status,DateCreated,Department,Type,Assignee,DateOfResponse};
                String[] arr1 = {Description,Response};
                tb.addRow(arr);
                tb1.addRow(arr1);
                JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            }
            if(!(rs.next()))
            {
                JOptionPane.showMessageDialog(null,"There is no more content to show");
            }
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
     public static void ClerkViewFeedback(JTable fbtbl)
    {
       Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT Feedback_No,Feedback_Title,Status,Date_Created,Department_Responsible,Type_Of_Feedback,Person_Responsible,Description,Response,Date_Of_Response"
                    + " FROM feedback WHERE Person_Responsible = 'Clerk'";//+" OR Feedback_No = "+fid;
            ResultSet rs = stmt.executeQuery(sql); // execute a query
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            tb.setRowCount(0);// Refreshes the table
           
            while(rs.next())
            {
                //int Id = rs.getInt("PassportID"),Phone = rs.getInt("Phone_Number");
                
                String FeedbackNo = rs.getString("Feedback_No"),
                       FeedbackTitle = rs.getString("Feedback_Title"),
                       Status = rs.getString("Status"),
                       DateCreated = rs.getString("Date_Created"),
                       Department = rs.getString("Department_Responsible"),
                       Type = rs.getString("Type_Of_Feedback"),
                       Assignee = rs.getString("Person_Responsible"),
                       Description = rs.getString("Description"),
                       Response = rs.getString("Response"),
                       DateOfResponse = rs.getString("Date_Of_Response");
                  
                String[] arr = {FeedbackNo,FeedbackTitle,Status,DateCreated,Department,Type,Assignee,Description,Response,DateOfResponse};
                tb.addRow(arr);
                JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            }
            if(!(rs.next()))
            {
                JOptionPane.showMessageDialog(null,"There is no more content to show");
            }
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    // FOR SUPERVISOR/ADMIN TO VIEW FEEDBACK
    public static void AdminViewFeedback(JTable fbtbl,JTable fbtbl1,JTable fbtbl2)//,String type)
    {
        Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT * FROM feedback WHERE NOT Status = 'Closed' AND Type_Of_Feedback = 'Complaint'";

            ResultSet rs = stmt.executeQuery(sql); // execute a query
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            DefaultTableModel tb1 = (DefaultTableModel) fbtbl1.getModel();
            DefaultTableModel tb2 = (DefaultTableModel) fbtbl2.getModel();
            tb.setRowCount(0);// Refreshes the table
           
            while(rs.next())
            {
                //int Id = rs.getInt("PassportID"),Phone = rs.getInt("Phone_Number");
                
                String FeedbackNo = rs.getString("Feedback_No"),
                       FeedbackTitle = rs.getString("Feedback_Title"),
                       Status = rs.getString("Status"),
                       DateCreated = rs.getString("Date_Created"),
                       Department = rs.getString("Department_Responsible"),
                       Type = rs.getString("Type_Of_Feedback"),
                       Assignee = rs.getString("Person_Responsible"),
                       Description = rs.getString("Description"),
                       UserID = rs.getString("UserID"),
                       Response = rs.getString("Response"),
                       Reasons = rs.getString("Reason_For_Escalation"),
                       Remarks = rs.getString("Remarks_On_Actions_Done"),
                       DateOfResponse = rs.getString("Date_Of_Response"),
                       DepartmentNo = rs.getString("Department_No"),
                       Ministry_No = rs.getString("Ministry_No");
                       
                  
                String[] arr = {FeedbackNo,FeedbackTitle,Status,DateCreated,Department};
                String[] arr1 = {Type,Assignee,Description,UserID,Response};
                String[] arr2 = {Reasons,Remarks,DateOfResponse,DepartmentNo,Ministry_No};
                tb.addRow(arr);
                tb1.addRow(arr1);
                tb2.addRow(arr2);
                
            }
            JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    
    }
     
    // FOR VIEWING REPORTS - USED BY SUPERVISORS
    public static void SupervisorViewReport(JTable fbtbl)
    {
         Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT Feedback_Title,Status,Date_Created,Reason_For_Escalation,Remarks_On_Actions_Done,Date_Of_Response FROM feedback";
                     

            ResultSet rs = stmt.executeQuery(sql); // execute a querY
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            tb.setRowCount(0);// Refreshes the table
            while(rs.next())
            {
                String 
                       FeedbackTitle = rs.getString("Feedback_Title"),
                       Status = rs.getString("Status"),
                       DateCreated = rs.getString("Date_Created"),
                       Reasons = rs.getString("Reason_For_Escalation"),
                       Remarks = rs.getString("Remarks_On_Actions_Done"),
                       DateOfResponse = rs.getString("Date_Of_Response");
                       
                String[] arr = {FeedbackTitle,DateCreated,Status,Reasons,Remarks,DateOfResponse};
                tb.addRow(arr);
            }
            JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public static void SupervisorViewReport1(JTable fbtbl)
    {
         Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT Department_Name FROM department "
                    + "LEFT JOIN feedback "
                    + "ON feedback.Department_No = department.Department_No "
                    + "WHERE feedback.Department_No = department.Department_No";
            ResultSet rs = stmt.executeQuery(sql); // execute a querY
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            tb.setRowCount(0);// Refreshes the table
            while(rs.next())
            {
                String Department = rs.getString("Department_Name");
                       
                String[] arr = {Department};
                tb.addRow(arr);
            }
            JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public static void SupervisorViewReport2(JTable fbtbl)
    {
         Connection con = CONNECT();
        try {
            // create a statement
            stmt = con.createStatement();
            String sql = "SELECT Ministry_Name from ministries "
                    + "LEFT JOIN feedback "
                    + "on feedback.Ministry_No = ministries.Ministry_No "
                    + "WHERE feedback.Ministry_No = ministries.Ministry_No";
            ResultSet rs = stmt.executeQuery(sql); // execute a querY
            DefaultTableModel tb = (DefaultTableModel) fbtbl.getModel();
            tb.setRowCount(0);// Refreshes the table
            while(rs.next())
            {
                String Ministry = rs.getString("Ministry_Name");
                       
                String[] arr = {Ministry};
                tb.addRow(arr);
            }
            JOptionPane.showMessageDialog(null,"Table Updated","Notification",JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    // FOR CLERK AND SUPERVISOR TO UPDATE THEIR PROFILE
    public static void ClerkUpdateFeedback(FeedbackClass fb)
    {
        Connection con=CONNECT();
        PreparedStatement preparedStatement = null;
        try
        {
            stmt = con.createStatement();
            String sql = "UPDATE feedback SET Person_Responsible = '"+fb.getPerson()+"'"
                    + ", Status = '"+fb.getStatus()+"' "
                    + ", Response = '"+fb.getResponse()+"' "
                    + ", Reason_For_Escalation = '"+fb.getReason()+"' "
                    + ", Date_Of_Response = '"+fb.getDateReplied()+"' "
                    + "WHERE Feedback_No = "+fb.getFeedbackNo();
            int result = stmt.executeUpdate(sql);
            
            if(result > 0)
                JOptionPane.showMessageDialog(null,"Record successfully updated");
            else
                JOptionPane.showMessageDialog(null,"Error: Updation unsuccessful");
            con.close();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+e.getMessage());
        }
    }
     
    
    // FOR CLERK AND SUPERVISOR TO UPDATE THEIR PROFILE
    public static void DepartmentUpdateFeedback(FeedbackClass fb)
    {
        Connection con=CONNECT();
        PreparedStatement preparedStatement = null;
        try
        {
            stmt = con.createStatement();
            String sql = "UPDATE feedback SET Person_Responsible = '"+fb.getPerson()+"'"
                    + ", Status = '"+fb.getStatus()+"' "
                    + ", Response = '"+fb.getResponse()+"' "
                    + ", Remarks_On_Actions_Done = '"+fb.getRemarks()+"' "
                    + ", Date_Of_Response = '"+fb.getDateReplied()+"' "
                    + "WHERE Feedback_No = "+fb.getFeedbackNo();
            int result = stmt.executeUpdate(sql);
            
            if(result > 0)
                JOptionPane.showMessageDialog(null,"Record successfully updated");
            else
                JOptionPane.showMessageDialog(null,"Error: Updation unsuccessful");
            con.close();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"An error occured "+e.getMessage());
        }
    }
}
