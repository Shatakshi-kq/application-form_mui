package com.example.application_form_mui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.application_form_mui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    val list: java.util.ArrayList<String> = ArrayList()
    var gender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener(this)

        binding.radiobutton.setOnCheckedChangeListener(this)

        binding.Coding.setOnCheckedChangeListener(this)
        binding.readingBook.setOnCheckedChangeListener(this)
        binding.movies.setOnCheckedChangeListener(this)
        binding.Playing.setOnCheckedChangeListener(this)
        binding.traveling.setOnCheckedChangeListener(this)
    }

    override fun onClick(view: View?) {

        when(view?.id){

            R.id.submit ->{
                val phone1 = binding.phone1.editableText.toString()
                val phone2 = binding.alPhone.editableText.toString()

                if(binding.firstname.text!!.isEmpty() && binding.lastname.text!!.isEmpty() && binding.phone1.editableText.isEmpty() &&
                        binding.alPhone.editableText.isEmpty() && binding.emailInput.text!!.isEmpty()){
                    binding.firstname.requestFocus()
                    Toast.makeText(this, "Please fill the required information", Toast.LENGTH_SHORT).show()
                }
                else if (binding.firstname.text!!.isEmpty()){
                    binding.firstname.requestFocus()
                    Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show()
                }
                else if (binding.lastname.text!!.isEmpty()){
                    binding.lastname.requestFocus()
                    Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show()
                }
                else if (binding.phone1.editableText.isEmpty()){
                    binding.phone1.requestFocus()
                    Toast.makeText(this, "Please enter your Phone number", Toast.LENGTH_SHORT).show()
                }
                else if (binding.alPhone.editableText.isEmpty()){
                    binding.alPhone.requestFocus()
                    Toast.makeText(this, "Please enter your Alternate Phone number", Toast.LENGTH_SHORT).show()
                }
                else if (binding.emailInput.editableText.isEmpty()){
                    binding.emailInput.requestFocus()
                    Toast.makeText(this, "Please enter your Email Address", Toast.LENGTH_SHORT).show()
                }
                else if(gender == null){
                    Toast.makeText(this, "Please Select the gender", Toast.LENGTH_SHORT).show()
                }
                else if (binding.firstname.text!!.isNotEmpty() && binding.lastname.text!!.isNotEmpty() && binding.phone1.editableText.isNotEmpty() && binding.alPhone.editableText.isNotEmpty() && binding.emailInput.text!!.isNotEmpty() && (phone1==phone2)) {
                    Toast.makeText(this, "Please don't enter the same number", Toast.LENGTH_SHORT).show()
                }
                else{

                    val intent = Intent(this, user_info::class.java)
                    val Firstname = binding.firstname.editableText.toString()
                    val Lastname = binding.lastname.editableText.toString()
                    val phone1 = binding.phone1.editableText.toString()
                    val phone2 = binding.alPhone.editableText.toString()
                    val email = binding.email.editText.toString()
                    val lst = list.toString().replace("["," ").replace("]"," ")


                    intent.putExtra("Firstname", Firstname)
                    intent.putExtra("Lastname", Lastname)
                    intent.putExtra("phone1", phone1)
                    intent.putExtra("phone2", phone2)
                    intent.putExtra("email", email)
                    intent.putExtra("gender", gender)
                    intent.putExtra("hobbies", lst)

                    startActivity(intent)
                }

            }
        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
            R.id.male ->{
                val rbMale = findViewById<RadioButton>(checkedId)
                gender = rbMale.text.toString()
            }

            R.id.female ->{
                val rbFemale = findViewById<RadioButton>(checkedId)
                gender = rbFemale.text.toString()
            }

            R.id.transgender ->{
                val rbTransgender = findViewById<RadioButton>(checkedId)
                gender = rbTransgender.text.toString()
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){

            R.id.Coding ->{
                if (binding.Coding.isChecked){
                    list.add(binding.Coding.text.toString())
                }
                else{
                    list.remove(binding.Coding.text.toString())
                }
            }

            R.id.readingBook ->{
                if (binding.readingBook.isChecked){
                    list.add(binding.readingBook.text.toString())
                }
                else{
                    list.remove(binding.readingBook.text.toString())
                }
            }

            R.id.movies ->{
                if (binding.movies.isChecked){
                    list.add(binding.movies.text.toString())
                }
                else{
                    list.remove(binding.movies.text.toString())
                }
            }

            R.id.Playing ->{
                if (binding.Playing.isChecked){
                    list.add(binding.Playing.text.toString())
                }
                else{
                    list.remove(binding.Playing.text.toString())
                }
            }

            R.id.traveling ->{
                if (binding.traveling.isChecked){
                    list.add(binding.traveling.text.toString())
                }
                else{
                    list.remove(binding.traveling.text.toString())
                }
            }
        }
    }
}