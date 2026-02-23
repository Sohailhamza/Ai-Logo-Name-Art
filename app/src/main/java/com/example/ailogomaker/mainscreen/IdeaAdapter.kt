package com.example.ailogomaker.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ailogomaker.R

class IdeaAdapter(private val ideaList: List<Int>, private val onIdeaClick: (Int) -> Unit) :
    RecyclerView.Adapter<IdeaAdapter.IdeaViewHolder>() {

    class IdeaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIdea: ImageView = view.findViewById(R.id.ivIdeaImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo_idea, parent, false)
        return IdeaViewHolder(view)
    }

    override fun onBindViewHolder(holder: IdeaViewHolder, position: Int) {
        holder.ivIdea.setImageResource(ideaList[position])
        holder.itemView.setOnClickListener { onIdeaClick(ideaList[position]) }
    }

    override fun getItemCount() = ideaList.size
}