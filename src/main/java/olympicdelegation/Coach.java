
package olympicdelegation;

public class Coach extends Person {
    
    private int coachID ;
    
    public Coach(String name, String address, int coachID){
        
        super(name,address);
        this.coachID = coachID;

    }
    
    public void setcoachID(int coachID){
        this.coachID = coachID;
    }
    
    public int getcoachID(){
        return coachID;
    }
    
}
