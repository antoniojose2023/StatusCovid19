package br.com.antoniojoseuchoa.statuscovid19.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.antoniojoseuchoa.statuscovid19.repository.RepositoryStates

class StatesViewModel(application: Application): AndroidViewModel(application) {

    private val repositoryStates = RepositoryStates(application)

    fun getDataStates(uf: String) = repositoryStates.getDataStates(uf)

}