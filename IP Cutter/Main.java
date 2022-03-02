
package ipcutter;


public class Main {
    
    public static void main(String[] args){
        
        String cmdLine = "192.168.1.1" ;
        Cutter x = new Cutter(cmdLine);
        
        System.out.println("The output of "+ cmdLine +" is: " + x.doCut()) ;
                
        
    }
}
