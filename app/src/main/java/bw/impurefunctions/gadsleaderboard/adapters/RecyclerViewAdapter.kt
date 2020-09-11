package bw.impurefunctions.gadsleaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.models.LearnersLeadersInfo
import com.bumptech.glide.Glide

class RecyclerViewAdapter(var context: Context, private val learnersInfo: List<LearnersLeadersInfo>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = learnersInfo[position].badgeUrl
        val studentDetails = learnersInfo[position].hours +
                " learning hours," +
                learnersInfo[position].country
        Glide.with(context)
                .load(imageUrl)
                .into(holder.badge)
        holder.name.text = learnersInfo[position].name
        holder.subtitle.text = studentDetails
    }

    override fun getItemCount(): Int {
        return learnersInfo.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var badge: ImageView = itemView.findViewById(R.id.badge)
        var name: TextView = itemView.findViewById(R.id.name)
        var subtitle: TextView = itemView.findViewById(R.id.subtitle)

    }

}