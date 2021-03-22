package com.naufaldy.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naufaldy.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GithubUserAdapter.OnItemClickCallback {
    private lateinit var rvUsers: RecyclerView
    private var users:ArrayList<GithubUser> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        users.addAll(UserData.listdata)
        showRecyclerList()
    }
    private fun showRecyclerList(){
        rvUsers.layoutManager  = LinearLayoutManager(this)
        val githubUserAdapter = GithubUserAdapter(users)
        rvUsers.adapter = githubUserAdapter

        githubUserAdapter.setOnItemClickCallback(this)
    }

    override fun onItemClicked(data: GithubUser){
        val moveUser =Intent(this@MainActivity, GithubUserDetail::class.java)
        moveUser.putExtra(GithubUserDetail.EXTRA_USERNAME, data.username)
        moveUser.putExtra(GithubUserDetail.EXTRA_NAME, data.name)
        moveUser.putExtra(GithubUserDetail.EXTRA_PHOTO,data.photo)
        startActivity(moveUser)
    }
}