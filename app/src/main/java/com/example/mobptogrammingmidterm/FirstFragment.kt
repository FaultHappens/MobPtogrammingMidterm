package com.example.mobptogrammingmidterm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mobptogrammingmidterm.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            nextIV.setOnClickListener {
                if (nameET.text.toString().isNotEmpty()) {
                    activity?.getSharedPreferences("mySP", Context.MODE_PRIVATE)?.edit()
                        ?.putString("name", nameET.text.toString())?.apply()
                }
                it.findNavController().navigate(R.id.secondFragment)
            }
            profileIV.setOnClickListener {
                it.findNavController().navigate(R.id.secondFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

}