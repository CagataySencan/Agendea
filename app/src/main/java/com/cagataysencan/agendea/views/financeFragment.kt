package com.cagataysencan.agendea.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cagataysencan.agendea.R
import com.cagataysencan.agendea.apiService.repo
import com.cagataysencan.agendea.adapters.financeRecyclerAdapter
import com.cagataysencan.agendea.viewModels.financeViewModel
import com.cagataysencan.agendea.viewModels.financeViewModelFactory
import kotlinx.android.synthetic.main.fragment_finance.*


class financeFragment : Fragment() {

    private lateinit var financeView: financeViewModel
    private lateinit var  recyclerAdapter : financeRecyclerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_finance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_finance.layoutManager = LinearLayoutManager(this.requireContext())



        val repo = repo()
        val viewModelFactory = financeViewModelFactory(repo)
        financeView = ViewModelProvider(this,viewModelFactory).get(financeViewModel::class.java)
        financeView.getCrypto()

        financeView.myResponse.observe(this.viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful) {
                response.body()?.let {
                    println(it[0].logoUrl)
                    println(it[2].logoUrl)

                    recyclerAdapter = financeRecyclerAdapter(it)
                    recycler_view_finance.adapter = recyclerAdapter
                    recyclerAdapter.notifyDataSetChanged()
                }
            }else {
                Toast.makeText(this.requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })


























    }


}