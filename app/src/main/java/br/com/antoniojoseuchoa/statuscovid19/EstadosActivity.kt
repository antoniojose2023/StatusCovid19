package br.com.antoniojoseuchoa.statuscovid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import br.com.antoniojoseuchoa.statuscovid19.viewmodel.StatesViewModel

class EstadosActivity : AppCompatActivity() {

    lateinit var uf: TextView
    lateinit var state: TextView
    lateinit var cases: TextView
    lateinit var deaths: TextView
    lateinit var suspects: TextView
    lateinit var refuses: TextView
    lateinit var datetime: TextView

    lateinit var button: Button
    lateinit var ed_pesquisa: EditText

    private val statesViewModel by viewModels<StatesViewModel>()

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estados)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar( toolbar )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ed_pesquisa = findViewById(R.id.edit_sigla_pesquisa)

        uf = findViewById(R.id.tv_uf_state)
        state = findViewById(R.id.tv_state)
        cases = findViewById(R.id.tv_cases_state)
        deaths = findViewById(R.id.tv_deaths_state)
        suspects = findViewById(R.id.tv_suspects_state)
        refuses = findViewById(R.id.tv_refuses_state)
        datetime = findViewById(R.id.tv_date_states)


        button = findViewById(R.id.button_pesquisa)
        button.setOnClickListener {

            var ufs = ed_pesquisa.text.toString()

            statesViewModel.getDataStates(ufs).observe(this, Observer {  states ->

                uf.text = "UF : ${states.uf}"
                state.text = "Estado : ${states.state}"
                cases.text = "Casos : ${states.cases}"
                deaths.text = "Mortes : ${states.deaths}"
                suspects.text = "Suspeitos : ${states.suspects}"
                refuses.text = "Recusados : ${states.refuses}"
                datetime.text = "Data : ${states.date}"

            })

        }


    }

    override fun onNavigateUp(): Boolean {
        onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        return true
    }
}