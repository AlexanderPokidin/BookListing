package com.pokidin.a.booklisting;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public static final String TAG = BookAdapter.class.getSimpleName();


    public BookAdapter(@NonNull Activity context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Book currentBook = getItem(position);
        TextView titleTextView = listItemView.findViewById(R.id.tv_title);
        titleTextView.setText(currentBook.getTitle());

        TextView publisherTextView = listItemView.findViewById(R.id.tv_publisher);
        publisherTextView.setText(currentBook.getPublisher());

        TextView dateNextView = listItemView.findViewById(R.id.tv_date);
        dateNextView.setText(String.valueOf(currentBook.getPublishedDate()));

        TextView descriptionTextView = listItemView.findViewById(R.id.tv_description);
        descriptionTextView.setText(currentBook.getDescription());

        TextView authorsTextView = listItemView.findViewById(R.id.tv_authors);
        authorsTextView.setText(formatAuthors(currentBook.getAuthors()));

        return listItemView;
    }

    private String formatAuthors(List<String> authors) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < authors.size(); i++) {
            buffer.append(authors.get(i));
            if (i != authors.size() - 1) {
                buffer.append(", ");
            }
        }
        return String.valueOf(buffer);
    }
}
