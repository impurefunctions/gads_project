package bw.impurefunctions.gadsleaderboard.services

import bw.impurefunctions.gadsleaderboard.models.SkillIQLeadersInfo
import retrofit2.Call
import retrofit2.http.GET

interface SkillIQ {
    @get:GET("/api/skilliq")
    val learners: Call<List<SkillIQLeadersInfo?>?>?
}