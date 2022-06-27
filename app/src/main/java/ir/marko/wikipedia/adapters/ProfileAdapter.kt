package ir.marko.wikipedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.marko.wikipedia.data.ItemInfo
import ir.marko.wikipedia.databinding.ProfileItemBinding
import ir.marko.wikipedia.interfaces.ItemEvents
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class ProfileAdapter(private val dataList: ArrayList<ItemInfo> , val itemEvents: ItemEvents) :
    RecyclerView.Adapter<ProfileAdapter.ProfileItemHolder>() {
    lateinit var binding: ProfileItemBinding

    inner class ProfileItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: ItemInfo) {
            binding.txtTitle.text = item.txtTitle
            binding.txtSubtitle.text = item.txtSubtitle
            Glide.with(itemView.context).load(item.imgUrl)
                .transform(RoundedCornersTransformation(8, 4)).into(binding.imgMain)
            itemView.setOnClickListener {
                itemEvents.itemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileItemHolder {
        binding = ProfileItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileItemHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ProfileItemHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}