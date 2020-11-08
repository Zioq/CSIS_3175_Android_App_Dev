package com.s300299315.wordgame;

public class Word {
    private int mId;
    private String mWord;

    //Default Constructor
    public Word(){}

    public Word(String word) {
        this.mWord = word;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id ) {
        this.mId = id;
    }

    public String getWord() {
        return this.mWord;
    }

    public void setWord(String word ) {
        this.mWord = word;
    }
}
