package es.example.ale.swapi.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService instance;
    private ApiRetrofit apiRetrofit;

    public static ApiService newInstance(){
        if(instance == null)
            instance = new ApiService();
        return instance;
    }

    private ApiService(){
        buildApiService();
    }

    private void buildApiService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://swapi.co/apiRetrofit/").addConverterFactory(GsonConverterFactory.create()).build();
        apiRetrofit = retrofit.create(ApiRetrofit.class);
    }

    public ApiRetrofit getApiRetrofit(){
        return apiRetrofit;
    }
}
