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
import com.example.mainapp.Adapter.VehicleAdapter
import com.example.mainapp.Model.Result

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

    class Fragment2 : Fragment() {
    private lateinit var viewModel1: VViewModel
    private var param1: String? = null
    private var param2: String? = null
    lateinit var Country1: TextView
    lateinit var Mfr_ID1: TextView
    lateinit var Mfr_CommonName1: TextView
    lateinit var Mfr_Name1: TextView
    lateinit var recycler_view:RecyclerView

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
            viewModel1 = ViewModelProvider(this).get(VViewModel::class.java)
            viewModel1.getCarManufacureList()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = inflater.inflate(R.layout.fragment_2, container, false)
        val receiveData=arguments?.getParcelable<Result>("country")
        if(receiveData!=null){
        with(inflater) {
            Mfr_ID1 = findViewById(R.id.Mfr_ID1)
            Mfr_CommonName1 = findViewById(R.id.Mfr_CommonName1)
            Mfr_Name1= findViewById(R.id.Mfr_Name1)
            Country1 = findViewById(R.id.Country1)
            recycler_view = findViewById(R.id.recycleView2)
            receiveData.apply {
                Country1.text=this.Country
                Mfr_CommonName1.text=this.Mfr_CommonName
                Mfr_ID1.text=this.Mfr_ID.toString()
                Mfr_Name1.text=this.Mfr_Name
                val adapter = VehicleAdapter(this.VehicleTypes)
                recycler_view.adapter = adapter


            }
//            Country1.text=receiveData.Country
        }
        }
        return inflater
    }
    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}