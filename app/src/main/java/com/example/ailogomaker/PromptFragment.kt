package com.example.ailogomaker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ailogomaker.mainscreen.IdeaAdapter

class PromptFragment : Fragment(R.layout.fragment_prompt) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Back button logic inside fragment
        val btnBack = view.findViewById<ImageView>(R.id.btnBackPrompt)
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }


        // Progress setup
        val progressBar = view.findViewById<ProgressBar>(R.id.stepProgress)
        progressBar.progress = 33 // Step 1 of 3

        // RecyclerView setup
        val rvIdeas = view.findViewById<RecyclerView>(R.id.rvIdeas)

        // Sample list
        val ideas = listOf(
            R.drawable.img_bird_logo,
            R.drawable.ic_logo_to_logo,
            R.drawable.putin_bird,
            R.drawable.img_bird_logo,
            R.drawable.ic_logo_to_logo,
            R.drawable.putin_bird,
            R.drawable.img_bird_logo,
            R.drawable.ic_logo_to_logo,
            R.drawable.putin_bird
        )

        rvIdeas.layoutManager = GridLayoutManager(context, 3)
        rvIdeas.adapter = IdeaAdapter(ideas) { selectedImage ->
            Toast.makeText(context, "Idea selected", Toast.LENGTH_SHORT).show()
        }

        val btnContinue = view.findViewById<Button>(R.id.btnContinue)

        btnContinue.setOnClickListener {

            val styleFragment = StyleFragment()


            val transaction = parentFragmentManager.beginTransaction()

            transaction.replace(R.id.fragment_container_ai, styleFragment)

            transaction.addToBackStack(null)


            transaction.commit()
        }
    }
}