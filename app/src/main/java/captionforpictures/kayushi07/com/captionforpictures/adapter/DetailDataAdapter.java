package captionforpictures.kayushi07.com.captionforpictures.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import captionforpictures.kayushi07.com.captionforpictures.R;
import captionforpictures.kayushi07.com.captionforpictures.model.DetailData;

public class DetailDataAdapter extends RecyclerView.Adapter<DetailDataAdapter.ViewHolder> {
    private DetailData[] detailData;
    Activity activity;

    public DetailDataAdapter(DetailData[] detailData, Activity activity) {
        this.detailData = detailData;
        this.activity = activity;
    }

    @Override
    public DetailDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflate the layout, initialize the View Holder

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_row_main, viewGroup, false);
            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        String comment = detailData[i].getComment();
        viewHolder.tv_comment.setText(comment);
    }


    @Override
    public int getItemCount() {

        return detailData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_comment;
        ImageButton b_copy, b_share;

        public ViewHolder(View view) {
            super(view);

            tv_comment = (TextView) view.findViewById(R.id.txt_detail);
            b_copy = (ImageButton) view.findViewById(R.id.b_copy);
            b_share = (ImageButton) view.findViewById(R.id.b_share);


            b_copy.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", tv_comment.getText().toString());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(activity, " COPIED to clipboard!", Toast.LENGTH_SHORT).show();

                }
            });

            b_share.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "" + tv_comment.getText().toString());
                    sendIntent.setType("text/plain");
                    activity.startActivity(sendIntent);
                }
            });
        }
    }
}