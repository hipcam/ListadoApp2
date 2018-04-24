package pe.com.alvarado.listadoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.com.alvarado.listadoapp.R;
import pe.com.alvarado.listadoapp.models.User;
import pe.com.alvarado.listadoapp.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;
    private SharedPreferences sharedPreferences;
    private EditText emailInput;
    private EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterUserActivity.class), REGISTER_FORM_REQUEST);
    }
    public void callMain(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = UserRepository.login(email, password);
        if(user == null) {
            Toast.makeText(this, "Correo o contraseña inválidos", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Toast.makeText(this, "Bienvenid@ " + user.getFullname(), Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            boolean success = editor
                    .putString("email", user.getEmail())
                    .putBoolean("está logueado", true)
                    .commit();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        }
}
