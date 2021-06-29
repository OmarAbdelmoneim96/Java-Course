
package countriesandcities;

import java.util.List;

public interface CountryCsvDao {
    

    public List<Country> readCountryFromCsv(String fileName);
    Country createCountry(String[] metadata);
     
}
