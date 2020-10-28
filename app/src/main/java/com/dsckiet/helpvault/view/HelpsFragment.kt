package com.dsckiet.helpvault.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dsckiet.helpvault.R
import com.dsckiet.helpvault.databinding.FragmentHelpsBinding

class HelpsFragment : Fragment() {
    private lateinit var binding : FragmentHelpsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_helps, container, false)
        return binding.root
    }
}