package com.example.ailogomaker.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ailogomaker.R

class OnboardingAdapter(private val onboardingList: List<OnboardingModel>) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivOnboarding: ImageView = view.findViewById(R.id.ivOnboarding)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDesc: TextView = view.findViewById(R.id.tvDesc)

        fun bind(onboardingModel: OnboardingModel) {
            ivOnboarding.setImageResource(onboardingModel.imageRes)
            tvTitle.text = onboardingModel.title
            tvDesc.text = onboardingModel.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_onboarding,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(onboardingList[position])
    }

    override fun getItemCount(): Int = onboardingList.size
}