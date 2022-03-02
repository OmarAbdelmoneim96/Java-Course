
package countriesandcities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        
        System.out.println("Enter country code ");
        String line;
        line = br.readLine();
        
        br.close();
        
        
        
        
        CityCsvDao cdao=new CityDaoImp();
        List<City> citieslist = cdao.readCityFromCsv("E:\\ITI\\Data_sets\\cities.csv");
        
        CountryCsvDao countrydao=new CountryDaoImp();
        List<Country> countrieslist=countrydao.readCountryFromCsv("E:\\ITI\\Data_sets\\countries.csv");
        
        

        
        citieslist.stream().filter(city -> city.getCountryCode().equals(line)).sorted(Comparator.comparing(City::getPopulation)).forEach(System.out::println);
        
        List<Integer> ListOfPopulation = countrieslist.stream().map(country -> country.getPopulation()).collect(Collectors.toList());
        
        System.out.println( "Max population: " +ListOfPopulation.stream().max(Integer::compare).get() );
        System.out.println( "Avg population: " +ListOfPopulation.stream().mapToDouble(i -> Double.valueOf(i)).average().getAsDouble() );
        
        
        
        
            
            
            
        List<String> CountriesInCityCsv = citieslist.stream().map(city -> city.getCountryCode()).distinct().collect(Collectors.toList());
        
        List<City> HighestPopulationCities = new ArrayList<>(); 
        
        for(String cc : CountriesInCityCsv ){
            
            City x = citieslist.stream().filter(city -> city.getCountryCode().equals(cc)).max(Comparator.comparing(City::getPopulation)).get();
            //.sorted(Comparator.comparing(City::getPopulation)).findFirst().get();
            HighestPopulationCities.add(x);
        }
        System.out.println("Highest population city of each country: " + HighestPopulationCities);
        
        
        
        
        
        List<Integer> CapitalsId = countrieslist.stream().map(country -> country.getCapital()).collect(Collectors.toList());
        
        
        List<City> Capitals = new ArrayList<>();
        
        
        for(Integer id : CapitalsId ){
            
            if (id>0){
                City x = citieslist.stream().filter(city -> city.getId()== id  ).findAny().get();
                Capitals.add(x);
                
            }
                  
        }
        
        City HighestCapital = Capitals.stream().max(Comparator.comparing(City::getPopulation)).get();
        
        System.out.println("Highest population capital: "+HighestCapital);
        
        
    }        
            
        
 
    
}
