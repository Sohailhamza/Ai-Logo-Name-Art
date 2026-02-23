import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ailogomaker.R // Apna sahi package name check karein
import com.example.ailogomaker.language.LanguageModel

class LanguageAdapter(private val list: List<LanguageModel>) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private var selectedPosition = -1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvLanguage)
        val flag: ImageView = view.findViewById(R.id.ivFlag)
        val layout: ConstraintLayout = view.findViewById(R.id.parentLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.flag.setImageResource(item.flagRes)

        // Selection UI Logic
        if (selectedPosition == position) {
            holder.layout.setBackgroundResource(R.drawable.bg_selected_gradient)
        } else {
            holder.layout.setBackgroundResource(R.drawable.bg_unselected_item)
        }

        holder.itemView.setOnClickListener {
            val previousSelected = selectedPosition
            selectedPosition = holder.bindingAdapterPosition
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)
        }
    }

    override fun getItemCount() = list.size
}