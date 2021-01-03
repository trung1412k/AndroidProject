package com.example.android_lession03_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android_lession03_retrofit.adapters.ProductAdapter;
import com.example.android_lession03_retrofit.models.Product;
import com.example.android_lession03_retrofit.responses.ListProductResponse;
import com.example.android_lession03_retrofit.service.SOService;
import com.example.android_lession03_retrofit.utils.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    RecyclerView rv_answer;
    ProgressBar pb_home;

    ProductAdapter mAdapter;
    SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getSOService();
        rv_answer = findViewById(R.id.rv_answer);
        pb_home = findViewById(R.id.pb_home);

        mAdapter = new ProductAdapter(this, new ArrayList<Product>(0), new ProductAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_answer.setLayoutManager(layoutManager);
        rv_answer.setAdapter(mAdapter);
        rv_answer.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv_answer.addItemDecoration(itemDecoration);

        loadProducts();
    }

    public void loadProducts() {
        mService.getProducts().enqueue(new Callback<ListProductResponse>() {

            @Override
            public void onResponse(Call<ListProductResponse> call, Response<ListProductResponse> response) {
                if (response.isSuccessful()) {
                    pb_home.setVisibility(View.GONE);
                    mAdapter.updateProducts(response.body().listProduct);

                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<ListProductResponse> call, Throwable t) {
                pb_home.setVisibility(View.GONE);
                Log.d("MainActivity", "error loading from API" + t.toString());
            }
        });
    }

}