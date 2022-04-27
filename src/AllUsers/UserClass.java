/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllUsers;

// @author : 1923636 Ellaine Fontamillas

public class UserClass {
    private int PhoneNumber;
    private String PassportNumber,Name,Surname,Nationality,Address,City,Qualification,Password,Type;
    private String DOB;
    private char Gender;
    
    public UserClass() {}
    
    public UserClass(String PassportNumber,String Name,String Surname,String Nationality,int PhoneNumber,String Address,String City,String DOB,char Gender,String Qualification,String Type,String Password)
    {
        this.PassportNumber = PassportNumber;
        this.Name = Name;
        this.Surname = Surname;
        this.Nationality = Nationality;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.City = City;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Qualification = Qualification;
        this.Type = Type;
        this.Password = Password;
    }
    
     public UserClass(String PassportNumber,String Password,String Type)
    {
        this.PassportNumber = PassportNumber;
        this.Type = Type;
        this.Password = Password;
    }
     
    public UserClass(String PassportNo)
    {
        this.PassportNumber = PassportNo;
    }
     
    public String getPassportNO()
    {
        return this.PassportNumber;
    }
    
    public void setPassportNO(String pno)
    {
        PassportNumber = pno;
    }
     
    public String getName()
    {
        return Name;
    }
    
    public void setName(String nme)
    {
        Name = nme;
    }
    
    public String getSurname()
    {
        return Surname;
    }
    
    public void setSurname(String snme)
    {
        Surname = snme;
    }
    
    public String getNationality()
    {
        return Nationality;
    }
    
    public void setNationality(String nation)
    {
        Nationality = nation;
    }
    
    public int getPhone()
    {
        return PhoneNumber;
    }
    
    public void setPhone(int Phone)
    {
        PhoneNumber = Phone;
    }
    
    public String getAddress()
    {
        return Address;
    }
    
    public void setAddress(String add)
    {
        Address = add;
    }
    
    public String getCity()
    {
        return City;
    }
    
    public void setCity(String city)
    {
        City = city;
    }
    
    public String getDate()
    {
        return DOB;
    }
    
    public void setDOB(String dob)
    {
        DOB = dob;
    }
    
    public char getGender()
    {
        return Gender;
    }
    
    public void setGender(char gender)
    {
        Gender = gender;
    }
    
    public String getQualification()
    {
        return Qualification;
    }
    
    public void setQualification(String qfn)
    {
        Qualification = qfn;
    }
    
    public String getType()
    {
        return Type;
    }
    
    public void setType(String type)
    {
        Type = type;
    }
    
    public String getPassword()
    {
        return Password;
    }
    
    public void setPassword(String password)
    {
        Password = password;
    }
    
    public String print()
    {
        int  pno = PhoneNumber;
        String nam = Name, sur = Surname, nat = Nationality,pid = PassportNumber,
               add = Address, cit = City, qfn = Qualification, pwd = Password,dob = DOB;
        char gen = Gender;
    
        String details = "Passport ID : "+pid + 
                         "Phone No : "+pno + 
                         "Name : "+nam + 
                         "Surname : "+sur + 
                         "Nationality : "+nat + 
                         "Address : "+add + 
                         "City : "+cit + 
                         "Qualification : "+qfn + 
                         "Password : "+pwd + 
                         "Date Of Birth : "+dob + 
                         "Gender : "+gen;
        return details;
    }
}
