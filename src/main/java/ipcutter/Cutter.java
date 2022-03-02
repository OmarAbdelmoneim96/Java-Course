
package ipcutter;

public class Cutter {
    
    String cmdLine ;
    
    public Cutter(String cmdLine){
        this.cmdLine = cmdLine ;
    }
    
    public String getCommandLine(){
        return cmdLine;
    }
    
    public void setcmdLine(String cmdLine){
        this.cmdLine = cmdLine;
    }
    
    public String doCut(){
        String [] parts = cmdLine.split("\\.") ;
        
       if (parts.length != 4){
           return "Error in input!" ;
       }
       else {
           int p1 = Integer.parseInt(parts[0]) ;
           int p2 = Integer.parseInt(parts[1]) ;
           int p3 = Integer.parseInt(parts[2]) ;
           int p4 = Integer.parseInt(parts[3]) ;
           
           
           return "\n" + p1 + "\n" + p2 + "\n" + p3 + "\n" + p4 ;
       }
        
      
    }
}
