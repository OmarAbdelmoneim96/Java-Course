
package olympicdelegation;

public class Main {
    
  public static void main(String[] args){
      
      Team football = new Team(1);
      Coach Khaled = new Coach ("Khaled","Tanta",1);
      Player Mohamed = new Player("Mohamed","Maadi, Cairo",1,Khaled,football);
      Mohamed.addMedal();
      Delegate egy = new Delegate("Egypt");
      egy.addPlayer(Mohamed);
      egy.addCoach(Khaled);
      System.out.println("..."+Mohamed.getCoach())  ;   
      
      
      
            
    }  
    
}