package captionforpictures.kayushi07.com.captionforpictures.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;


import java.util.ArrayList;
import java.util.List;
import captionforpictures.kayushi07.com.captionforpictures.databinding.*;

import captionforpictures.kayushi07.com.captionforpictures.R;


public class SearchListAdapter extends BaseAdapter implements Filterable {

    List<String> mData;
    List<String> mStringFilterList;
    ValueFilter valueFilter;
    private LayoutInflater inflater;

    public SearchListAdapter(List<String> cancel_type) {
        mData=cancel_type;
        mStringFilterList = cancel_type;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        final RowItemSearchBinding rowItemBinding = DataBindingUtil.inflate(inflater, R.layout.row_item_search, parent, false);
        rowItemBinding.stringName.setText(mData.get(position));
        rowItemBinding.stringName.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) parent.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", rowItemBinding.stringName.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(parent.getContext(), " COPIED to clipboard!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return rowItemBinding.getRoot();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<String> filterList = new ArrayList<>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(mStringFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            }
            else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mData = (List<String>) results.values;
            notifyDataSetChanged();
        }

    }

}
