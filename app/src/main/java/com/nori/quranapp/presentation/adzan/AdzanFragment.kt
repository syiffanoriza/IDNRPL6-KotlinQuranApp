package com.nori.quranapp.presentation.adzan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nori.quranapp.databinding.FragmentAdzanBinding
import com.nori.quranapp.network.Resource
import com.nori.quranapp.presentation.ViewModelFactory

class AdzanFragment : Fragment() {
    private var _binding: FragmentAdzanBinding? = null
    private val binding get() = _binding as FragmentAdzanBinding
    private val adzanViewModel: AdzanViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdzanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adzanViewModel.getDailyAdzanTime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    binding.apply {
                        it.data?.let { adzanDataResult ->
                            tvLocation.text = adzanDataResult.listLocation[1]
                            tvDate.text = adzanDataResult.listCalendar[3]
                        }
                    }
                    when (val adzanTime = it.data?.dailyAdzan) {
                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            binding.apply {
                                adzanTime.data?.let { time ->
                                    tvTimeImsak.text = time.imsak
                                    tvTimeFajr.text = time.fajr
                                    tvTimeZuhr.text = time.zuhr
                                    tvTimeAsr.text = time.asr
                                    tvTimeMaghrib.text = time.maghrib
                                    tvTimeIsha.text = time.isha
                                }
                            }
                        }

                        is Resource.Error -> {
                            Log.e(
                                "AdzanFragment",
                                "Error getting schedule: ${adzanTime.message}"
                            )
                            Toast.makeText(context, "Error: ${adzanTime.message}", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Log.e(
                                "AdzanFragment",
                                "Error getting location: ${it.message}"
                            )
                            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                is Resource.Error -> {
                    Log.e(
                        "AdzanFragment",
                        "Error observing AdzanViewModel: ${it.message}"
                    )
                    Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}