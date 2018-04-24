package pe.com.alvarado.listadoapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pe.com.alvarado.listadoapp.R;
import pe.com.alvarado.listadoapp.adapters.ProductAdapter;
import pe.com.alvarado.listadoapp.models.Product;
import pe.com.alvarado.listadoapp.repositories.ProductRepository;

public class MainActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView productsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configure ReciclerView
        productsList = findViewById(R.id.product_list);
        productsList.setLayoutManager(new LinearLayoutManager(this));
        // Set Data Adapter to ReciclerView
        List<Product> products = ProductRepository.list();
        productsList.setAdapter(new ProductAdapter(products));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(MainActivity.this, "Fragment here", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_favorite:
                        Toast.makeText(MainActivity.this, "Another fragment...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_archive:
                        Toast.makeText(MainActivity.this, "Another Fragment...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_logout:
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        Toast.makeText(MainActivity.this, "Vuelva pronto", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterProductActivity.class), REGISTER_FORM_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ProductAdapter adapter = (ProductAdapter) productsList.getAdapter();

        List<Product>  products = ProductRepository.list();
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();

    }

}
