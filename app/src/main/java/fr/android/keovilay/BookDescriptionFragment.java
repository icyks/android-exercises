package fr.android.keovilay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by dev on 16/11/2017.
 */

public class BookDescriptionFragment extends Fragment {
    private Book book;
    private TextView textView;
    private ImageView imageView;
    public final static String KEYBOOK="book";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_book, container, false);
        imageView = view.findViewById(R.id.bookDescriptionImageView);
        textView = view.findViewById(R.id.descriptionTextView);
        book = (Book) getActivity().getIntent().getParcelableExtra(KEYBOOK);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String texte = book.getSynopsis().length!=0 ? book.getSynopsis()[0] : "No sypnosis available for "+book.getTitle();
        this.textView.setText(texte);
        Glide.with(this)
                .load(book.getCover())
                .into(imageView);
    }
}
