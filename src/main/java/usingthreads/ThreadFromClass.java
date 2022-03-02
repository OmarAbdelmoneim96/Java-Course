
package usingthreads;

public class ThreadFromClass extends Thread {
    
    String name ;

    public ThreadFromClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        
        for (int i = 0 ; i<10 ; i++){
            
           System.out.println(i + " " + name );
           
           try {
               Thread.sleep(1000) ;
           } 
           catch (InterruptedException e) {
               
               System.out.println(name + " interrupted");
           }
        }
        System.out.println("Done! " + name);

    }
    
   
}
