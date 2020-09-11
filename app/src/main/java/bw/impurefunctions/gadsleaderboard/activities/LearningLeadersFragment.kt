package bw.impurefunctions.gadsleaderboard.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.adapters.RecyclerViewAdapter
import bw.impurefunctions.gadsleaderboard.models.LearnersLeadersInfo
import bw.impurefunctions.gadsleaderboard.services.LearningLeaders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LearningLeadersFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_learning_leaders, container, false)
        val recyclerView: RecyclerView
        recyclerView = view.findViewById(R.id.learning_leaders_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val learningLeadersApi = retrofit.create(LearningLeaders::class.java)
        learningLeadersApi.learners.enqueue(object : Callback<List<LearnersLeadersInfo?>?> {
            override fun onResponse(call: Call<List<LearnersLeadersInfo?>?>, response: Response<List<LearnersLeadersInfo?>?>) {
                recyclerView.adapter = context?.let { RecyclerViewAdapter(it, response.body() as List<LearnersLeadersInfo>) }
            }

            override fun onFailure(call: Call<List<LearnersLeadersInfo?>?>, t: Throwable) {}
        })
        return view
    }

    companion object {
        private const val BASE_URL = "https://gadsapi.herokuapp.com"
    }
}