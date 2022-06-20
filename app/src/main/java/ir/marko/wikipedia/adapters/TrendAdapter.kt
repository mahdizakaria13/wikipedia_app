package ir.marko.wikipedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.marko.wikipedia.data.ItemInfo
import ir.marko.wikipedia.databinding.TrendItemBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: ArrayList<ItemInfo>) :
    RecyclerView.Adapter<TrendAdapter.TrendHolder>() {
    lateinit var binding: TrendItemBinding

    inner class TrendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(position: Int) {
            Glide.with(itemView.context)
                .load(data[position].imgUrl)
                .transform(RoundedCornersTransformation(8, 4))
                .into(binding.imgTrend)
            binding.txtNumOFTrend.text = data[position].numOfTrend
            binding.txtTitleTrend.text = data[position].txtTitle
            binding.txtInfoTrend.text = data[position].txtSubtitle
            binding.txtTrendNumber.text = (adapterPosition + 1).toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendHolder {
        binding = TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
