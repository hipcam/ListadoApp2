package pe.com.alvarado.listadoapp.adapters;

/**
 * Created by Alumno on 20/04/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.com.alvarado.listadoapp.R;
import pe.com.alvarado.listadoapp.models.Product;
import pe.com.alvarado.listadoapp.models.User;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> products;

    public ProductAdapter(List<Product> products){
        this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView precio;
        public TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name_text);
            precio =  itemView.findViewById(R.id.precio_text);
            desc =  itemView.findViewById(R.id.desc_text);
        }
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder viewHolder, int position) {
        Product product = this.products.get(position);
        viewHolder.name.setText(product.getName());
        viewHolder.precio.setText("$ "+product.getPrecio());
        viewHolder.desc.setText(product.getDesc());

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

}
