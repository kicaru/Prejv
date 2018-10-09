
package MVC.model;



public class product {
    
    private String ID;
    private String Name;
    private float price;
    private String Detail;
    private String Add_date;
    private byte[] image;
    private String type;
    
   public product(){}
   
   public product(String name, float price, String detail, String addDate, byte[] img, String category){
   this.Name=name;
   this.Detail = detail;
   this.price = price;
   this.Add_date=addDate;
   this.image=img;
   this.type=category;
   
   
   }
   
   public product(String id,String name, float price, String detail, String addDate, String category){
   this.ID=id;
   this.Name=name;
   this.Detail = detail;
   this.price = price;
   this.Add_date=addDate;
   this.type=category;
   
   
   }
   
   public product(String id,String name, float price, String detail, String addDate, byte[] img, String category){
   this.ID=id;
   this.Name=name;
   this.Detail = detail;
   this.price = price;
   this.Add_date=addDate;
   this.image=img;
   this.type=category;
   }
   
    
    public void SetID(String ID){
       this.ID=ID;
   }
   
   public String GetID(){
       return ID;
   }
   
   public void Setname(String name){
       this.Name=name;
   }
   
   public String GetName(){
       return Name;
   }
   
   public void SetDescription(String Description){
       this.Detail=Description;
   }
   
   public String GetDescription(){
       return Detail;
   }
   
   public void SetPrice(float Price){
       this.price=Price;
   }
   
   public float GetPrice(){
       return price;
   }
   
   public void Setadd_date(String add_date){
       this.Add_date=add_date;
   }
   
   public String GetAdd_date(){
       return Add_date;
   }
   
   public void SetImage(byte[] Image){
       this.image=Image;
   }
   
   public byte[] GetImage(){
       return image;
   }
   
   
   
   public void SetType(String Type){
       this.type=Type;
   }
   
   public String GetType(){
       return type;
   }
   
   
}
