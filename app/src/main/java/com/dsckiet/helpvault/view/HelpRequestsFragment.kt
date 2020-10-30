package com.dsckiet.helpvault.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.FragmentHelpRequestsBinding

class HelpRequestsFragment : Fragment() {
    private lateinit var binding : FragmentHelpRequestsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_help_requests, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_helpRequestsFragment_to_helpsFragment)
        }
    }
}