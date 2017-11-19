package fr.android.keovilay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dev on 15/11/2017.
 */

public class ListBookFragment extends Fragment{
    private List<Book> books;
    private OnClickBookListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnClickBookListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_book, container, false);
        this.books = new ArrayList<>();
        RecyclerView recycledView = (RecyclerView) rootView.findViewById(R.id.bookListView);
        recycledView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        final BookAdaptater bookAdaptater = new BookAdaptater(LayoutInflater.from(rootView.getContext()),books, listener );
        recycledView.setAdapter(bookAdaptater);
        retrofitTreatment(bookAdaptater,"http://henri-potier.xebia.fr/");
        return rootView;
    }

    private void retrofitTreatment(final BookAdaptater mAdaptater, String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);
        Call<List<Book>> call = service.listBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                for (Book book : response.body()){
                    books.add(book);
                }
                mAdaptater.setBooks(books);
            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    public interface OnClickBookListener {
        void onClick(Book book);
    }
}
