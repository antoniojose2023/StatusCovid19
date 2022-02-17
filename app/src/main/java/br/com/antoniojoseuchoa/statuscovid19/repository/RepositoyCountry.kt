package br.com.antoniojoseuchoa.statuscovid19.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.antoniojoseuchoa.statuscovid19.model.Country
import com.android.volley.Request
import com.android.volley.Response

import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class RepositoyCountry(application: Application) {

    private val queue = Volley.newRequestQueue(application)


    fun getDataCountry(): MutableLiveData<Country>{

        var liveData = MutableLiveData<Country>()

        val request = JsonObjectRequest(Request.Method.GET, BASE_URL, null, Response.Listener {  response ->

            if(response == null)
                return@Listener

            response.getJSONObject("data").also {

                val countrys = it.getString("country")
                val cases = it.getString("cases")
                val confirmed = it.getInt("confirmed")
                val deaths = it.getInt("deaths")
                val recovered = it.getString("recovered")
                val updated_at = it.getString("updated_at")

                val country = Country(countrys, cases, confirmed, deaths, recovered, updated_at)

                liveData.value = country
            }



        }, Response.ErrorListener {  error ->
            Log.e("", "getDataCountry ${error.message}")

        })


        queue.add( request )

        return liveData

    }


    companion object{

        val BASE_URL = "https://covid19-brazil-api.now.sh/api/report/v1/brazil"

    }

}

