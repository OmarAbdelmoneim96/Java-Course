
package usingthreads;

public class Main {
    
    public static void main(String[] args){
        
        ThreadFromClass s1 = new ThreadFromClass("Thread Object 1") ;
        
        s1.start();
        
        ThreadFromInterface x = new ThreadFromInterface("Thread Object 2") ;
        Thread s2 = new Thread(x) ;
        s2.start() ;
        
        System.out.println("From the main method");
    }
    
}
