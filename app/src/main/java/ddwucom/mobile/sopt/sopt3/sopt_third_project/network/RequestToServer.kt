package ddwucom.mobile.sopt.sopt3.sopt_third_project.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object : 싱글톤, 아무데서나 접근 가능고 객체는 단 하나만
object RequestToServer{ //interface 구현체
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        //json데이터를 데이터 클래스로 변환 쉽게 해준다
        .build()

    var service : RequestInterface = retrofit.create(RequestInterface::class.java)
    //retrofit 객체 create 호출 , interface 클래스 타입을 넘겨 실제 구현체를 만들어준다
}