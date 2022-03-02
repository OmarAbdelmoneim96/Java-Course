
package xcharttitanic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;




public class ChartInstance {
    
    public List<Passenger> getPassengersFromJsonFile() throws FileNotFoundException, IOException {
        
        List<Passenger> allPassengers= new ArrayList<Passenger> ();
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        InputStream input = new FileInputStream("E:\\ITI\\Data_to_use\\titanic_csv.json");
        //Read JSON file
        allPassengers= objectMapper.readValue(input, new TypeReference<List<Passenger>> () {});
        
        return allPassengers;
    }
    
    public void graphPassengerAges(List<Passenger> passengerList) {
        //filter to get an array of passenger ages
        List<Float> pAges= passengerList.stream().map (Passenger::getAge).limit (8).collect (Collectors.toList());
        List<String> pNames= passengerList.stream().map (Passenger::getName).limit (8).collect (Collectors.toList());
        //Using XCartto graph the Ages 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW); 
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        // 4.Show it
        chart.setTitle("Passengers Ages");
        new SwingWrapper(chart).displayChart();
    }
    
    
    
    public void graphPassengerClass(List<Passenger> passengerList) {
        
        Map<String, Long> result =
            passengerList.stream()
                    .collect (Collectors.groupingBy(Passenger::getPclass, Collectors.counting() ) );
        
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        
        // Customize Chart
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        
        // Show it
        chart.setTitle("Passengers Class");
        new SwingWrapper(chart).displayChart();
      
    }
    
    public void graphPassengerSurvived(List<Passenger> passengerList) {
        
        //filter to get a map of passengers survived
        Map<String, Long> result =
                passengerList.stream()
                .collect (Collectors.groupingBy(Passenger::getSurvived, Collectors.counting() ) );
        
        //System.out.println(result);
        
        // Create Chart
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        // Customize Chart
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
        chart.getStyler().setSeriesColors(sliceColors);
        // Series
        chart.addSeries("Didn't Survive", result.get("0"));
        chart.addSeries("Survived", result.get("1"));
        // Show it
        chart.setTitle("Passengers Survived");
        new SwingWrapper(chart).displayChart();        
    }
    
    public void graphPassengersurvivedGender(List<Passenger> passengerList) {
        
        //filter to get a map of survived and gender
        Map<String, Long> result =
                passengerList.stream()
                .filter(p -> p.getSurvived().equals("1"))
                .collect(Collectors.groupingBy(Passenger::getSex, Collectors.counting()));

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).build();
        
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler().setSeriesColors (sliceColors);
        
        // Series
        chart.addSeries ("Female Survived", result.get ("female"));
        chart.addSeries ("Male Survived", result.get ("male"));
        
        // Show it
        chart.setTitle("Passengers Survived with Gender");
        new SwingWrapper(chart).displayChart();
                
    }
    
}

