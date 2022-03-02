
package xcharttitanic;

import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReadOptions;


public class Main {

    
    public static void main(String[] args) throws IOException {
        
        
        String datapath = "E:\\ITI\\Data_to_use\\titanic.csv";
        
        ////////Tablesaw:
        
        Table titanicData;
        titanicData = Table.read().csv(datapath);
        List<String> colNames = titanicData.columnNames();
        List<Column<?>> dataStructure = titanicData.columns();
        
        
        System.out.println(titanicData.structure());
        System.out.println("\n Summary: "+ titanicData.summary());
        
        
        ////////Joinery:
        
        DataFrame<Object> df = DataFrame.readCsv(datapath);
        List<Object> name = df.col("name") ;
        System.out.println("\nTotal number of passengers=\n"+  name.size()) ;
        DataFrame<Object> MaxAge = df.retain("age")
                .max();
        System.out.println("\nThe oldest passenger=\n"+MaxAge);
        DataFrame<Object> MinAge = df.retain("age")
                .min();
        System.out.println("\nThe youngest passenger=\n"+MinAge);
        
        ///////Plot:
        
        
        ChartInstance plt = new ChartInstance();
        List<Passenger> my_data = plt.getPassengersFromJsonFile();
        
        plt.graphPassengerAges(my_data);
        plt.graphPassengerClass(my_data);
        plt.graphPassengerSurvived(my_data);
        plt.graphPassengersurvivedGender(my_data);
        
    }
}
