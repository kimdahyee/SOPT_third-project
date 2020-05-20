package ddwucom.mobile.sopt.sopt3.sopt_third_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwucom.mobile.sopt.sopt3.sopt_third_project.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_go.setOnClickListener {
            val intent1 = Intent(this, LoginActivity::class.java)
            startActivity(intent1)
        }

        button_insta.setOnClickListener {
            val intent2 = Intent(this, InstaActivity::class.java)
            startActivity(intent2)
        }
    }
}
