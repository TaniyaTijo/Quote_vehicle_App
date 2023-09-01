package com.example.mainapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.carsapp.viewmodal.LoginViewModel
import com.example.mainapp.model.Login
import com.google.gson.Gson
import com.example.mainapp.apiInterface.setImage


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class LoginDetailFragment : Fragment() {
    private lateinit var viewModel1: LoginViewModel
    lateinit var sharedPreferences: SharedPreferences
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var id1: TextView
    private lateinit var username1: TextView
    private lateinit var username2: TextView
    private lateinit var email1: TextView
    private lateinit var firstName1: TextView
    private lateinit var lastName1: TextView
    private lateinit var gender1: TextView
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel1 = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel1.getUserDetail()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile_screen, container, false)?.apply {
            id1 = findViewById(R.id.Id1)
            username1 = findViewById(R.id.Username1)
            username2 = findViewById(R.id.Username2)
            email1 = findViewById(R.id.Email1)
            firstName1 = findViewById(R.id.FirstName1)
            lastName1 = findViewById(R.id.LastName1)
            gender1 = findViewById(R.id.Gender1)
            imageView1 = findViewById(R.id.imageView1)
            imageView2 = findViewById(R.id.imageView2)
            sharedPreferences =
                requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val jsonData = sharedPreferences.getString("user_data", null)
            val finaluserData = Gson().fromJson(jsonData, Login::class.java)
            id1.text = finaluserData.id.toString()
            firstName1.text = finaluserData.firstName
            email1.text = finaluserData.email
            lastName1.text = finaluserData.lastName
            gender1.text = finaluserData.gender
            username1.text = finaluserData.username
            username2.text = finaluserData.username
            imageView1.setImage(finaluserData.image)
            imageView2.setImage(finaluserData.image)

        }
    }
}
