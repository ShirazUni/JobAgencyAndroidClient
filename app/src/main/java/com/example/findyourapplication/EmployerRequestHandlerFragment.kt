package com.example.findyourapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.findyourapplication.databinding.FragmentEmployerRequestHandlerBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EmployerRequestHandlerFragment : Fragment(), EmployerRequestRecyclerAdopter.OnEmployerRequestHandlerItemClickListener {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentEmployerRequestHandlerBinding
    private lateinit var employerRequestHandlerViewModel: EmployerRequestHandlerViewModel
    private lateinit var employerRequestRecyclerAdopter: EmployerRequestRecyclerAdopter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_employer_request_handler, container, false)
        init()
        return binding.root
    }

    private fun init(){
        employerRequestHandlerViewModel= EmployerRequestHandlerViewModel()
        employerRequestRecyclerAdopter= EmployerRequestRecyclerAdopter(this)
        binding.employerRequestHandlerRecyclerView.adapter=employerRequestRecyclerAdopter
        employerRequestHandlerViewModel.getDataForObservation().observe(viewLifecycleOwner,{
            employerRequestRecyclerAdopter.addViewAndSubmitList(it)
        })
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmployerRequestHandlerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onAcceptClick(pos: Int) {

    }

    override fun onRejectClick(pos: Int) {

    }

    override fun onSeeResumeClick(pos: Int) {

    }
}