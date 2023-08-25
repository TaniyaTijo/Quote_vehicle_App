package com.example.mainapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainapp.adapter.VehicleAdapter
import com.example.mainapp.Model.Result

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

    class DetailsFragment : Fragment() {
    private lateinit var viewModel1: VehicleViewModel
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var country1: TextView
    private lateinit var mfrID1: TextView
    private lateinit var mfrCommonName1: TextView
    private lateinit var mfrName1: TextView
    private lateinit var recyclerview:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val recyclerView = view.findViewById<RecyclerView>(R.id.recycleView2)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            viewModel1 = ViewModelProvider(this).get(VehicleViewModel::class.java)
            viewModel1.getCarManufacureList()
        }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val receiveData = arguments?.getParcelable<Result>("@string/key")
            return inflater.inflate(R.layout.fragment_details, container, false)?.apply {
                mfrID1 = findViewById(R.id.Mfr_ID1)
                mfrCommonName1 = findViewById(R.id.Mfr_CommonName1)
                mfrName1 = findViewById(R.id.Mfr_Name1)
                country1 = findViewById(R.id.Country1)
                recyclerview = findViewById(R.id.recycleView2)

                receiveData?.apply {
                    country1.text = this.Country
                    mfrCommonName1.text = this.Mfr_CommonName
                    mfrID1.text = this.Mfr_ID.toString()
                    mfrName1.text = this.Mfr_Name
                    val adapter = VehicleAdapter(this.VehicleTypes)
                    recyclerview.adapter = adapter
                }
            }
        }

        companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}