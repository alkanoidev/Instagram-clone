package me.alkanoidev.instagram.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.alkanoidev.instagram.R
import me.alkanoidev.instagram.ui.story.StoryAdapter
import me.alkanoidev.instagram.ui.story.StoryModel

class HomeFragment : Fragment() {
    private var imagesList= mutableListOf<StoryModel>()
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagesList=getImages()
        val recyclerViewStory: RecyclerView = view.findViewById(R.id.recyclerViewStory)
        recyclerViewStory.apply{
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter= StoryAdapter(imagesList)
        }
    }
    private fun getImages(): MutableList<StoryModel>{
        val list= mutableListOf<StoryModel>()

        list.add(StoryModel("https://images.unsplash.com/photo-1537730320042-c212d5ff1a85?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1952&q=80","user1"))
        list.add(StoryModel("https://images.unsplash.com/photo-1497551060073-4c5ab6435f12?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1934&q=80","user2"))
        list.add(StoryModel("https://images.unsplash.com/photo-1600706614696-23774ee2cb18?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80","user3"))
        list.add(StoryModel("https://images.unsplash.com/photo-1549285593-e4d91bc39e62?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1868&q=80","user4"))
        list.add(StoryModel("https://images.unsplash.com/photo-1514136649217-b627b4b9cfb2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=80","user5"))
        list.add(StoryModel("https://images.unsplash.com/photo-1508275759605-a7fb75912353?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=281&q=80","user6"))
        list.add(StoryModel("https://images.unsplash.com/photo-1489980557514-251d61e3eeb6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80","user7"))
        list.add(StoryModel("https://images.unsplash.com/photo-1465406325903-9d93ee82f613?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80","user8"))

        return list
    }
}