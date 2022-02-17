package br.com.antoniojoseuchoa.statuscovid19.model

data class States(
    var uid: Int,
    var uf: String,
    var state: String,
    var cases: Int,
    var deaths: Int,
    var suspects : Int,
    var refuses: Int,
    var date: String

) {


}