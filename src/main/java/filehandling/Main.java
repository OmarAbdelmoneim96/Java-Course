
package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    
    public static void main(String[] args) throws IOException {
        
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        
        FileWriter w = new FileWriter("E:\\ITI\\Test.txt");
        BufferedWriter bw = new BufferedWriter(w);
        
        String line ;
        do {
            System.out.println("Enter data ") ;
            line = br.readLine();
            
            if (!line.equals("stop")){
                
                bw.write(line + "\n") ;
                
            } 
          
        } while(!line.equals("stop") ) ;
        br.close() ;  
        bw.close();
    }
    
    
}
