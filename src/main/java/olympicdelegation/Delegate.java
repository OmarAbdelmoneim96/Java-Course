
package olympicdelegation;

import java.util.ArrayList;
import java.util.List;

    
public class Delegate {
    
    public String country;
    public List<Player> playersList = new ArrayList<>();
    public List<Coach> coachsList = new ArrayList<>();
    
    public Delegate(String country ){
       this.country = country;
   
   }
    
    public void addPlayer(Player x ){
        
        playersList.add(x);
        
    }
    
    public void addCoach(Coach x){
        
        coachsList.add(x);
    }
    
    public int getNumPlayers(){
        
        return playersList.size() ;
    }
    
}
