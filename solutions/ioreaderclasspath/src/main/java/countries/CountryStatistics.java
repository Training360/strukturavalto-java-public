package countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {


    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                CountryStatistics.class.getResourceAsStream("/"+fileName)))){

            String line;

            while((line=reader.readLine())!=null){
                String[] temp = line.split(" ");
                Country c = new Country(temp[0],Integer.parseInt(temp[1]));
                countryList.add(c);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }


    public int numberOFCountries(){
        return countryList.size();
    }

    public Country mostBorderCountries(){
        Country max = countryList.get(0);
        for(Country c : countryList){
            if(c.getBorderCountries()>max.getBorderCountries()){
                max=c;
            }
        }
        return max;
    }


    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
