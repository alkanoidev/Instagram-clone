package me.alkanoidev.instagram.ui.story

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.alkanoidev.instagram.R


class StoryAdapter(var imageList: MutableList<StoryModel>):RecyclerView.Adapter<StoryAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val textView: TextView

        init {
            imageView=itemView.findViewById(R.id.story_image_view)
            textView=itemView.findViewById(R.id.story_name)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.story, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
        holder.imageView.load(imageList[position].url)
        holder.textView.text=imageList[position].name
    }
    private fun ImageView.load(imageAddress: String) {
        Glide
                .with(context)
                .load(imageAddress).apply(RequestOptions().override(110, 110))
                .circleCrop()
                .into(this)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}