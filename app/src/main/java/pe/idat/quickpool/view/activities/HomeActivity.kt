package pe.idat.quickpool.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.idat.quickpool.R
import pe.idat.quickpool.databinding.ActivityHomeBinding
import pe.idat.quickpool.viewmodel.ClienteViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var clienteViewModel: ClienteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clienteViewModel = ViewModelProvider(this).get(ClienteViewModel::class.java)

        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        mostrarInfoLogin()
    }

    private fun mostrarInfoLogin() {
        val tvnomape: TextView = binding.navView
            .getHeaderView(0)
            .findViewById(R.id.tvheadernomapecliente)
        val tvemail: TextView = binding.navView
            .getHeaderView(0)
            .findViewById(R.id.tvheaderemailcliente)
        clienteViewModel.obtener().observe(this, Observer {
            obj ->
            obj?.let {
                tvnomape.text = "${obj.nombres} ${obj.apellidos}"
                tvemail.text = obj.email
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idItem = item.itemId
        if (idItem == R.id.action_settings){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}