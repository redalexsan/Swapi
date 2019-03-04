package es.example.ale.swapi;

import androidx.appcompat.app.AppCompatActivity;
import es.example.ale.swapi.ui.MainFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.flActivity,new MainFragment()).commit();
        }
    }
}
