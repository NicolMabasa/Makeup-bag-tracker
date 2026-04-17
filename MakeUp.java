import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class MakeUp{

public  static void main(String[] args){

 Scanner input =  new Scanner(System.in);
  
 
 ArrayList<MakeupProduct> lip = new ArrayList<>();
 ArrayList<MakeupProduct> skin = new ArrayList<>();
 ArrayList<MakeupProduct> eye = new ArrayList<>();
 ArrayList<MakeupProduct> eyebrow = new ArrayList<>();
  LocalDate today = LocalDate.now();
 
 
 while(true){
 //main menu
   System.out.println("what would you like to do?");
   System.out.println("1. Add a product\n 2. Delete a product\n 3. View all products\n 4. Search for a product\n 5. Quit");
   int num = input.nextInt(); 
   input.nextLine();
 
 
 
 
 
 //adding a product
 if(num==1){
      System.out.println("Enter the product (else done to stop).");
      String product = input.nextLine();
      if((product.toLowerCase()).equals("done")){continue;}
      
      System.out.println(" Select a category:\n1. Lip\n2. Eye\n3. Eyebrow\n4. Skin");
      int choice = input.nextInt();
      input.nextLine();
       
        System.out.println("Enter expiry year");
        int expiryYear = input.nextInt();
        input.nextLine();
        
        System.out.println("Enter expiry month");
        int expiryMonth = input.nextInt();
        input.nextLine();
         
      MakeupProduct item = new MakeupProduct(product, expiryYear, expiryMonth);
     
      if(choice==1){lip.add(item);}
       
        else  if(choice==3){eyebrow.add(item);}
          
               else   if(choice==2){eye.add(item);}
                
                 else  if(choice==4){skin.add(item);}  
                 else{System.out.println("Invalid choice");}
     }
 

//deleting a product 
 else  if(num==2){
    System.out.println("Which category do want to delete from?");
    
    System.out.println("1. Lip\n 2. Eye\n 3. Eyebrow\n 4. Skin");
    int cat = input.nextInt();
    input.nextLine();
    
    if(cat==1){
        for(int i=0; i<lip.size(); i++){
         System.out.println(i+". "+ lip.get(i).getProductName());
        }
        
        System.out.println("Pick the number of the product you want to delete");
        int c = input.nextInt();
        input.nextLine();
        
        //checking number is within the boundary
        if(0<=c && c<lip.size()){lip.remove(c);}
        else{System.out.println("Invalid option");}
        
    }
    else if(cat==2){
        for(int i=0; i<eye.size(); i++){
         System.out.println(i+". "+ eye.get(i).getProductName());
        }
        
        System.out.println("Pick the number of the product you want to delete");
        int c = input.nextInt();
        input.nextLine();
        
        //checking number is within the boundary
        if(0<=c && c<eye.size()){eye.remove(c);}
        else{System.out.println("Invalid option");}
        
    }
    else if(cat==3){
        for(int i=0; i<eyebrow.size(); i++){
         System.out.println(i+". "+ eyebrow.get(i).getProductName());
        }
        
        System.out.println("Pick the number of the product you want to delete");
        int c = input.nextInt();
        input.nextLine();
        
        //checking number is within the boundary
        if(0<=c && c<eyebrow.size()){eyebrow.remove(c);}
        else{System.out.println("Invalid option");}
        
    }
    else if(cat==4){
        for(int i=0; i<skin.size(); i++){
         System.out.println(i+". "+ skin.get(i).getProductName());
        }
        
        System.out.println("Pick the number of the product you want to delete");
        int c = input.nextInt();
        input.nextLine();
        
        //checking number is within the boundary
        if(0<=c && c<skin.size()){skin.remove(c);}
        else{System.out.println("Invalid option");}
        
    }

}

    
    
  
 

  //veiwing all products
 else if(num==3){
     for(MakeupProduct s: lip){
       System.out.println("lip: "+ s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
   
       if(s.getExp_year()<today.getYear() || (s.getExp_year()==today.getYear() && s.getExp_mon()<today.getMonthValue())){System.out.println(s.getProductName()+" has expired.");}
       else if(s.getExp_year()==today.getYear() && s.getExp_mon()==today.getMonthValue()){System.out.println(s.getProductName()+" is about to  expire.");}
            else {System.out.println(s.getProductName()+" it's still in good condition .");}
             
     }
     
     for(MakeupProduct s: skin){
       System.out.println("skin: "+ s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
       
       if(s.getExp_year()<today.getYear() || (s.getExp_year()==today.getYear() && s.getExp_mon()<today.getMonthValue())){System.out.println(s.getProductName()+" has expired.");}
       else if(s.getExp_year()==today.getYear() && s.getExp_mon()==today.getMonthValue()){System.out.println(s.getProductName()+" is about to  expire.");}
            else {System.out.println(s.getProductName()+" it's still in good condition .");}
   
     }
   
   for(MakeupProduct s: eye){
       System.out.println("eye: "+ s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
       
       if(s.getExp_year()<today.getYear() || (s.getExp_year()==today.getYear() && s.getExp_mon()<today.getMonthValue())){System.out.println(s.getProductName()+" has expired.");}
       else if(s.getExp_year()==today.getYear() && s.getExp_mon()==today.getMonthValue()){System.out.println(s.getProductName()+" is about to  expire.");}
            else {System.out.println(s.getProductName()+" it's still in good condition .");}
   
     }
   
   for(MakeupProduct s: eyebrow){
       System.out.println("eyebrow: "+ s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
       
       if(s.getExp_year()<today.getYear() || (s.getExp_year()==today.getYear() && s.getExp_mon()<today.getMonthValue())){System.out.println(s.getProductName()+" has expired.");}
       else if(s.getExp_year()==today.getYear() && s.getExp_mon()==today.getMonthValue()){System.out.println(s.getProductName()+" is about to  expire.");}
            else {System.out.println(s.getProductName()+" it's still in good condition .");}
   
     }

   }
   //Searching for a product
   else if(num==4){
      System.out.println("Enter product you want to search");
      String p = input.nextLine();
      boolean found = false;
      
           for(MakeupProduct s: lip){
              if(s.getProductName().toLowerCase().equals(p.toLowerCase())){
                 System.out.println(s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
                 found = true;
                 break;
              }
           }
           
       if(!found){  
         for(MakeupProduct s: eye){ 
                    if(s.getProductName().toLowerCase().equals(p.toLowerCase()) ){
                       System.out.println(s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
                        found = true;
                        break;
                    }
        }
                 }
         
        if(!found){        
         for(MakeupProduct s: eyebrow){
              if(s.getProductName().toLowerCase().equals(p.toLowerCase()) ){
                 System.out.println(s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
                  found = true;
                  break;
              }
       } 
           }
           
       if(!found){  
         for(MakeupProduct s: skin){
                       if(s.getProductName().toLowerCase().equals(p.toLowerCase()) ){
                          System.out.println(s.getProductName()+" "+s.getExp_year()+"/"+s.getExp_mon());
                           found = true;
                            break;
                       }
        }
                    }
                    
          if(!found){System.out.println(p+" not found");}


   }
   //quiting 
  else if(num==5){break;}
  }
 }
 
}
