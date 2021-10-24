package com.dsckiet.helpvault.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.FragmentHelpsBinding

class HelpsFragment : Fragment() {
    private lateinit var binding : FragmentHelpsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_helps, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addRequests.setOnClickListener {
            startActivity(Intent(activity, HelpRequestsActivity::class.java))
        }
    }
}