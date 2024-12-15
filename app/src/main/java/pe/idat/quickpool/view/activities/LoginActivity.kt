package pe.idat.quickpool.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.idat.quickpool.R
import pe.idat.quickpool.databinding.ActivityLoginBinding
import pe.idat.quickpool.retrofit.response.ResponseLogin
import pe.idat.quickpool.utilitarios.AppMensaje
import pe.idat.quickpool.utilitarios.TipoMensaje
import pe.idat.quickpool.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.btnlogin.setOnClickListener(this)
        binding.btnregistrar.setOnClickListener(this)
        authViewModel.responseLogin.observe(
            this, Observer {
                response -> obtenerDatosLogin(response)
            }
        )
    }

    private fun obtenerDatosLogin(responseLogin: ResponseLogin) {
        if (responseLogin.succes){
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }else{
            AppMensaje.mensaje(binding.root, responseLogin.message, TipoMensaje.ERROR)
        }
        binding.btnlogin.isEnabled = true
        binding.btnregistrar.isEnabled = true
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnlogin -> autenticarUsuario()
            R.id.btnregistrar -> startActivity(Intent(
                applicationContext, RegistroActivity::class.java
            ))
        }
    }
    private fun autenticarUsuario() {
        binding.btnregistrar.isEnabled = false
        binding.btnlogin.isEnabled = false
        if (validarUsuarioPassword()){
            authViewModel.autenticarUsuario(
                binding.etusuario.text.toString(),
                binding.etpassword.text.toString())
        }else{
            AppMensaje.mensaje(binding.root, "Ingrese usuario y/o password", TipoMensaje.ERROR)
            binding.btnregistrar.isEnabled = true
            binding.btnlogin.isEnabled = true
        }
    }
    private fun validarUsuarioPassword(): Boolean {
        var okValidacion = true
        if (binding.etusuario.text.toString().trim().isEmpty()){
            binding.etusuario.isFocusableInTouchMode = true
            binding.etusuario.requestFocus()
            okValidacion = false
        }else if (binding.etpassword.text.toString().trim().isEmpty()){
            binding.etpassword.isFocusableInTouchMode = true
            binding.etpassword.requestFocus()
            okValidacion = false
        }
        return okValidacion
    }
}