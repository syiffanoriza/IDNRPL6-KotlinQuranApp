package com.nori.quranapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nori.quranapp.databinding.ItemAyahBinding
import com.nori.quranapp.databinding.ItemSurahBinding
import com.nori.quranapp.network.quran.AyahsItem
import com.nori.quranapp.network.quran.QuranEdition

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {
    private val listAyah = ArrayList<AyahsItem>()
    private val listEdition = ArrayList<QuranEdition>()

    fun setData(dataAyah: List<AyahsItem>?, dataEdition: List<QuranEdition>?){
        if (dataAyah == null || dataEdition == null) return
        listAyah.clear()
        listAyah.addAll(dataAyah)
        listEdition.clear()
        listEdition.addAll(dataEdition)
    }

    class ViewHolder(val binding: ItemAyahBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listAyah.size

    override fun onBindViewHolder(holder: SurahAdapter.ViewHolder, position: Int) {
        val listAyah = listAyah[position]
        val quranAudio = listEdition[1]
        val quranTranslationIndo = listEdition[2]

        holder.binding.apply {
            tvItemAyah.text = listAyah.text
            tvItemNumberAyah.text = listAyah.numberInSurah.toString()
            tvItemTranslation.text = quranTranslationIndo.listAyahs?.get(position)?.text
        }
    }

}