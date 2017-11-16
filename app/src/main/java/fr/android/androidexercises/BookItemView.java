package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dev on 15/11/2017.
 */

public class BookItemView extends LinearLayout{
    private TextView textview;
    private ImageView imageview;

    public BookItemView(Context context) {
        this(context,null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageview = (ImageView) findViewById(R.id.bookImageView);
        textview = (TextView) findViewById(R.id.titleTextView);
    }

    public void bindView(Book book) {
        textview.setText(book.getTitle());
        Glide.with(this)
                .load(book.getCover())
                .into(imageview);
    }
}
