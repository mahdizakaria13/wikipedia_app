package ir.marko.wikipedia.activities

import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.marko.wikipedia.data.ItemInfo
import ir.marko.wikipedia.databinding.ActivityDetailBinding
import ir.marko.wikipedia.fragments.SEND_DATA_TO_DETAIL_ACTIVITY

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        defaultSetup()
        val dataReceived = intent.getParcelableExtra<ItemInfo>(SEND_DATA_TO_DETAIL_ACTIVITY)
        if (dataReceived != null){
            getData(dataReceived)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun getData(item :ItemInfo) {
        binding.txtTitleDetail.text = item.txtTitle
        binding.txtSubTitleDetail.text = item.txtSubtitle
        binding.txtInfoDetail.text = item.txtInfo
        Glide.with(this)
            .load(item.imgUrl)
            .into(binding.imgSecond)
        binding.fabDetail.setOnClickListener {
            val uriImage = Uri.parse("https://en.wikipedia.org/wiki/${item.txtTitle}")
            val intent = Intent(Intent.ACTION_VIEW  , uriImage)
            startActivity(intent)
        }
    }

    private fun defaultSetup() {
        setSupportActionBar(binding.toolBarSecond)
        binding.collapsSecond.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}