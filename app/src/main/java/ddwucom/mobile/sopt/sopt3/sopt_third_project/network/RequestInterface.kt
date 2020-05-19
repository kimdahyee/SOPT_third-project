package ddwucom.mobile.sopt.sopt3.sopt_third_project.network

import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.RequestLogin
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.RequestRegister
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.ResponseLogin
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("user/signin")
    fun requestLogin(@Body body: RequestLogin): Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body: RequestRegister): Call<ResponseRegister>
}