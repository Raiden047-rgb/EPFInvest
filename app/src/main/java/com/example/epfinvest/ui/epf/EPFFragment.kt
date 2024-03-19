package com.example.epfinvest.ui.epf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.epfinvest.R
import com.example.epfinvest.databinding.FragmentEPFBinding


class EPFFragment : Fragment() {
    private var _binding: FragmentEPFBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEPFBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Write code to handle event here
        binding.buttonDOB.setOnClickListener {
            //Create an instance of DatePickerFragment
            val datePickerFragment = DatePickerFragment()
            val supportFragmentManager = requireActivity().supportFragmentManager
            //Insert Fragment Result Handler
            supportFragmentManager.setFragmentResultListener("REQUEST_DATE", viewLifecycleOwner)
            { resultKey, bundle->
                if(resultKey == "REQUEST_DATE"){
                    val year = bundle.getInt("YEAR")
                    val month = bundle.getInt("MONTH")
                    val day = bundle.getInt("DAY")

                    binding.buttonDOB.text = String.format("%d-%d-%d", day, month, year)

                    //TODO: Calculate the age, determine the basic account balance

                }
            }
            datePickerFragment.show(supportFragmentManager, "REQUEST_DATE")
        }//End of buttonDOB
        binding.buttonCalculate.setOnClickListener {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}