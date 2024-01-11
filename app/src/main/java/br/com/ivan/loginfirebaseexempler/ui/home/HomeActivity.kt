package br.com.ivan.loginfirebaseexempler.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.com.ivan.loginfirebaseexempler.R
import br.com.ivan.loginfirebaseexempler.databinding.ActivityHomeBinding
import br.com.ivan.loginfirebaseexempler.model.User
import br.com.ivan.loginfirebaseexempler.ui.login.LoginActivity
import br.com.ivan.loginfirebaseexempler.ui.login.LoginViewModel
import br.com.ivan.loginfirebaseexempler.utils.NetworkResult
import br.com.ivan.loginfirebaseexempler.utils.toast
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity (

) : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val loginViewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            loginViewModel.logOut()
        }

        addObservers()

        loginViewModel.getDataUser()
    }

    private fun addObservers(){
        loginViewModel.getDataState.observe(this, Observer { result->
            when(result){
                is NetworkResult.Sucess -> {
                    binding.progressLogin.visibility = View.GONE

                    result.data?.let { user ->
                        updateViews(user)
                    }


                }
                is NetworkResult.Error -> {
                    binding.progressLogin.visibility = View.GONE
                }
                is NetworkResult.Loading -> {
                    binding.progressLogin.visibility = View.VISIBLE
                }
            }
        })


        loginViewModel.logOutState.observe(this, Observer { result->
            when(result){
                is NetworkResult.Sucess -> {
                    binding.progressLogin.visibility = View.GONE
                    toast("Logout realizado com sucesso")
                    openLoginActivity()
                    finish()
                }
                is NetworkResult.Error -> {
                    binding.progressLogin.visibility = View.GONE
                }
                is NetworkResult.Loading -> {
                    binding.progressLogin.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun updateViews(user: User) {

        if (user.pathImage.isNotEmpty()) {

            user.pathImage.let { pathImage ->
                storage.reference.child(pathImage).downloadUrl
                    .addOnSuccessListener {
                        Glide.with(this)
                            .load(it)
                            .fitCenter()
                            .circleCrop()
                            .into(binding.imageUser)
                    }
                    .addOnFailureListener {
                        Log.d("TESTE", it.toString())
                    }
            }
        }

        binding.userName.text = "Name: ${user.name}"

        binding.userEmail.text = "Email: ${user.email}"
    }

    private fun openLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }




}