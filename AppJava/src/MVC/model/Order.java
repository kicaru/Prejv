/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.model;

/**
 *
 * @author Noojar
 */
public class Order {
    private int id;
    private String Pid;
    private String Pname;
    private String Cid;
    private float price;
    private String type;
    private String date;
    
    public Order(){
    }
    public Order(String Pid,String Pname,String Cid,float price,String type,String date){
        this.Pid=Pid;
        this.Pname = Pname;
        this.Cid=Cid;
        this.price=price;
        this.type=type;
        this.date=date;
    }
    public Order(int id,String Pid,String Pname,String Cid,float price,String type,String date){
        this.id=id;
        this.Pid=Pid;
        this.Pname = Pname;
        this.Cid=Cid;
        this.price=price;
        this.type=type;
        this.date=date;
    }
    public void SetId(int id){
        this.id=id;
    }
    public void SetPid(String Pid){
        this.Pid=Pid;
    }
    public void SetPname(String Pname){
        this.Pname=Pname;
    }
    public void SetCid(String Cid){
        this.Cid=Cid;
    }
    public void SetPrice(float price){
        this.price=price;
    }
    public void SetType(String type){
        this.type=type;
    }
    public void SetDate(String date){
        this.date=date;
    }
    
    public int GetId(){
        return id;
    }
    public String GetPid(){
        return Pid;
    }
    public String GetPname(){
        return Pname;
    }
    public String GetCid(){
        return Cid;
    }
    public float GetPrice(){
        return price;
    }
    public String GetType(){
        return type;
    }
    public String GetDate(){
        return date;
    }
}
