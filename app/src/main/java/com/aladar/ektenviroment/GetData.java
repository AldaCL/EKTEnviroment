package com.aladar.ektenviroment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
//Especifica el tipo de request y obtiene la URL relativa
    @GET("/users")
    Call<List<RetroUsers>>getAllUsers();

}
