
package countriesandcities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImp implements CityCsvDao{
    
    private List<City> cities= new ArrayList<>();

    public CityDaoImp()
    {
        this.cities = new ArrayList<>();
    }


    @Override
    public List<City> readCityFromCsv(String fileName) {
        List<City> cities=new ArrayList<City>();
        //  =null;
        try
        {
            FileReader file=new FileReader(fileName);
            BufferedReader br =new BufferedReader(file);
            String line;
            line= br.readLine();
            while(line!=null)
            {
                //  line = br.readLine();
                String[] arr = line.split(",");
                City city = createCity(arr);
                cities.add(city);
                line = br.readLine();
            }

            br.close() ; 
            

        }
        catch(IOException e){
            e.printStackTrace();
        }

        return cities;
    }
    
    
    

    @Override
    public City createCity(String[] metadata) {
        int id=Integer.parseInt(metadata[0]);
        String name=metadata[1];
        int population=Integer.parseInt(metadata[2]);
        String countryCode=metadata[3].replaceAll("\\s+","");
        /*double height=0;
        //  double height=new Double(x);
        if (metadata[7]!=null && metadata[7].length()>0)
            height=Double.parseDouble(metadata[7]);*/
        City city=new City(id,name,population,countryCode);
        return city;
    }
    
}
