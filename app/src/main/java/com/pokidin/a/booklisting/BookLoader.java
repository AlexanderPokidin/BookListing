package com.pokidin.a.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {
    private static final String TAG = BookLoader.class.getSimpleName();

    private String mUrl;

    public BookLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
        if (mUrl == null){
            return null;
        } else {
            return BookJsonParser.fetchBookData(mUrl);
        }
    }
}
