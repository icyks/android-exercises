package fr.android.keovilay;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity implements ListBookFragment.OnClickBookListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        boolean isPortrait = isPortrait();
        getSupportFragmentManager().beginTransaction()
                .replace(isPortrait ? R.id.containerFrameLayout : R.id.containerLeftFrameLayout, new ListBookFragment(), ListBookFragment.class.getSimpleName())
                .commit();

        if(!isPortrait) {
            BookDescriptionFragment bookDescriptionFragment = (BookDescriptionFragment) getSupportFragmentManager()
                    .findFragmentByTag(BookDescriptionFragment.class.getSimpleName());
            if(bookDescriptionFragment != null) {
                getSupportFragmentManager().beginTransaction().remove(bookDescriptionFragment).commit();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerRightFrameLayout, new BookDescriptionFragment(),BookDescriptionFragment.class.getSimpleName())
                        .commit();
            }
        }
    }

    @Override
    public void onClick(Book book) {
        getIntent().putExtra(BookDescriptionFragment.KEYBOOK, book);
        BookDescriptionFragment bookDescriptionFragment = new BookDescriptionFragment();
        if (isPortrait()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout,bookDescriptionFragment,BookDescriptionFragment.class.getSimpleName())
                    .addToBackStack("BookDescriptionFragment")
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerRightFrameLayout,bookDescriptionFragment,BookDescriptionFragment.class.getSimpleName())
                    .commit();
        }

     }

     private boolean isPortrait(){
        return this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? true : false;
     }

}
