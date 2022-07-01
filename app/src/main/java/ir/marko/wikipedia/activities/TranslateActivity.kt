package ir.marko.wikipedia.activities


import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import ir.dunijet.animation.ext.BaseActivity
import ir.marko.wikipedia.R

import ir.marko.wikipedia.databinding.ActivityTranslateBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TranslateActivity : BaseActivity() {
    lateinit var binding: ActivityTranslateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTranslateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        defaultSetup()
        Glide.with(this).load(R.drawable.img_translatore)
            .transform(RoundedCornersTransformation(8, 4)).into(binding.imgTranslator)

    }

    private fun defaultSetup() {
        setSupportActionBar(binding.toolBarTranslator)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true

    }
}