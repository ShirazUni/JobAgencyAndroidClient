package com.example.findyourapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.findyourapplication.databinding.FragmentRequestBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RequestFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentRequestBinding
    private lateinit var requestRecyclerItemViewModel:RequestRecyclerItemViewModel
    private lateinit var requestFragmentAdopter: EmployeeRequestFragmentAdopter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_request, container, false)
        init()
        viewModelObserver()
        return binding.root
    }

    private fun init(){
        requestRecyclerItemViewModel= RequestRecyclerItemViewModel()
        requestFragmentAdopter= EmployeeRequestFragmentAdopter(requireContext(),requestRecyclerItemViewModel)
        binding.employeeRequestRecyclerView.adapter=requestFragmentAdopter
    }

    private fun viewModelObserver(){
        requestRecyclerItemViewModel.getDataForObservation().observe(viewLifecycleOwner,{
            it?.let {
                requestFragmentAdopter.submitList(it)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                RequestFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}