package ir.marko.wikipedia.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.marko.wikipedia.activities.SecondActivity
import ir.marko.wikipedia.data.ItemInfo
import ir.marko.wikipedia.databinding.ExploreItemBinding

class ExploreAdapter(private val data :List<ItemInfo> ,val  sendData: SendDataActivitySecond) :RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding :ExploreItemBinding
    inner class ExploreViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView){
        fun bindData(item :ItemInfo) {
            Glide.with(itemView.context)
                .load(item.imgUrl)
                .into(binding.imgExplore)
            binding.txtTitleExplore.text = item.txtTitle
            binding.txtSubtitleExplore.text = item.txtSubtitle
            binding.txtInfoExplore.text = item.txtInfo
            itemView.setOnClickListener {
                sendData.onClick(item.imgUrl , item.txtTitle , item.txtInfo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ExploreItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
    interface SendDataActivitySecond{
        fun onClick(imgUrl :String , txtTitle :String , txtDetail :String)
    }
}