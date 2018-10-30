package com.pokidin.a.booklisting;

import android.app.LoaderManager;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {
    public static final String TAG = BookActivity.class.getSimpleName();
    private static final String BOOK_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes";
    private static final int BOOK_LOADER_ID = 1;

    private static final String SEARCH_WORD = "Android";
    private static final String SEARCH_NUMBER = "10";

    private String titleOfTheBook;

    private BookAdapter mBookAdapter;
    private EditText mSearchWord;
    private Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mSearchWord = findViewById(R.id.et_search);

        mSearchButton = findViewById(R.id.btn_search);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleOfTheBook = mSearchWord.getText().toString();

            }
        });


        ListView bookListView = findViewById(R.id.list);

        mBookAdapter = new BookAdapter(this, new ArrayList<Book>());
        bookListView.setAdapter(mBookAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book currentBook = mBookAdapter.getItem(position);
            }
        });

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(BOOK_LOADER_ID, null, this);
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

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(BOOK_REQUEST_URL);
        Uri.Builder builder = baseUri.buildUpon();
        builder.appendQueryParameter("q", SEARCH_WORD);
        builder.appendQueryParameter("maxResults", SEARCH_NUMBER);
        Log.d(TAG, "builder: " + builder);
        return new BookLoader(this, builder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
        mBookAdapter.addAll(data);

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        mBookAdapter.clear();

    }
}
