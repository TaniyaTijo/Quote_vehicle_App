package com.example.mainapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainapp.Adapter.QAdapter
import com.example.mainapp.Model.Result
import com.example.mainapp.viewModel.QViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(),QAdapter.ItemClickListener {
    private lateinit var viewModel: QViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun OnItemClickListener(clickItem:Result){
        val Fragment2=Fragment2.newInstance("","")
        val args = Bundle()
        args?.apply {
            putParcelable("country",clickItem)
        }
        Fragment2.arguments=args
        parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.FragmentContainer,Fragment2,"Fragment2").commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel= ViewModelProvider(this).get(QViewModel::class.java)
        val QuoteChange: ImageButton =view.findViewById(R.id.QuoteChange)
        viewModel.getCarManufacureList()
        val QuoteText: TextView =view.findViewById(R.id.QuoteText)
        QuoteChange.setOnClickListener { viewModel.getRandomQuote() }
        viewModel.response.observe(viewLifecycleOwner){
            response->QuoteText.text=response[0]
        }
        viewModel.list.observe(viewLifecycleOwner){
            result ->
            val adapter= QAdapter(result,this)
            recyclerView.adapter = adapter
        }
    }
    companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}