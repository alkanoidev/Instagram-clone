package me.alkanoidev.instagram.ui.messages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.alkanoidev.instagram.R

class MessagesListAdapter():
        RecyclerView.Adapter<MessagesListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.message, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("update the ui")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    private fun ImageView.load(imageAddress: String) {
        Glide.with(context)
                .load(imageAddress).apply(RequestOptions().override(110, 110))
                .circleCrop()
                .into(this)
    }
}