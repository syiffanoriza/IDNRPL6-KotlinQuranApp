package com.nori.quranapp.presentation.quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nori.quranapp.R
import com.nori.quranapp.adapter.SurahAdapter
import com.nori.quranapp.databinding.ActivityDetailSurahBinding
import com.nori.quranapp.network.quran.SurahItem

class DetailSurahActivity : AppCompatActivity() {
    private var _binding: ActivityDetailSurahBinding? = null
    private val binding get() = _binding as ActivityDetailSurahBinding

//    private var _surah: Surah? = null
//    private val surah get() = _surah as Surah

//    private var mediaPlayer: MediaPlayer? = null
//    private val mediaPlayer get() = mediaPlayer as MediaPlayer

//    private val quranViewModel: QuranViewModel by viewModels { ViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        _surah = intent.getParcelableExtra(EXTRA_DATA, Surah::class.java)

        initView()

        val mAdapter = SurahAdapter()
        mAdapter.setOnItemClickCallback(object : SurahAdapter.OnItemClickCallback {
            override fun 
        })
    }

    private fun initView() {
        TODO("Not yet implemented")
    }
}