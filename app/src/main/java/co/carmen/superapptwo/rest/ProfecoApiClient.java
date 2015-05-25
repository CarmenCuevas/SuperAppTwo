package co.carmen.superapptwo.rest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.carmen.superapptwo.rest.models.ProductListResponse;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Alfredo on 21/05/2015.
 */
public class ProfecoApiClient {
    private ProfecoApiService apiService;
    private Context context;

    private static ProfecoApiClient API_CLIENT;

    public static ProfecoApiClient getInstance(Context context) {
        //Singleton Pattern
        if(API_CLIENT == null)
            API_CLIENT = new ProfecoApiClient(context);

        return API_CLIENT;
    }

    private ProfecoApiClient(Context context) {
        this.context = context;

        //Build the response parser
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(ProductListResponse.class , new ProductListResponseDeserializer())
                .registerTypeAdapter(ProductListResponse.class, new ProductListResponseDeserializer())
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        //Retrofit adapter to make requests
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setEndpoint(Constants.MAIN_URL)
                .setConverter(new GsonConverter(gsonConf))
                .build();

        apiService = restAdapter.create(ProfecoApiService.class);
    }
}
