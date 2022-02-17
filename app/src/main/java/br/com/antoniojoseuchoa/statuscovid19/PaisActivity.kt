package br.com.antoniojoseuchoa.statuscovid19

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer

import br.com.antoniojoseuchoa.statuscovid19.viewmodel.CountryViewModel

class PaisActivity : AppCompatActivity() {

    lateinit var tv_cases: TextView
    lateinit var tv_confirmed: TextView
    lateinit var tv_deaths: TextView
    lateinit var tv_country: TextView
    lateinit var tv_recovered: TextView
    lateinit var tv_date: TextView


    private val countryViewModel by viewModels<CountryViewModel>()

    private lateinit var toolbar: Toolbar

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar( toolbar )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        tv_cases = findViewById(R.id.tv_cases)
        tv_confirmed = findViewById(R.id.tv_confirmed)
        tv_deaths = findViewById(R.id.tv_deaths)
        tv_country = findViewById(R.id.tv_country)
        tv_recovered= findViewById(R.id.tv_recovered)
        tv_date = findViewById(R.id.tv_date)

        countryViewModel.getDataCountry().observe(this, Observer { country ->

                tv_country.text = country.country
                tv_cases.text = "Casos :  ${country.cases}"
                tv_confirmed.text = "Confirmados :  ${country.confirmed}"
                tv_deaths.text = "Mortes :  ${country.deaths}"
                tv_recovered.text = "Recuperados :  ${country.recovered}"
                tv_date.text = "Data :  ${country.date}"


        })



    }


    override fun onNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}