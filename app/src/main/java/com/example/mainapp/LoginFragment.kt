package com.example.mainapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carsapp.viewmodal.LoginViewModel



lateinit var Loginviewmodel: LoginViewModel
class LoginFragment : Fragment() {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflatedView = inflater.inflate(R.layout.fragment_login, container, false)
        with(inflatedView) {
            username = findViewById(R.id.username)
            password = findViewById(R.id.password)
            login = findViewById(R.id.login)
        }
        return inflatedView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        Loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        login.setOnClickListener {
            Loginviewmodel.apply {
                val isValid = validateInput(
                    username.text.toString(),
                    password.text.toString()
                )
                if (!isValid) {
                    Toast.makeText(requireContext(), "Please Enter credentials!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    loginUser(
                        username.text.toString(),
                        password.text.toString()
                    )
                }
            }
        }

        Loginviewmodel.liveData.observe(viewLifecycleOwner) { result ->
            if (result) {
                Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    companion object {
//        @JvmStatic
//        fun newInstance() = LoginFragment()
//    }
}