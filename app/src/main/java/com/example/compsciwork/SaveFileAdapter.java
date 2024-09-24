package com.example.compsciwork;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SaveFileAdapter extends RecyclerView.Adapter<SaveFileAdapter.SaveFileViewHolder> {
    private ArrayList<SaveFile> saves;

    public SaveFileAdapter(ArrayList<SaveFile> saves) {
        this.saves = saves;
    }

    @NonNull
    @Override
    public SaveFileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.savefile_item, parent, false);
        return new SaveFileViewHolder(fileView);
    }

    @Override
    public void onBindViewHolder(@NonNull SaveFileViewHolder holder, int position) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SaveFile currentSave = saves.get(position);
        holder.nameButton.setText(currentSave.getSessionName());
        holder.startDateTextVIew.setText(df.format(currentSave.getStartDate()));
        holder.lastOpenedTextView.setText(df.format(currentSave.getLastOpened()));

    }

    @Override
    public int getItemCount() {
        return saves.size();
    }

    public static class SaveFileViewHolder extends RecyclerView.ViewHolder {

        public Button nameButton;
        public TextView lastOpenedTextView;
        public TextView startDateTextVIew;

        public SaveFileViewHolder(@NonNull View itemView) {
            super(itemView);
            nameButton = itemView.findViewById(R.id.startButton);
            lastOpenedTextView = itemView.findViewById(R.id.lastOpenedView);
            startDateTextVIew = itemView.findViewById(R.id.startDateView);
        }
    }
}
