package com.example.projet4anovel_catin.presentation.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projet4anovel_catin.R;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondPage extends Activity {

    private static final int REQUEST_CODE = 10;
    //private static final String BASE_URL = "http://list.com/"

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
    }



   /*
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val service = retrofit.create(InterfaceApi::class.java)
    val RestListLoginResponse = service.listLogin()


    RestListLoginResponse.enqueue(object : Callback<List<RestListLoginResponse>> {
        override fun onResponse(call: Call<List<RestListLoginResponse>>,
        response: Response<List<RestListLoginResponse>>) {
            val allCourse = response.body()
            if (allCourse != null) {
                info("HERE is ALL LIST FROM LIST SERVER:")
                for (c in allList)
                    info(" one list : ${c.title} : ${c.time} ")
            }
        }
        override fun onFailure(call: Call<List<RestListLoginResponse>>,
        t: Throwable) {
            error("KO")
        }
    })*/


}
