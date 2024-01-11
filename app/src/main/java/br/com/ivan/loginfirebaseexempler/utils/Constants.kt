package br.com.ivan.loginfirebaseexempler.utils

class Constants {

    companion object{
        const val URL_BASE_API = "https://api.themoviedb.org/3/"
        const val API_KEY = "774c61c65029ce18557375f751ca79b0"
        const val URL_BASE_IMAGE = "https://image.tmdb.org/t/p/w220_and_h330_face/"
        const val URL_BASE_YOUTUBE = "https://www.youtube.com/watch?v="
        const val URL_BASE_VIMEO = "https://vimeo.com/"

        const val POPULAR_FILMES = "POPULAR_FILMES"
        const val TOP_RATED_FILMES = "TOP_RATED_FILMES"

        const val VALUE_REQUIRED = "Campo necesario"
        const val EMAIL_ALREADY_EXISTS : String = "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account."

        const val INFO_NOT_SET = ""
        const val USER_NOT_LOGGED = "user_not_logged"
        const val USERS_COLLECTION = "users"
        var USER_LOGGED_IN_ID = USER_NOT_LOGGED
    }

}