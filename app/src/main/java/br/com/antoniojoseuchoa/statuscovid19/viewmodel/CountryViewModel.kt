package br.com.antoniojoseuchoa.statuscovid19.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.antoniojoseuchoa.statuscovid19.repository.RepositoyCountry

class CountryViewModel(application: Application) : AndroidViewModel(application) {

      private val repositoyCountry = RepositoyCountry(application)

      fun getDataCountry() = repositoyCountry.getDataCountry()


}