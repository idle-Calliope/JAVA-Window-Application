/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllUsers;

// @author : 1923636 Ellaine Fontamillas

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class AppendToAuditFile {
    
    private static String ID;
    private static String CurrentDateAndTime;
    private static String LoginInfo;
    
   // Method appends to audit login file
    public static void appendsToFile(String PassportNo,String DateAndTime)
    {
            ID = PassportNo;
            CurrentDateAndTime = DateAndTime;
            LoginInfo = ID +" "+CurrentDateAndTime;
       try
       {
           FileWriter fileWriter = new FileWriter("C:\\auditLog\\AuditLog.txt",true);//Creates File to C Drive//set to true for appending
           PrintWriter printWriter = new PrintWriter(fileWriter);
           printWriter.println(LoginInfo);
           printWriter.close();
       }
       catch(IOException ex)
       {
            JOptionPane.showMessageDialog(null, "Something went wrong appending to audit file "+ex.getMessage());
       }
    }
}
