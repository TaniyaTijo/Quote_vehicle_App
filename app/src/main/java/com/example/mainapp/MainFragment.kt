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
import com.example.mainapp.adapter.QuotesAdapter
import com.example.mainapp.model.Result
import com.example.mainapp.viewModel.QuotesViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), QuotesAdapter.ItemClickListener {
    private lateinit var viewModel: QuotesViewModel
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onItemClickListener(clickItem: Result) {
        val detailsFragment = DetailsFragment.newInstance("", "")
        val args = Bundle().apply {
            putParcelable("@string/key", clickItem)
        }
        detailsFragment.arguments = args
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.FragmentContainer, detailsFragment, "Fragment2")
            .commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            val recyclerView: RecyclerView = findViewById(R.id.recycleView)
            val quoteChange: ImageButton = findViewById(R.id.QuoteChange)
            val quoteText: TextView = findViewById(R.id.QuoteText)

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            viewModel = ViewModelProvider(this@MainFragment).get(QuotesViewModel::class.java)
            viewModel.getRandomQuote()
            viewModel.getCarManufacureList()

            quoteChange.setOnClickListener { viewModel.getRandomQuote() }
            viewModel.response.observe(viewLifecycleOwner) { response ->
                quoteText.text = response[0]
            }
            viewModel.list.observe(viewLifecycleOwner) { result ->
                val adapter = QuotesAdapter(result, this@MainFragment)
                recyclerView.adapter = adapter
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
