package pe.com.alvarado.listadoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.com.alvarado.listadoapp.R;
import pe.com.alvarado.listadoapp.repositories.ProductRepository;
import pe.com.alvarado.listadoapp.repositories.UserRepository;

public class RegisterProductActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText categoryInput;
    private EditText precioInput;
    private EditText descInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);
        nameInput = findViewById(R.id.name_input);
        categoryInput = findViewById(R.id.cat_input);
        precioInput = findViewById(R.id.precio_input);
        descInput = findViewById(R.id.desc_input);
    }
    public void callRegisterProduct(View view){

        String name= nameInput.getText().toString();
        String category = categoryInput.getText().toString();
        String precio = precioInput.getText().toString();
        String desc = descInput.getText().toString();

        if(name.isEmpty() || category.isEmpty() || precio.isEmpty() || desc.isEmpty()){
            Toast.makeText(this, "Tiene que rellenar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }


        ProductRepository.create(name, category, precio, desc);
        finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
