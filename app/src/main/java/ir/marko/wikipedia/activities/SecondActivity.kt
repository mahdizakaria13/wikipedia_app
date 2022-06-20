package ir.marko.wikipedia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.marko.wikipedia.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding :ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarSecond)
        binding.collapsSecond.setExpandedTitleColor(ContextCompat.getColor(this , android.R.color.transparent))
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        getData()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return true
    }
    fun getData(){
        val imgUrl = intent.getStringExtra("SEND_IMAGE_URL")
        val txtTitle = intent.getStringExtra("SEND_TEXT_TITLE")
        val txtInfo = intent.getStringExtra("SEND_TEXT_DETAIL")
        Glide.with(this)
            .load(imgUrl)
            .into(binding.imgSecond)
        binding.txtTitle.text = txtTitle
        binding.txtDetails.text = txtInfo
    }

}