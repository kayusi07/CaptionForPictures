package captionforpictures.kayushi07.com.captionforpictures.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import captionforpictures.kayushi07.com.captionforpictures.R;
import captionforpictures.kayushi07.com.captionforpictures.adapter.DetailDataAdapter;
import captionforpictures.kayushi07.com.captionforpictures.model.CaptionData;
import captionforpictures.kayushi07.com.captionforpictures.model.DetailData;

/**
 * Created by Ayushi on 11-07-2017.
 */

public class DetailActivity extends AppCompatActivity {

    private DetailDataAdapter adapter;
    private RecyclerView recyclerView;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_caption_main);

        Intent i = getIntent();
        int id = i.getIntExtra("id", 1);
        initViews();


        switch(id)
        {
            case 0:{
                setTitle("FUNNY Captions");
                DetailData detailData[] = CaptionData.detailDataFunny;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 1:{
                setTitle("LOVE Captions");
                DetailData detailData[] = CaptionData.detailDataLove;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 2:{
                setTitle("NATURE Captions");
                DetailData detailData[] = CaptionData.detailDataNature;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
                }
            case 3:{
                setTitle("COOL Captions");
                DetailData detailData[] = CaptionData.detailDataCool;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 4:{
                setTitle("SELFIE Captions");
                DetailData detailData[] = CaptionData.detailDataSelfie;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 5:{
                setTitle("CLEVER Captions");
                DetailData detailData[] = CaptionData.detailDataClever;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 6:{
                setTitle("SUCCESS Captions");
                DetailData detailData[] = CaptionData.detailDataSuccess;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 7:{
                setTitle("CUTE Captions");
                DetailData detailData[] = CaptionData.detailDataCute;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 8:{
                setTitle("SONG LYRICS Captions");
                DetailData detailData[] = CaptionData.detailDataSongLyrics;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 9:{
                setTitle("BEST FRIEND Captions");
                DetailData detailData[] = CaptionData.detailDataBestFriend;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 10:{
                setTitle("ME and MYSELF Captions");
                DetailData detailData[] = CaptionData.detailDataMeMyself;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 11:{
                setTitle("SAVAGE Captions");
                DetailData detailData[] = CaptionData.detailDataSavage;
                adapter =  new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 12:{
                setTitle("GOOD Captions");
                DetailData detailData[] = CaptionData.detailDataGood;
                adapter =  new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;

            }
            case 13:{
                setTitle("ATTITUDE Captions");
                DetailData detailData[] = CaptionData.detailDataAttitude;
                adapter =  new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 14:{
                setTitle("FLIRTY Captions");
                DetailData detailData[] = CaptionData.detailDataFlirty;
                adapter =  new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 15:{
                setTitle("SAD Captions");
                DetailData detailData[] = CaptionData.detailDataSad;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 16:{
                setTitle("PROFILE PICTURE Captions");
                DetailData detailData[] = CaptionData.detailDataProfilePicture;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 17:{
                setTitle("SUMMER Captions");
                DetailData detailData[] = CaptionData.detailDataSummer;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 18:{
                setTitle("BEACH Captions");
                DetailData detailData[] = CaptionData.detailDataBeach;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 19:{
                setTitle("BUSINESS Captions");
                DetailData detailData[] = CaptionData.detailDataBusiness;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 20:{
                setTitle("COUSINS Captions");
                DetailData detailData[] = CaptionData.detailDataCousins;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 21:{
                setTitle("FAMILY Captions");
                DetailData detailData[] = CaptionData.detailDataFamily;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 22:{
                setTitle("GROUP PHOTO Captions");
                DetailData detailData[] = CaptionData.detailDataGroupPhoto;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 23:{
                setTitle("INSPIRATIONAL Captions");
                DetailData detailData[] = CaptionData.detailDataInspirational;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 24:{
                setTitle("KIDS Captions");
                DetailData detailData[] = CaptionData.detailDataKids;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 25:{
                setTitle("PARTY Captions");
                DetailData detailData[] = CaptionData.detailDataParty;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 26:{
                setTitle("ROMANTIC Captions");
                DetailData detailData[] = CaptionData.detailDataRomantic;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 27:{
                setTitle("SARCASM Captions");
                DetailData detailData[] = CaptionData.detailDataSarcasm;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 28:{
                setTitle("SASSY Captions");
                DetailData detailData[] = CaptionData.detailDataSassy;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 29:{
                setTitle("SINGLE Captions");
                DetailData detailData[] = CaptionData.detailDataSingle;
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
        }
    }

    private void initViews(){
        recyclerView = (RecyclerView) findViewById(R.id.detail_rec);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        finish();
        super.onDestroy();
    }
}