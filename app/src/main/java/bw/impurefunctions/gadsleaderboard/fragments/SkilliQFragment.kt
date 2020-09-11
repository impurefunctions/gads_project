package bw.impurefunctions.gadsleaderboard.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bw.impurefunctions.gadsleaderboard.R
import bw.impurefunctions.gadsleaderboard.adapters.SkillRecyclerViewAdapter
import bw.impurefunctions.gadsleaderboard.models.SkillIQLeadersInfo
import bw.impurefunctions.gadsleaderboard.services.SkillIQ
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SkilliQFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skill_iq, container, false)
        val recyclerView: RecyclerView
        recyclerView = view.findViewById(R.id.learning_skill_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val skilliqLeadersApi = retrofit.create(SkillIQ::class.java)
        skilliqLeadersApi.learners.enqueue(object : Callback<List<SkillIQLeadersInfo?>> {
            override fun onResponse(call: Call<List<SkillIQLeadersInfo?>>, response: Response<List<SkillIQLeadersInfo?>>) {
                Log.e("response", response.body().toString())
                recyclerView.adapter = SkillRecyclerViewAdapter(context!!, response.body() as List<SkillIQLeadersInfo>)
            }

            override fun onFailure(call: Call<List<SkillIQLeadersInfo?>>, t: Throwable) {}
        })
        return view
    }

    companion object {
        private const val BASE_URL = "https://gadsapi.herokuapp.com"
    }
}