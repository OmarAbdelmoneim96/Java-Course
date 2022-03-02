
package countriesandcities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImp implements CountryCsvDao {
    
    private List<Country> countries=new ArrayList<>();

    public CountryDaoImp()
    {
        this.countries = new ArrayList<>();
    }


    @Override
    public List<Country> readCountryFromCsv(String fileName) {
        List<Country> countries=new ArrayList<Country>();
        //  =null;
        try
        {
            FileReader file=new FileReader(fileName);
            BufferedReader br=new BufferedReader(file);
            String line;
            line= br.readLine();
            while(line!=null)
            {
                //  line = br.readLine();
                String[] arr = line.split(",");
                Country country = createCountry(arr);
                countries.add(country);
                line = br.readLine();
            }

            br.close();

        }
        catch( IOException e){
            e.printStackTrace();
        }

        return countries;
    }

    @Override
    public Country createCountry(String[] metadata)
    {
        String code=metadata[0];
        String name=metadata[1];
        String continent=metadata[2];
        int population;
        if (isInteger(metadata[3]))
           {
            population=Integer.parseInt(metadata[3]);
           }
        else
            {
                population=0;
            }

        //int population=0;
        double surfaceArea=Double.parseDouble(metadata[4]);
        double gnp=Double.parseDouble(metadata[5]);
        int capital=Integer.parseInt(metadata[6]);

        return new Country(code,name,continent,population,surfaceArea,gnp,capital);
    }
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
}
