package com.s300299315.wordgame2;

//19 Import some class


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

//18) This class will be used to create List using a recyclerview
//18-1 extends RecyclerView.ViewHolder
//18-2 Delete RecyclerView.ViewHolder and extends ListAdapter
//13-3 and Add the class WordViewHolder extends Recyclerview.ViewHolder
//15 implement method for ListAdapter
public class WordListAdapter extends ListAdapter<Word, WordListAdapter.WordViewHolder> {

    //20 Get the DB class
    DBOpenHelper mDb;

    //19 Create constructor to fix the error in the public class line and parse the database because this Adapter will be deal with database
    protected WordListAdapter(DBOpenHelper db,
                              @NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
        //21 set the mDb with db
        mDb = db;
    }

    /*
    * THose 3 #@Override method need to use when we create list using a recycler view
    * */

    @NonNull
    @Override // THis method will be called when entire recyclerview set up to show up the list
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        return new WordViewHolder(view);
    }

    @Override // This method will be called to how to create single list item
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        //24) get the single data using a query based on the position
        Word current = mDb.query(position);
        //25) after get the query result, bind to put the WordViewHolder using a holder
        holder.bind(current);
    }

    //23) import the method using a ctrl+O to get the getItemCount()
    @Override
    public int getItemCount() {
        // using a mDb's count method
        return (int) mDb.count();
    }

    //22) When we use a list we have to specify how to define the list
    //Basically the list uses this WordDIff class, to judge 2 items equal or not
    static class WordDiff extends DiffUtil.ItemCallback<Word> {

        @Override
        public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }

    //14) create class WordViewHolder
    class WordViewHolder extends RecyclerView.ViewHolder {


        //15) Each list item
        private Word mWord;
        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            //16) Initialize textView template to hold item
            wordItemView = itemView.findViewById(R.id.textView);
            //17) set on the click listener in the wordItemView
            wordItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //32) set the delete function in DB
                    mDb.delete(mWord.getId());
                    //33) set the notify to recyclerview update the list
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }

        //18) create method for `bind` word with item
        public void bind(Word word) {
            mWord = word;
            wordItemView.setText(mWord.getWord());
        }
    }

}
