package ir.marko.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import ir.marko.wikipedia.databinding.ActivityMainBinding
import ir.marko.wikipedia.databinding.FragmentExploreBinding
import ir.marko.wikipedia.fragments.FragmentExplore
import ir.marko.wikipedia.fragments.FragmentProfile
import ir.marko.wikipedia.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        firstRun()
        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    Toast.makeText(this, "You want to ba a writer", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photographer -> {
                    Toast.makeText(this, "You want to ba a photographer", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_translate -> {
                    Toast.makeText(this, "You want to ba a translator", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_video_maker -> {
                    Toast.makeText(this, "You want to ba a video maker", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikipedia -> {
                    Toast.makeText(this, "You want to visit wikipedia", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_wikimedia -> {
                    Toast.makeText(this, "You want to visit wikimedia", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
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
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener { }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container_fragment, fragment)
        transaction.commit()
    }

     fun firstRun() {
       binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
        replaceFragment(FragmentExplore())
    }
}