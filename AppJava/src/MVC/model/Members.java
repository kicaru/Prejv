/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.model;


public class Members {
    private int MID;
    private String ID;
    private String Fname;
    private String Lname;
    private String Email;
    private String Brith_date;
    private String Pwd;
    private String Tel;
    private String Address;
    private String Sex;
    private String type;


    
    
  public Members(String id, String pwd, String fname, String lname, String email, String addDate, String tel, String address, String Sex)
  {
      this.ID=id;
      this.Pwd=pwd;
      this.Fname=fname;
      this.Lname=lname;
      this.Email=email;
      this.Brith_date=addDate;
      this.Tel=tel;
      this.Address=address; 
      this.Sex=Sex;
  }
   public Members(String id,String fname,String lname,String type)
  {
  this.ID=id;
  this.Fname=fname;
  this.Lname=lname;
  this.type=type;
  }
  public Members(String id,String pwd)
  {
  this.ID=id;
  this.Pwd = pwd;
  }

    public Members() {
    }
    
  public void SetId(String id){
      this.ID=id;
  }
  
  public void SetPwd(String Pwd){
      this.Pwd = Pwd;
  }
  
  public void SetType(String type){
      this.type=type;
  }
  public void Setfname(String fname){
      this.Fname=fname;
  }
  
  public void Setlname(String lname){
      this.Lname=lname;
  }
    
  public int GetMid()
  {
      return MID;
  }
  
  public String GetID()
  {
      return ID;
  }
  
  public String GetPwd()
  {
      return Pwd;
  }
  
  public String GetFname()
  {
      return Fname;
  }
 
  public String GetLname()
  {
      return Lname;
  }
  
  public String GetEmail()
  {
      return Email;
  }
  
  public String GetBrith_date()
  {
      return Brith_date;
  }
  
  public String GetTel()
  {
      return Tel;
  }
  
  public String GetAddress()
  {
      return Address;
  }
  
  public String GetSex()
  {
      return Sex;
  }
  public String GetType(){
      return type;
  }
}
