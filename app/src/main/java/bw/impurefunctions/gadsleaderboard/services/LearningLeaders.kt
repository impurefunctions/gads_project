package bw.impurefunctions.gadsleaderboard.services

import bw.impurefunctions.gadsleaderboard.models.LearnersLeadersInfo
import retrofit2.Call
import retrofit2.http.GET

interface LearningLeaders {
    @get:GET("/api/hours")
    val learners: Call<List<LearnersLeadersInfo?>?>?
}