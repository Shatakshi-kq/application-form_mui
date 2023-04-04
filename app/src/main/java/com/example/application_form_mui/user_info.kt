package com.example.application_form_mui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_form_mui.databinding.ActivityUserInfoBinding

class user_info : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Firstname = intent.getStringExtra("Firstname")
        val Lastname = intent.getStringExtra("Lastname")
        val phone1 = intent.getStringExtra("phone1")
        val phone2 = intent.getStringExtra("phone2")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val hobbies = intent.getStringExtra("hobbies")
        binding.information.text = "Name:- $Firstname $Lastname \n Phone No:- $phone1 \n Alternate Phone No:- $phone2 \n Email Address:- $email \n Gender:- $gender \n Hobbies:- $hobbies"
    }
}