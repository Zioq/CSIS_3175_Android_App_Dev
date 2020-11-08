package com.s300299315.wordgame;


import android.provider.UserDictionary;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ListAdapter;

public class WordListAdapter extends ListAdapter<Word, WordListAdapter.WordViewHolder> {

    WordListOpenHelper mDb;

    protected  WordListAdapter(WordListOpenHelper db,
                               @NonNull DiffUtil.ItemCallback<Word> diffCallback) {
        super(diffCallback);
        mDb = db;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word current = mDb.query(position);
        holder.bind(current);
    }

    @Override
    public int getItemCount() {
        return (int) mDb.count();
    }


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

    class WordViewHolder extends RecyclerView.ViewHolder {

        private Word mWord;
        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            wordItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDb.delete(mWord.getId());
                    notifyItemRemoved(getAdapterPosition());

                }
            });
        }

        public void bind(Word word) {
            mWord = word;
            wordItemView.setText(mWord.getWord());
        }
    }

}