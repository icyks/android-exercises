package fr.android.keovilay;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dev on 15/11/2017.
 */

public class BookAdaptater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Book> books;
    private final LayoutInflater mLayoutInflater;
    private final ListBookFragment.OnClickBookListener listener;


    public BookAdaptater(LayoutInflater mLayoutInflater, List<Book> books,ListBookFragment.OnClickBookListener listener){
        this.books=books;
        this.mLayoutInflater=mLayoutInflater;
        this.listener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.item_view_book,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ((BookItemView)holder.itemView).bindView(books.get(position),listener);
    }

    @Override
    public long getItemId(int position){
        return books.get(position).hashCode();
    }

    @Override
    public int getItemCount(){
        return books.size();
    }


    public void setBooks(List<Book> books)
    {
        this.books = books;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
