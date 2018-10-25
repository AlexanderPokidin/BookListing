package com.pokidin.a.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private BookAdapter mBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView bookListView = findViewById(R.id.list);

        mBookAdapter = new BookAdapter(this, createBooks());
        bookListView.setAdapter(mBookAdapter);
    }

    // Create a fake list of books
    private ArrayList<Book> createBooks() {

        ArrayList<Book> fakeBooks = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        authors.add("author");
        fakeBooks.add(new Book("title00", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title01", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title02", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title03", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title04", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title05", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title06", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title07", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title08", "publisher", 101, "description", authors));
        fakeBooks.add(new Book("title09", "publisher", 101, "description", authors));

        return fakeBooks;
    }

    ;
}
