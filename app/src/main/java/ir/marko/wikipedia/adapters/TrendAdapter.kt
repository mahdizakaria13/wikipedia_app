package ir.marko.wikipedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.marko.wikipedia.data.ItemInfo
import ir.marko.wikipedia.databinding.TrendItemBinding
import ir.marko.wikipedia.interfaces.ItemEvents
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: ArrayList<ItemInfo> , val itemEvents: ItemEvents) :
    RecyclerView.Adapter<TrendAdapter.TrendHolder>() {
    lateinit var binding: TrendItemBinding

    inner class TrendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item :ItemInfo) {
            Glide.with(itemView.context)
                .load(item.imgUrl)
                .transform(RoundedCornersTransformation(8, 4))
                .into(binding.imgTrend)
            binding.txtNumOFTrend.text = item.numOfTrend
            binding.txtTitleTrend.text = item.txtTitle
            binding.txtInfoTrend.text = item.txtSubtitle
            binding.txtTrendNumber.text = (adapterPosition + 1).toString()
            itemView.setOnClickListener {
                itemEvents.itemClicked(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendHolder {
        binding = TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
