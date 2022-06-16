package ir.marko.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.marko.wikipedia.databinding.FragmentExploreBinding
import ir.marko.wikipedia.databinding.FragmentTrendBinding

class FragmentTrend : Fragment() {
    lateinit var binding :FragmentTrendBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}