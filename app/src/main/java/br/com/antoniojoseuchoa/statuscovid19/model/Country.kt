package br.com.antoniojoseuchoa.statuscovid19.model

data class Country(
    var country: String,
    var cases: String,
    var confirmed: Int,
    var deaths: Int,
    var recovered: String,
    var date: String) {
}