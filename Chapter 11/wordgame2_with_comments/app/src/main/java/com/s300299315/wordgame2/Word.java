package com.s300299315.wordgame2;

public class Word {

    // Each `Word` class contains `mId` and `mWord` which is word itself
    private int mId;
    private String mWord;

    // Default Constructor
    public  Word() {}

    // Constructor
    public Word(String word) {
        this.mWord = word;
    }

    // Getter & Setter
    public int getId() {
        return this.mId;
    }
    public void setId(int id) {
        mId = id;
    }

    public String getWord() {
        return this.mWord;
    }
    public void setWord(String word) {
        this.mWord = word;
    }

}
