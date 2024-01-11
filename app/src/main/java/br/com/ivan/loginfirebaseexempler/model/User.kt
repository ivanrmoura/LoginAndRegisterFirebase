package br.com.ivan.loginfirebaseexempler.model

import br.com.ivan.loginfirebaseexempler.utils.Constants.Companion.INFO_NOT_SET

data class User(

    var id: String= INFO_NOT_SET,
    val name: String= INFO_NOT_SET,
    val email: String= INFO_NOT_SET,
    var pathImage: String = INFO_NOT_SET
)
