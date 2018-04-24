package pe.com.alvarado.listadoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.com.alvarado.listadoapp.R;
import pe.com.alvarado.listadoapp.repositories.UserRepository;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.name_input);
        fullnameInput = findViewById(R.id.fullname_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
    }

    public void callRegister(View view){
        String name= nameInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(name.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Tiene que rellenar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }


        UserRepository.create(name, fullname, email, password);
        finish();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

}