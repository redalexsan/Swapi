package es.example.ale.swapi.ui;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.example.ale.swapi.R;
import es.example.ale.swapi.ServicioNotificacion;
import es.example.ale.swapi.data.models.SwapiResponse;
import es.example.ale.swapi.data.remote.ApiRetrofit;
import es.example.ale.swapi.data.remote.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private TextView txtData, txtResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        txtData = ViewCompat.requireViewById(getView(),R.id.txtData);
        txtResult = ViewCompat.requireViewById(getView(),R.id.txtResult);
        ViewCompat.requireViewById(getView(),R.id.btnSave).setOnClickListener(v -> ServicioNotificacion.start(requireContext()));
    }

    private void sendRequest() {
        ApiRetrofit apiRetrofit = ApiService.newInstance().getApiRetrofit();
        String data = txtData.getText().toString();
        Call<SwapiResponse> response = apiRetrofit.getPerson(data);

        response.enqueue(new Callback<SwapiResponse>() {
            @Override
            public void onResponse(Call<SwapiResponse> call, Response<SwapiResponse> response) {
                if(response.body() != null && response.isSuccessful()) {
                    txtResult.setText(response.body().getName());
                    ServicioNotificacion.start(requireContext());
                }

            }

            @Override
            public void onFailure(Call<SwapiResponse> call, Throwable t) {
                txtResult.setText("Error");
            }
        });
    }
}
