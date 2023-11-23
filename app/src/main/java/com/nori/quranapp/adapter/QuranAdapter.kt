package com.nori.quranapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nori.quranapp.databinding.ItemSurahBinding
import com.nori.quranapp.network.quran.Surah
import com.nori.quranapp.network.quran.SurahItem
import com.nori.quranapp.presentation.quran.DetailSurahActivity

class QuranAdapter: RecyclerView.Adapter<QuranAdapter.SurahViewHolder>() {
    class SurahViewHolder(val binding: ItemSurahBinding): RecyclerView.ViewHolder(binding.root)
    private val listSurah = ArrayList<Surah>()

    fun setData(list: List<Surah>?){
        if (list == null) return
        listSurah.clear()
        listSurah.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SurahViewHolder (
        ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listSurah.size

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val data = listSurah[position]
        holder.binding.apply {
            tvSurah.text = data.englishName
            val revelationType = data.revelationType
            val numberOfAyahs = data.numberOfAyahs
            val resultOfAyah = "$revelationType - $numberOfAyahs Ayahs"
            tvAyah.text = resultOfAyah
            tvName.text = data.name
            tvNumber.text = data.number.toString()

            this.root.setOnClickListener {
                val intent = Intent(it.context, DetailSurahActivity::class.java)
                intent.putExtra(DetailSurahActivity.EXTRA_DATA, data)
                it.context.startActivity(intent)
            }
        }
    }

}