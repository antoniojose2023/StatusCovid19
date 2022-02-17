package br.com.antoniojoseuchoa.statuscovid19.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.antoniojoseuchoa.statuscovid19.model.Country
import br.com.antoniojoseuchoa.statuscovid19.model.States
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RepositoryStates(application: Application) {

    private val queue = Volley.newRequestQueue(application)

    fun getDataStates(states: String): MutableLiveData<States> {

        var liveData = MutableLiveData<States>()


        val request = JsonObjectRequest(Request.Method.GET, BASE_URL+states, null, Response.Listener { response ->

            if(response == null)
                return@Listener

            val uid = response.getInt("uid")
            val uf = response.getString("uf")
            val state = response.getString("state")
            val cases = response.getInt("cases")
            val deaths = response.getInt("deaths")
            val suspects = response.getInt("suspects")
            val refuses = response.getInt("refuses")
            val datetime = response.getString("datetime")

            val states = States(uid, uf, state, cases, deaths, suspects, refuses, datetime)
            liveData.value = states

        }, Response.ErrorListener { error ->
            Log.e("", "getDataStates ${error.message}")

        })


        queue.add( request )

        return liveData

    }


    companion object{

        val BASE_URL = "https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/"

    }

}