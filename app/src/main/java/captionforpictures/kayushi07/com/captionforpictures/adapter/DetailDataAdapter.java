package captionforpictures.kayushi07.com.captionforpictures.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        public ViewHolder(View view) {
            super(view);

            tv_comment = (TextView) view.findViewById(R.id.txt_detail);

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
//                    int p=getLayoutPosition();
                    TextView textView = (TextView) view.findViewById(R.id.txt_detail);
//                    Log.d("test",textView.getText().toString());

                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", textView.getText().toString());
                    clipboard.setPrimaryClip(clip);


                    Toast.makeText(activity, " COPIED to clipboard!", Toast.LENGTH_LONG).show();

                    return true;// returning true instead of false, works for me
                }
            });
        }
    }
}