package com.example.mobptogrammingmidterm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mobptogrammingmidterm.databinding.FragmentFirstBinding
import com.example.mobptogrammingmidterm.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.getSharedPreferences("name", Context.MODE_PRIVATE)
        with(binding) {
            nameET.text = "Hello, ${
                activity?.getSharedPreferences("mySP", Context.MODE_PRIVATE)
                    ?.getString("name", "Your name")
            }"
            backBttn.setOnClickListener {
                it.findNavController().navigate(R.id.firstFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }


}