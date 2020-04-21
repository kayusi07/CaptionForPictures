package captionforpictures.kayushi07.com.captionforpictures.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import captionforpictures.kayushi07.com.captionforpictures.activity.DetailActivity;
import captionforpictures.kayushi07.com.captionforpictures.activity.SearchActivity;
import captionforpictures.kayushi07.com.captionforpictures.R;

import java.util.List;

import captionforpictures.kayushi07.com.captionforpictures.adapter.SingleListAdapter;
import captionforpictures.kayushi07.com.captionforpictures.model.Single;
import captionforpictures.kayushi07.com.captionforpictures.widgets.GridMarginDecoration;


public class FragmentSingle extends Fragment implements SingleListAdapter.OnGridItemSelectedListener {

    private RecyclerView lvSingle;
//    EditText search;
    FloatingActionButton fab;
    private GridLayoutManager gridLayoutManager;
    private SingleListAdapter singleListAdapter;
    private Context context;
    InterstitialAd interstitialAd;


    public static FragmentSingle newInstance() {
        return new FragmentSingle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single, container, false);

        lvSingle = (RecyclerView) rootView.findViewById(R.id.lvSingle);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent i = new Intent(context, SearchActivity.class);
        startActivity(i);
            }
        });

        try{
            createNewIntAd();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        singleListAdapter = new SingleListAdapter(this);
        gridLayoutManager = new GridLayoutManager(context, 2);

        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(singleListAdapter);

        loadData();
    }

    private void loadData() {
        List<Single> singleList = new ArrayList<>();
        Single single;

        int img[] = {R.drawable.sd, R.drawable.quarantine,
                R.drawable.nature, R.drawable.travel,
                R.drawable.dp, R.drawable.me,
                R.drawable.romantic, R.drawable.flirty,
                R.drawable.food, R.drawable.fitness,
                R.drawable.savage, R.drawable.good,
                R.drawable.song, R.drawable.sad,
                R.drawable.selfie, R.drawable.group,
                R.drawable.summer, R.drawable.beach,
                R.drawable.sarcasm,
                R.drawable.attitude, R.drawable.sassy,
                R.drawable.funny, R.drawable.party,
                R.drawable.birthday, R.drawable.love,
                R.drawable.single, R.drawable.best_frd,
                R.drawable.cousin, R.drawable.family,
                R.drawable.kids, R.drawable.cute, R.drawable.cool,
                R.drawable.success, R.drawable.inspiration,
                R.drawable.business,  R.drawable.clever
                //, R.drawable.pet
        };

        String title[] = {
                "Social Distancing", "Quarantine",
                "Nature", "Travel",
                "Profile Picture", "Me And Myself",
                "Romantic", "Flirty",
                "Food", "Fitness",
                "Savage", "Good",
                "Song Lyrics", "Sad",
                "Selfie", "Group Photo",
                "Summer", "Beach",
                "Sarcasm", "Attitude",
                "Sassy", "Funny",
                "Party", "Birthday",
                "Love", "Single",
                "Best Friend", "Cousins",
                "Family", "Kids",
                "Cute", "Cool",
                "Success", "Inspirational",
                "Business", "Clever"//,
                //"Pets"
        };

        for (int i = 0; i < img.length; i++) {
            single = new Single();

            single.setImg(img[i]);
            single.setTitle(title[i]);

            singleList.add(single);
        }

        singleListAdapter.addAll(singleList);
    }

    @Override
    public void onGridItemClick(View v, int position) {

        final int save_position = position;

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("id", save_position);
                    startActivity(intent);

                    // Load the next interstitial.
                    interstitialAd.loadAd(new AdRequest.Builder().build());
                }

            });
        }
        else {

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        }

}

    private void createNewIntAd() {
        interstitialAd = new InterstitialAd(context);
        // set the adUnitId (defined in values/strings.xml)
        interstitialAd.setAdUnitId(getString(R.string.inter_add));
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        interstitialAd.loadAd(adRequest);
    }
}
