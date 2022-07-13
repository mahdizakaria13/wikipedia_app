package ir.marko.wikipedia.activities


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.snackbar.Snackbar
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import ir.dunijet.animation.ext.BaseActivity
import ir.marko.wikipedia.R
import ir.marko.wikipedia.databinding.ActivityMainBinding
import ir.marko.wikipedia.fragments.FragmentExplore
import ir.marko.wikipedia.fragments.FragmentProfile
import ir.marko.wikipedia.fragments.FragmentTrend
import ir.marko.wikipedia.fragments.FragmentWriter


class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigationViewMain.menu.getItem(3).isChecked = false
        defaultSetup()
        firstRun()
        navigationEvents()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.navigationViewMain.menu.getItem(0).isChecked = false

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_exit -> {
                onBackPressed()
            }
        }
        return true
    }

    private fun defaultSetup() {
        setSupportActionBar(binding.toolBarMain)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun replaceFragment(fragment: Fragment) {
        binding.navigationViewMain.menu.getItem(3).isChecked = false
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container_fragment, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        binding.bottomNavigationMain.setItemSelected(R.id.menu_explore , true)
        replaceFragment(FragmentExplore())
    }

    private fun navigationEvents() {
        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    binding.navigationViewMain.menu.getItem(0).isChecked = true
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_container_fragment, FragmentWriter())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photographer -> {
                   binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translate -> {
                    binding.navigationViewMain.menu.getItem(3).isChecked = true
                    val intent = Intent(this , TranslateActivity ::class.java)
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_video_maker -> {
                     Snackbar.make(binding.root , "You want to be a video maker" , Snackbar.LENGTH_LONG)
                         .setBackgroundTint(ContextCompat.getColor(this , R.color.blue_light))
                         .setAction("Ok"){
                             SweetAlertDialog(this  ,SweetAlertDialog.SUCCESS_TYPE).show()
                         }.setActionTextColor(com.google.android.material.R.attr.colorOnPrimary).show()

                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikipedia -> {
                    val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.wikipedia.org"))
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikimedia -> {
                    val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.wikimedia.org"))
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it) {
                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }
                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }
            }
            binding.navigationViewMain.menu.getItem(0).isChecked = false
            binding.navigationViewMain.menu.getItem(3).isChecked = false
        }
    }
}
