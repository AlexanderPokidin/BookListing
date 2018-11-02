package com.pokidin.a.booklisting;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookJsonParser {
    private static final String TAG = BookJsonParser.class.getSimpleName();

    private static ArrayList<Book> extractDataFromJson(String bookJson) {
        if (TextUtils.isEmpty(bookJson)) {
            return null;
        }

        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject baseJsonObject = new JSONObject(bookJson);
            JSONArray booksArray = baseJsonObject.getJSONArray("items");

            if (booksArray.length() > 0) {
                for (int i = 0; i < booksArray.length(); i++) {
                    JSONObject currentBook = booksArray.getJSONObject(i);
                    JSONObject bookInfo = currentBook.getJSONObject("volumeInfo");

                    // TODO Use checkKeyWord() for all keywords
                    String title = bookInfo.getString("title");
                    String publisher = bookInfo.getString("publisher");

                    String date = checkKeyWord(bookInfo, "publishedDate");
                    String description = checkKeyWord(bookInfo, "description");

                    ArrayList<String> authorsList = new ArrayList<>();
                    if (bookInfo.has("authors")) {
                        JSONArray authorsArray = bookInfo.getJSONArray("authors");
                        for (int j = 0; j < authorsArray.length(); j++) {
                            String author = authorsArray.getString(j);
                            authorsList.add(author);
                        }
                    }
                    Book book = new Book(title, publisher, date, description, authorsList);
                    books.add(book);
                }
            }
        } catch (JSONException ex) {
            Log.e(TAG, "Problem parsing the book JSON results", ex);
        }
        return books;
    }

    static List<Book> fetchBookData(String requestUrl) {

        URL url = BookHttpClient.createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = BookHttpClient.makeHttpRequest(url);
            Log.d(TAG, "jsonResponse: " + jsonResponse);
        } catch (IOException ex) {
            Log.e(TAG, "Problem making the HTTP request.", ex);
        }
        return extractDataFromJson(jsonResponse);
    }

    // TODO Rename checkKeyWord() method
    private static String checkKeyWord(JSONObject jsonObject, String keyWord) throws JSONException {
        if (jsonObject.has(keyWord)) {
            return jsonObject.getString(keyWord);
        } else {
            return null;
        }
    }
}
