package com.informatika19100092databarang

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var sessionPreferences: SessionPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_register)
        btn_submit.setOnClickListener {
            val userName = et_username.text.toString()
            val password = et_password.text.toString()
            if (userName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "from tidak boleh kosong!", Toast.LENGTH_LONG).show()
            } else {
                actionData(userName, password)
            }
        }
        btn_clean.setOnClickListener {
            formClear()
        }
        tv_disini.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    fun actionData(userName: String, password: String) {
        koneksi.service.register(userName, password).enqueue(object : Callback<ResponseAdmin> {
            override fun onFailure(call: Call<ResponseAdmin>, t: Throwable) {
                Log.d("pesan1", t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseAdmin>, response: Response<ResponseAdmin>) {
                if (response.isSuccessful) {
                    val resbody = response.body()
                    val resstatus = resbody?.status
                    val resUserName = resbody?.data?.get(0)?.et_username
                    Log.d("pesan", resUserName.toString())
                    if (resstatus == true) {
                        sessionPreferences = SessionPreferences(this@RegisterActivity)
                        sessionPreferences.actionLogin(resUserName.toString())
                        val i = Intent(this@RegisterActivity, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    } else if (resstatus == false) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Username atau Password anda salah", Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        })
    }

    fun formClear() {
        et_username.text.clear()
        et_password.text.clear()
    }

}
}