        
package countriesandcities;

import java.util.List;

public interface CityCsvDao {
    
    public List<City> readCityFromCsv(String fileName);
    City createCity(String[] metadata);
    
    
}
