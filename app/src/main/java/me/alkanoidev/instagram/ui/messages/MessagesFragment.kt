package me.alkanoidev.instagram.ui.messages

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import me.alkanoidev.instagram.R

class MessagesFragment : Fragment(R.layout.fragment_messages) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)
        val backButton:ImageButton = view.findViewById(R.id.imageButton11)

        val navController = findNavController()
        backButton.setOnClickListener { navController.navigate(R.id.action_messagesFragment_to_homeFragment) }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}