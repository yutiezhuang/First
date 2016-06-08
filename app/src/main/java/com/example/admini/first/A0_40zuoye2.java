package com.example.admini.first;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import been.BookContent;

/**
 * Created by Administrator on 2016/6/7.
 */
public class A0_40zuoye2 extends Fragment {
    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey("item_id"))
        {
            book = BookContent.ITEM_MAP.get(getArguments().getInt("item_id"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a0_40zuoye1,container,false);
        if(book != null)
        {
            TextView title = (TextView) view.findViewById(R.id.book_title);
            TextView desc = (TextView) view.findViewById(R.id.book_desc);

            title.setText(book.title);
            desc.setText(book.desc);
        }
        return view;
    }
}
