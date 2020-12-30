package com.example.projet4anovel_catin.presentation.main

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.projet4anovel_catin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    //TODO Navigate
                        MaterialAlertDialogBuilder(this)
                        .setTitle("OK")
                        .setMessage("Compte reconnu")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    val intent = Intent (this, SecondPage::class.java) // déclaration de l'activity
                    startActivity(intent)// lancement de la nouvelle activity

                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Compte inconnu")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                            login_edit.text?.clear()
                            password_edit.text?.clear()

                        }
                        .show()
            }
                LoginCreate ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle("OK")
                        .setMessage("Vous venez d'ajouter votre nouveau compte")
                        .setPositiveButton("OK"){ dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString())
        }
        create_account_button.setOnClickListener {
            MyCustomDialog().show(supportFragmentManager, "MyCustomFragment")

        }
    }
}
