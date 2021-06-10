package me.alkanoidev.instagram.ui.post

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.alkanoidev.instagram.R

class PostAdapter(var data: MutableList<PostModel>)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val profilePicture: ImageView
        val username: TextView
        val location: TextView
        val likesTextView: TextView
        val description: TextView
        val comments: TextView
        val descUsername: TextView

        init {
            image=itemView.findViewById(R.id.image)
            profilePicture=itemView.findViewById(R.id.profilePicture)
            username=itemView.findViewById(R.id.username)
            location=itemView.findViewById(R.id.location)
            likesTextView=itemView.findViewById(R.id.likesTextView)
            description=itemView.findViewById(R.id.description)
            comments=itemView.findViewById(R.id.comments)
            descUsername=itemView.findViewById(R.id.desc_username)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val instance: PostModel= data[position]
        holder.image.loadPost(instance.imageUrl)
        holder.profilePicture.load(instance.profilePicture)
        holder.username.text=instance.username
        holder.location.text=instance.location
        holder.likesTextView.text= "Liked by user1 and ${instance.noLikes} others"
        holder.description.text=instance.description
        holder.comments.text="View all ${instance.noComments} comments"
        holder.descUsername.text=instance.username
    }

    override fun getItemCount(): Int {
        return data.size
    }
    private fun ImageView.load(imageAddress: String) {
        Glide.with(context)
                .load(imageAddress)
                .circleCrop()
                .into(this)
    }

    private fun ImageView.loadPost(imageAddress: String){
        Glide.with(context)
                .load(imageAddress)
                .fitCenter()
                .into(this)
    }

}