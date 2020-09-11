package bw.impurefunctions.gadsleaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.models.SkillIQLeadersInfo
import com.bumptech.glide.Glide

class SkillRecyclerViewAdapter // this.imageView = imageView;
(var context: Context, private val learnersInfo: List<SkillIQLeadersInfo>) : RecyclerView.Adapter<SkillRecyclerViewAdapter.ViewHolder>() {

    //ImageView imageView;
    private var view: View? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = learnersInfo[position].badgeUrl
        val studentDetails = learnersInfo[position].score +
                " skill IQ Score, " +
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

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var badge: ImageView
        var name: TextView
        var subtitle: TextView

        init {
            badge = itemView!!.findViewById<View>(R.id.badge) as ImageView
            name = itemView.findViewById<View>(R.id.name) as TextView
            subtitle = itemView.findViewById<View>(R.id.subtitle) as TextView
        }
    }

}