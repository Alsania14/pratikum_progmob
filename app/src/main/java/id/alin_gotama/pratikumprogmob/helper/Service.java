package id.alin_gotama.pratikumprogmob.helper;

import java.util.List;

import id.alin_gotama.pratikumprogmob.Model;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    @FormUrlEncoded
    @POST("/api/register")
    Call<ResponseBody> addNewMember(
            @Field("username") String username,
            @Field("password") String password,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("/api/login")
    Call<Model> Login(
            @Field("username") String username,
            @Field("password") String password
    );

}
