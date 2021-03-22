package com.naufaldy.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GithubUserAdapter( private val githubUsers: ArrayList<GithubUser>) : RecyclerView.Adapter<GithubUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvUsername : TextView = itemView.findViewById(R.id.tv_github_username)
        var imgPhoto:ImageView = itemView.findViewById(R.id.img_user_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.github_list_menu, parent, false)
                return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val users=githubUsers[position]
                Glide.with(holder.itemView.context)
                        .load(users.photo)
                        .apply(RequestOptions().override(50,70))
                        .into(holder.imgPhoto)

        holder.tvUsername.text = users.name
        holder.itemView.setOnClickListener{
        onItemClickCallback.onItemClicked(githubUsers[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return githubUsers.size
    }
    interface OnItemClickCallback{
    fun onItemClicked(data: GithubUser)
    }
}