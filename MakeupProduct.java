


public class MakeupProduct{

   public String  productName;
   public  int exp_mon;
   public  int exp_year;
   
   public  MakeupProduct( String productName,int exp_year , int  exp_mon){
      this.productName=productName;
      this.exp_year=exp_year;
      this.exp_mon=exp_mon;
     
      
   }
   
   public String getProductName(){ return productName;}
   public int getExp_year(){ return exp_year;}
   public int getExp_mon(){ return exp_mon;}
   }
