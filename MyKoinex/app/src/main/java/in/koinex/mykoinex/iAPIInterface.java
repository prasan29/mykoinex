package in.koinex.mykoinex;

import in.koinex.mykoinex.POJO.KoinexJSON;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 1130665 on 11/27/2017.
 */

public interface iAPIInterface {
    @GET("ticker")
    Call<KoinexJSON> getResponse();
}
