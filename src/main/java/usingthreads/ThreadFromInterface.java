
package usingthreads;

public class ThreadFromInterface implements Runnable  {
    
    
    String name ;

    public ThreadFromInterface(String name) {
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
