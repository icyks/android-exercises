package fr.android.androidexercises;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity implements ListBookFragment.OnClickBookListener {

    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
            getSupportFragmentManager().beginTransaction()
                .replace(isPortrait() ? R.id.containerFrameLayout : R.id.containerLeftFrameLayout,new ListBookFragment(),ListBookFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onClick(Book book) {
        getIntent().putExtra(BookDescriptionFragment.KEYBOOK,book);
        getSupportFragmentManager().beginTransaction()
                .replace(isPortrait() ? R.id.containerFrameLayout : R.id.containerRightFrameLayout,new BookDescriptionFragment(),BookDescriptionFragment.class.getSimpleName())
                .addToBackStack("BookDescriptionFragment")
                .commit();
     }

     private boolean isPortrait(){
        return this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? true : false;

     }
}
