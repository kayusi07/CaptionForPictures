package captionforpictures.kayushi07.com.captionforpictures.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import captionforpictures.kayushi07.com.captionforpictures.Activity.DetailActivity;
import captionforpictures.kayushi07.com.captionforpictures.Activity.MainActivity;
import captionforpictures.kayushi07.com.captionforpictures.Activity.SearchActivity;
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
        gridLayoutManager = new GridLayoutManager(context, 1);

        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(singleListAdapter);

        loadData();
    }

    private void loadData() {
        List<Single> singleList = new ArrayList<>();
        Single single;

        int img[] = {R.drawable.funny, R.drawable.love,
                R.drawable.nature, R.drawable.cool,
                R.drawable.selfie, R.drawable.clever,
                R.drawable.success, R.drawable.cute,
                R.drawable.song, R.drawable.best_frd,
                R.drawable.me, R.drawable.savage,
                R.drawable.good, R.drawable.attitude,
                R.drawable.flirty, R.drawable.sad,
                R.drawable.dp, R.drawable.summer,
                R.drawable.beach};

        String title[] = {
                "FUNNY Captions", "LOVE Captions",
                "NATURE Captions", "COOL Captions",
                "SELFIE Captions", "CLEVER Captions",
                "SUCCESS Captions", "CUTE Captions",
                "SONG LYRICS Captions",
                "BEST FRIEND Captions", "ME and MYSELF Captions",
                "SAVAGE Captions", "GOOD Captions", "ATTITUDE Captions",
                "FLIRTY Captions", "SAD Captions",
                "PROFILE PICTURE Captions", "SUMMER Captions",
                "BEACH Captions"
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
