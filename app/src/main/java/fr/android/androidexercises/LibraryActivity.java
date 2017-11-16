package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity implements ListBookFragment.OnNextListBookListener{

    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout,new ListBookFragment(),ListBookFragment.class.getSimpleName())
                .addToBackStack("ListBookFragment")
                .commit();
    }

    @Override
    public void onNext() {
        // TODO replace Step1Fragment in containerFrameLayout

    }

}
