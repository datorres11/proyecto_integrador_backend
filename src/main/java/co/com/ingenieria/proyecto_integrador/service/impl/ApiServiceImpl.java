package co.com.ingenieria.proyecto_integrador.service.impl;


import co.com.ingenieria.proyecto_integrador.service.IApiService;
import co.com.ingenieria.proyecto_integrador.service.IHumidityService;
import co.com.ingenieria.proyecto_integrador.service.ITemperatureService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApiServiceImpl implements IApiService {

    @Autowired
    IHumidityService iHumidityService;

    @Autowired
    ITemperatureService iTemperatureService;

    @Override
    public void getHumidityAndTemperatureApi(String city) {
        String API_KEY="4fb0fa5b3a3c6daac1d4563a44d914c6";
        String API_URL="http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+API_KEY;
        try{
            StringBuilder result= new StringBuilder();
            URL url = new URL(API_URL);
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String data;
            while((data = reader.readLine())!=null){
                result.append(data);
            }
            reader.close();

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

            iTemperatureService.createTemperatures(mainMap.get("temp").toString(),city);
            iHumidityService.createHumidity(mainMap.get("humidity").toString(),city);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Map<String, Object> jsonToMap(String dataAttribue){
        Map<String,Object> mapData= new Gson().fromJson(
                dataAttribue,new TypeToken<HashMap<String,Object>>() {}.getType()
        );
        return mapData;
    }
}
