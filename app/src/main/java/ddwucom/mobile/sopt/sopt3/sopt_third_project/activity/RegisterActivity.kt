package ddwucom.mobile.sopt.sopt3.sopt_third_project.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ddwucom.mobile.sopt.sopt3.sopt_third_project.R
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.RequestRegister
import ddwucom.mobile.sopt.sopt3.sopt_third_project.data.ResponseRegister
import ddwucom.mobile.sopt.sopt3.sopt_third_project.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_login2.setOnClickListener {
            when {
                edit_id.text.isNullOrBlank() -> Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
                edit_password.text.isNullOrBlank() -> Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                edit_name.text.isNullOrBlank() -> Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                edit_email.text.isNullOrBlank() -> Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show()
                edit_phone.text.isNullOrBlank() -> Toast.makeText(this, "전화번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                else -> {
                    requestToServer.service.requestRegister(
                        RequestRegister(
                            id = edit_id.text.toString(),
                            password = edit_password.text.toString(),
                            name = edit_name.text.toString(),
                            email = edit_email.text.toString(),
                            phone = edit_phone.text.toString()
                        )
                    ).enqueue(object : retrofit2.Callback<ResponseRegister> {
                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                            //통신 실패
                        }

                        override fun onResponse(
                            call: Call<ResponseRegister>,
                            response: Response<ResponseRegister>
                        ) {
                            //통신 성공
                            if (response.isSuccessful) {//statusCode가 200-300 사이일때 응답 body 이용
                                if (response.body()!!.success) { //ResponseRegister의 success가 true인 경우 -> 회원가입 성공
                                    Toast.makeText(this@RegisterActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                                    val resultIntent = Intent()
                                    resultIntent.putExtra("id", edit_id.text.toString())
                                    resultIntent.putExtra("pw", edit_password.text.toString())
                                    setResult(Activity.RESULT_OK, resultIntent)
                                    finish()
                                } else {
                                    if (response.body()!!.status == 200) {
                                        Toast.makeText(this@RegisterActivity, "존재하는 ID 입니다.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}