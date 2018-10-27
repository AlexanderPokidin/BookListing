package com.pokidin.a.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String TAG = BookActivity.class.getSimpleName();

    private BookAdapter mBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        ListView bookListView = findViewById(R.id.list);

        mBookAdapter = new BookAdapter(this, createBooks());
        bookListView.setAdapter(mBookAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book currentBook = mBookAdapter.getItem(position);
            }
        });
    }

    // Create a fake list of books
    private ArrayList<Book> createBooks() {

        ArrayList<Book> fakeBooks = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        authors.add("author101");
        authors.add("author202");
        authors.add("author303");
        fakeBooks.add(new Book("title00", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title01", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title02", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title03", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title04", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title05", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title06", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title07", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title08", "publisher", "202", "description", authors));
        fakeBooks.add(new Book("title09", "publisher", "202", "description", authors));

        return fakeBooks;
    }
}
