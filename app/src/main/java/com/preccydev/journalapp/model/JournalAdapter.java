package com.preccydev.journalapp.model;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.preccydev.journalapp.R;

import static com.preccydev.journalapp.data.JournalContract.COLUMN_JOURNAL;
import static com.preccydev.journalapp.data.JournalContract.COLUMN_NOTE;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.MyViewHolder> {
    private Cursor mCursor;
    private Context mContext;

    private JournalItemClickListener mOnclickListener;

    public JournalAdapter(Context context, Cursor cursor, JournalItemClickListener OnclickListener) {
        this.mContext = context;
        this.mCursor = cursor;
        this.mOnclickListener = OnclickListener;


    }

    public JournalAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        int layoutIdForListDirectory = R.layout.journals_activity;

        View view = inflater.inflate(layoutIdForListDirectory, parent, shouldAttachToParentImmediately);
        MyViewHolder JournalViewHolder = new MyViewHolder(view);

        return JournalViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;

        String Title = mCursor.getString(mCursor.getColumnIndex(COLUMN_JOURNAL));
        String Note = mCursor.getString(mCursor.getColumnIndex(COLUMN_NOTE));
        String first = Note.substring(0, 1);
        holder.mTitle.setText(Title);
        holder.mNote.setText(Note);


    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        // Always close the previous mCursor first
        if (mCursor != null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    public interface JournalItemClickListener {
        void onJournalItemClick(int ClickedItemIndex);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView mTitle;
        private TextView mNote;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = (itemView).findViewById(R.id.topic_list);
            mNote = (itemView).findViewById(R.id.note_list);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int ClickItemPosition = getAdapterPosition();
            mOnclickListener.onJournalItemClick(ClickItemPosition);
        }
    }
}

