package ddwucom.mobile.sopt.sopt3.sopt_third_project.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ddwucom.mobile.sopt.sopt3.sopt_third_project.R
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.RequestLogin
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.ResponseLogin
import ddwucom.mobile.sopt.sopt3.sopt_third_project.network.RequestToServer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    val REQ_CODE = 100;
    val requestToServer = RequestToServer //싱글톤 그대로 가지고 옴

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            if (et_id.text.isNullOrBlank() || et_password.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            } else {
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_password.text.toString()
                    ) //로그인 정보를 전달
                ).enqueue(object : Callback<ResponseLogin> { //Callback 등록, Retrofit의 Callback을 import 해줘야 한다
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //통신 실패
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        //통신 성공
                        if (response.isSuccessful) {//statusCode가 200-300 사이일때 응답 body 이용
                            if (response.body()!!.success) { //ResponseLogin의 success가 true인 경우 -> 로그인
                                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this@LoginActivity, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        textView2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            et_id.setText(data!!.getStringExtra("id"))
            et_password.setText(data!!.getStringExtra("pw"))
        }
    }
}