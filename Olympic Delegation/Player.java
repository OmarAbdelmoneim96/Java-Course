package olympicdelegation;

public class Player extends Person {
    
    private int playerID ;
    private int numMedal ;
    private Coach playerCoach ;
    private Team playerTeam ;
    
    public Player(String name, String address, int playerID, Coach playerCoach, Team playerTeam ){
        
        super(name,address);
        this.playerID = playerID;
        this.numMedal = 0;
        this.playerCoach = playerCoach ;
        this.playerTeam = playerTeam ;
        
    }
    
    public void setplayerID(int playerID){
        this.playerID = playerID;
    }
    
    public int getplayerID(){
        return playerID;
    }
    
    public void addMedal(){
        numMedal = 1 ;
    }
    
    
    public int getMedal(){
        return numMedal;
    }
    
    public void assignCoach(Coach playerCoach){
        
        this.playerCoach = playerCoach ;
    }
    
   public String getCoach(){
        return playerCoach.name;
    }
    
    public void assignTeam(Team playerTeam){
        
        this.playerTeam = playerTeam ;
    }
   
    public Team getTeam(){
        return playerTeam;
    }
    
}
