package captionforpictures.kayushi07.com.captionforpictures.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import captionforpictures.kayushi07.com.captionforpictures.R;
import captionforpictures.kayushi07.com.captionforpictures.adapter.SearchListAdapter;
import captionforpictures.kayushi07.com.captionforpictures.databinding.SearchPageBinding;
import captionforpictures.kayushi07.com.captionforpictures.model.CaptionData;

public class SearchActivity  extends AppCompatActivity
{
    SearchPageBinding activityMainBinding;
    SearchListAdapter adapter;

    List<String> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_page);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.search_page);

        arrayList.add("January one two three");
        arrayList.add("February four five six");
        arrayList.add("March seven eight nine");
        arrayList.add("April ten one two");
        arrayList.add("May three four");
        arrayList.add("June five six seven");
        arrayList.add("July eight");
        arrayList.add("August nine ten");
        arrayList.add("September one two three four");
        arrayList.add("October five six");
        arrayList.add("November seven");
        arrayList.add("December eight nine");
//        arrayList.addAll(CaptionData.detailDataFunny);

        adapter= new SearchListAdapter(arrayList);

        activityMainBinding.searchList.setAdapter(adapter);

        activityMainBinding.search.setActivated(true);
        activityMainBinding.search.setQueryHint("Type your keyword here");
        activityMainBinding.search.onActionViewExpanded();
        activityMainBinding.search.setIconified(false);
        activityMainBinding.search.clearFocus();

        activityMainBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}
