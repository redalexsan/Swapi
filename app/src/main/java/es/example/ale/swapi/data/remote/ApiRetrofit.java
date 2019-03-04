package es.example.ale.swapi.data.remote;

import es.example.ale.swapi.data.models.SwapiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRetrofit {
    @GET("people/{id}")
    Call<SwapiResponse> getPerson(@Path("id") String id);
}
