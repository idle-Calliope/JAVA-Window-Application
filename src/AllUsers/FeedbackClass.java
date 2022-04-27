/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllUsers;

// @author : 1923636 Ellaine Fontamillas

public class FeedbackClass {
    private String FeedbackTitle, Status,DepartmentResponsible
                  ,TypeOfFeedback,PersonResponsible,Description
                  ,Response,ReasonForEscalation,RemarksOnActionsDone;
    private int FeedbackNo,DepartmentNo,MinistryNo;
    private String DateCreated,DateReplied;
    private String UserID;
    
    public FeedbackClass(){}
    
    public FeedbackClass(String id)
    {
        this.UserID = id;
    }
    
    public FeedbackClass(String FeedbackTitle, String Status, String DepartmentResponsible,String TypeOfFeedback,
                         String PersonResponsible, String Description,int FeedbackNo,String DateCreated,String user,int depno,int minno)
    {
        this.FeedbackNo = FeedbackNo;
        this.FeedbackTitle = FeedbackTitle;
        this.Status = Status;
        this.DateCreated = DateCreated;
        this.DepartmentResponsible = DepartmentResponsible;
        this.TypeOfFeedback = TypeOfFeedback;
        this.PersonResponsible = PersonResponsible;
        this.Description = Description;             
        this.UserID = user;
        this.DepartmentNo = depno;
        this.MinistryNo = minno;
    }
    
    public FeedbackClass(String Remarks,int id,String Assignee,String Status,
                        String Response,String DateReplied)
    { 
        this.FeedbackNo = id;
        this.RemarksOnActionsDone = Remarks;
        this.PersonResponsible = Assignee;
        this.Status = Status;
        this.Response = Response;
        this.DateReplied = DateReplied;
    }
    
    public FeedbackClass(int FeedbackNo, String Reason,String Assignee,String Status,
                        String Response,String DateReplied)
    { 
        this.FeedbackNo = FeedbackNo;
        this.ReasonForEscalation = Reason;
        this.PersonResponsible = Assignee;
        this.Status = Status;
        this.Response = Response;
        this.DateReplied = DateReplied;
    }
    
    public FeedbackClass(String FeedbackTitle, String Status, String DepartmentResponsible,String TypeOfFeedback,
                         String PersonResponsible, String Description,int FeedbackNo,String DateCreated,String user,
                         String Response,String ReasonForEscalation,String RemarksOnActionsDone,String DateReplied)
    {
        this.FeedbackNo = FeedbackNo;
        this.FeedbackTitle = FeedbackTitle;
        this.Status = Status;
        this.DateCreated = DateCreated;
        this.DepartmentResponsible = DepartmentResponsible;
        this.TypeOfFeedback = TypeOfFeedback;
        this.PersonResponsible = PersonResponsible;
        this.Description = Description;             
        this.UserID = user;
        this.Response = Response;
        this.ReasonForEscalation = ReasonForEscalation;
        this.RemarksOnActionsDone = RemarksOnActionsDone;
        this.DateReplied = DateReplied;
    }
    
    
    
    public String getResponse()
    {
        return Response;
    }
    
    public void setResponse(String res)
    {
        Response = res;
    }
    
    public String getReason()
    {
        return ReasonForEscalation;
    }
    
    public void setReason(String reason)
    {
        ReasonForEscalation = reason;
    }
    
    public String getRemarks()
    {
        return RemarksOnActionsDone;
    }
    
    public void setRemarks(String Remarks)
    {
        RemarksOnActionsDone = Remarks;
    }
    
    public String getDateReplied()
    {
        return DateReplied;
    }
    
    public void setDateReplied(String dr)
    {
        DateReplied = dr;
    }

    public String getUserID()
    {
        return UserID;
    }
    
    public void setUSerID(String uid)
    {
        UserID = uid;
    }
    
    public int getFeedbackNo()
    {
        return FeedbackNo;
    }
    
    public void setFeedbackNo(int fno)
    {
        FeedbackNo = fno;
    }
    
    public String getFeedbackTitle()
    {
        return FeedbackTitle;
    }
    
    public void setFeedbackTitle(String title)
    {
        FeedbackTitle = title;
    }
    
    public String getStatus()
    {
        return Status;
    }
    
    public void setStatus(String status)
    {
        Status = status;
    }
    
    public String getDate()
    {
        return DateCreated;
    }
    
    public void setDate(String date)
    {
        DateCreated = date;
    }
    
    public String getDepartment()
    {
        return DepartmentResponsible;
    }
    
    public void setDepartment(String dpt)
    {
        DepartmentResponsible = dpt;
    }
    
    public int getDepNo()
    {
        return this.DepartmentNo;
    }
    
    public void setDepNo(int depno)
    {
        this.DepartmentNo = depno;
    }
    
    public int getMinNo()
    {
        return this.MinistryNo;
    }
    
    public void setMinNo(int min)
    {
        this.MinistryNo = min;
    }
    
    public String getType()
    {
        return TypeOfFeedback;
    }
    
    public void setType(String type)
    {
        TypeOfFeedback = type;
    }
            
    public String getPerson()
    {
        return PersonResponsible;
    }
    
    public void setPerson(String person)
    {
        PersonResponsible = person;
    }
    
    public String getDescription()
    {
        return Description;
    }
    
    public void setDescription(String desc)
    {
        Description = desc;
    }
    
    public String details()
    {
          String ft = FeedbackTitle,
                 st = Status,
                 dp = DepartmentResponsible,
                 tp = TypeOfFeedback,
                 pr = PersonResponsible,
                 dn = Description,
                 dc = DateCreated,
                 re = Response,
                 ra = ReasonForEscalation,
                 rm = RemarksOnActionsDone,
                  uid = UserID;
          int fno = FeedbackNo;
              
          
          
          String text = "Title : "+ft+
                        "Status : "+st+
                        "Department : "+dp+
                        "Type : "+tp+
                        "Person : "+pr+
                        "Description : "+dn+
                        "Feedback No : "+fno+
                        "DateCreated : "+dc+
                        "Response : "+re+
                        "Escalation : "+ra+
                        "Remarks : "+rm+
                        "UserID : "+uid;
          return text;
    }
}
