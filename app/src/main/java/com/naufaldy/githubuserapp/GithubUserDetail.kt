package com.naufaldy.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.TextureView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class GithubUserDetail : AppCompatActivity() {

    companion object{
    const val EXTRA_USERNAME = "extra username"
    const val EXTRA_NAME = "extra name"
    const val EXTRA_PHOTO = "extra photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user_detail)

        val usernameReceived: TextView = findViewById(R.id.ln_username)
        val nameReceived: TextView = findViewById(R.id.ln_name)
        val photoReceived: CircleImageView = findViewById(R.id.profile_picture)

        val username =intent.getStringExtra(EXTRA_USERNAME)
        val name =intent.getStringExtra(EXTRA_NAME)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        val textu ="Username: $username"
        val textn ="Name: $name"

        usernameReceived.text = textu
        nameReceived.text = textn
        Glide.with(this)
                .load(photo)
                .apply(RequestOptions().override(70,100))
                .into(photoReceived)
    }
}