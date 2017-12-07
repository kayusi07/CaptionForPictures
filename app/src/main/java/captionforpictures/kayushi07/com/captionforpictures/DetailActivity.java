package captionforpictures.kayushi07.com.captionforpictures;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import captionforpictures.kayushi07.com.captionforpictures.adapter.DetailDataAdapter;
import captionforpictures.kayushi07.com.captionforpictures.model.DetailData;

/**
 * Created by Ayushi on 11-07-2017.
 */

public class DetailActivity extends AppCompatActivity{

    private ArrayList<String> countries =  new ArrayList<>();
    private DetailDataAdapter adapter;
    private RecyclerView recyclerView;
    private AlertDialog.Builder alertDialog;
    private EditText et_country;
    private int edit_position;
    private View view;
    private boolean add = false;
    private Paint p = new Paint();
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
                DetailData detailData[] = {
                        new DetailData("Life isn’t perfect..But my Hair is! #selfieaddict"),
                        new DetailData("I didn’t choose the thug life, the thug life chose me"),
                        new DetailData("I got back with my Ex…Box 360"),
                        new DetailData("You only drink diet soda? You must be so healthy."),
                        new DetailData("The worst time to have a heart attack is during a game of charades."),
                        new DetailData("The moment when she says you’re cute."),
                        new DetailData("If we could only turn back time…"),
                        new DetailData("When nothing goes right, go left instead!"),
                        new DetailData("I need a six month holiday, twice a year."),
                        new DetailData("There may be no excuse for laziness, but I’m still looking."),
                        new DetailData("A blind man walks into a bar… And a chair… and a table."),
                        new DetailData("I don’t always surf the internet, but when I do, eyebrows!"),
                        new DetailData("Yesterday, I changed my WiFi password to “Hackitifyoucan”; today, someone changed it to “ChallengeAccepted”."),
                        new DetailData("So, you’re on Instagram? You must be an amazing photographer."),
                        new DetailData("Real men don’t take selfies."),
                        new DetailData("I haven’t done this in a while so excuse me."),
                        new DetailData("I know I’m lucky that I’m so cute."),
                        new DetailData("Onions make me sad. A lot of people don’t realize that."),
                        new DetailData("I’m your worst nightmare."),
                        new DetailData("If I was funny, I would have a good Instagram caption."),
                        new DetailData("I think you are lacking vitamin me!"),
                        new DetailData("What if I told you, you can eat without posting it on Instagram."),
                        new DetailData("Ladies, please."),
                        new DetailData("Need an ark? I Noah guy.")

                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 1:{
                setTitle("LOVE Captions");
                DetailData detailData[] = {
                        new DetailData("With You, I forget all my problems. With You, Time Stands Still."),
                        new DetailData("We come to love by not finding the perfect person but by learning to see imperfect person perfectly."),
                        new DetailData("When I fell for you, I fell Hard"),
                        new DetailData("If I ever write story about my life, don’t be surprised if your name appears billion time."),
                        new DetailData("I want you to be happy, but I want you to be happy with Me."),
                        new DetailData("It will be Always YOU."),
                        new DetailData("If you are Mine, You are Mine. I don’t like Sharing."),
                        new DetailData("Nothing Can replace you!"),
                        new DetailData("I love you. That’s all I know."),
                        new DetailData("I’m not perfect but I am Loyal.")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 2:{
                setTitle("FLIRTY Captions");
                DetailData detailData[] = {
                        new DetailData("Do you sit in a pile of sugar? cause you got a pretty sweet ass!"),
                        new DetailData("They say tongue is the strongest muscle of the body. Wanna fight?"),
                        new DetailData("Did you swallow magnets? cause you are attractive!"),
                        new DetailData("Kiss me if I’m wrong but Dinosaurs still exist? Right?"),
                        new DetailData("Nice t-shirt. Can I talk you out of it?"),
                        new DetailData("Do you have a name or can I call you Mine?"),
                        new DetailData("Do you like sleeping? Me too! We should do it together sometimes!"),
                        new DetailData("Can I borrow a kiss? I promise I’ll give it back."),
                        new DetailData("Aside from being sexy, what do you do for a living?"),
                        new DetailData("Do you live in a corn field, coz I’m stalking you.")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 3:{
                setTitle("COOL Captions");
                DetailData detailData[] = {
                        new DetailData("You think this is a game?"),
                        new DetailData("Weekend, please don’t leave me."),
                        new DetailData("Don’t let anyone tell you that you’re not strong enough."),
                        new DetailData("Be who and what you want, period."),
                        new DetailData("Stay strong, the weekend is coming."),
                        new DetailData("You play Call of Duty? That’s cute."),
                        new DetailData("You’re doing it wrong."),
                        new DetailData("Don’t be like the rest of them, darling."),
                        new DetailData("I wasn’t lucky, I deserved it."),
                        new DetailData("Whatever you do in life, make sure it makes you happy."),
                        new DetailData("The question isn’t can you, it’s will you?"),
                        new DetailData("What do you think of the view?"),
                        new DetailData("When I feel a little down, I put on my favorite high heels and dance."),
                        new DetailData("I liked memes before they were on Instagram"),
                        new DetailData("That moment when you realize your childhood is over."),
                        new DetailData("Friday, my second favorite F word."),
                        new DetailData("I’ll never try to fit in. I was born to STAND OUT.")

                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 4:{
                setTitle("SELFIE Captions");
                DetailData detailData[] = {
                        new DetailData("That Weird Selfie Face!"),
                        new DetailData("Selfie Time!"),
                        new DetailData("Selfie Sunday!"),
                        new DetailData("But first, let me take a selfie."),
                        new DetailData("Real men don’t take selfies"),
                        new DetailData("My Selfie never bothered me anyway."),
                        new DetailData("Talk to the fist, because the face is pissed!"),
                        new DetailData("Don’t cry because it’s over, smile because it happened!"),
                        new DetailData("Why so serious?"),
                        new DetailData("OMG, look at my selfie"),
                        new DetailData("I woke up like this"),
                        new DetailData("Posing selfie just for the pic"),
                        new DetailData("What have i become."),
                        new DetailData("Wish you were here"),
                        new DetailData("Getting my pose on!"),
                        new DetailData("On my way home, thought I should take a selfie!"),
                        new DetailData("Happy wala selfie"),
                        new DetailData("Selfie before work"),
                        new DetailData("After work selfie")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 5:{
                setTitle("CLEVER Captions");
                DetailData detailData[] = {
                        new DetailData("Lives change like the weather. I hope you remember today is never too late to be brand new."),
                        new DetailData("Dear vegetarians, if you’re trying to save animals, then why are you eating their food?"),
                        new DetailData("A recent study has found that women who carry a little extra weight live longer than the men who mention it."),
                        new DetailData("They used to shout my name, now they whisper it."),
                        new DetailData("Life is not measured by the number of breaths you take, but the moments that take your breath away."),
                        new DetailData("Stay sharp and far from timid."),
                        new DetailData("If a dentist makes their money from unhealthy teeth, why would I trust a product 4/5 of them recommend?"),
                        new DetailData("Say Beer Can with a British accent. I just taught you to say Bacon with a Jamaican accent."),
                        new DetailData("These are the days we live for."),
                        new DetailData("Life is short, false; it’s the longest thing you do."),
                        new DetailData("Work until your idols become your rivals."),
                        new DetailData("A clever person solves a problem. A wise person avoids it. A dumb person creates it."),
                        new DetailData("Some days start better than others."),
                        new DetailData("Being single is smarter than being in the wrong relationship.")

                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 6:{
                setTitle("SUCCESS Captions");
                DetailData detailData[] = {
                        new DetailData("Don’t talk, just act. Don’t say, just show. Don’t promise, just prove."),
                        new DetailData("Never stop doing great just because someone doesn’t give you credit."),
                        new DetailData("It always seems impossible until it’s done."),
                        new DetailData("Marry the right person. This one decision will determine 90% of your happiness or misery."),
                        new DetailData("Be honest."),
                        new DetailData("Good things come to those who hustle."),
                        new DetailData("If you want to succeed, you have to let failure be your best-friend!"),
                        new DetailData("You can’t do epic shit with basic people!"),
                        new DetailData("Be self-starter."),
                        new DetailData("Stop blaming others. Take responsibility for every area of your life.")

                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 7:{
                setTitle("CUTE Captions");
                DetailData detailData[] = {
                        new DetailData("Never love anyone who treats you like you’re ordinary."),
                        new DetailData("Trying to forget it but the memories are too strong."),
                        new DetailData("We all start as strangers."),
                        new DetailData("Truth is, I’m crazy for you. And everyone can see that but you."),
                        new DetailData("I act like I’m ok, but I’m really not."),
                        new DetailData("Stop looking for happiness in the same place you just lost it."),
                        new DetailData("Don’t worry if you haven’t found your true love, they’re just with someone else right now."),
                        new DetailData("Never cry for that person who doesn’t know the value of your tears."),
                        new DetailData("If I die tomorrow, will you remember me?"),
                        new DetailData("Keep smiling because life is a beautiful thing and there’s so much to smile about."),
                        new DetailData("Don’t let your eyes be blinded by her beauty."),
                        new DetailData("Boys are like purses, cute, full of crap, and can always be replaced.")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 8:{
                setTitle("SONG LYRICS Captions");
                DetailData detailData[] = {
                        new DetailData("I’m here for a good time not a long time"),
                        new DetailData("I can’t really see another squad tryna cross us"),
                        new DetailData("I’m up right now and you suck right now"),
                        new DetailData("No new friends"),
                        new DetailData("Where you movin’? I said onto better things"),
                        new DetailData("Know yourself, know your worth"),
                        new DetailData("Make the most out of tonight, and worry ‘bout it all tomorrow"),
                        new DetailData("I’m way up, I feel blessed"),
                        new DetailData("I cannot see heaven being much better than this"),
                        new DetailData("Live for today, plan for tomorrow, party tonight"),
                        new DetailData("I’mma sip it ‘til i feel it, I’mma smoke it ‘til it’s done"),
                        new DetailData("I still ride with my day one"),
                        new DetailData("My excuse is that I’m young"),
                        new DetailData("I live for the nights that I can’t remember with the people that I won’t forget"),
                        new DetailData("I’mma worry ‘bout me, give a f*** about you"),
                        new DetailData("Nobody really likes us except for us"),
                        new DetailData("They ain’t make me what I am, they just found me like this"),
                        new DetailData("You only live once"),
                        new DetailData("Drinking every night because we drink to my accomplishments"),
                        new DetailData("Started from the bottom now we’re here"),
                        new DetailData("Last name ever, first name greatest"),
                        new DetailData("Whole squad on that real shit"),
                        new DetailData("On my worst behavior"),
                        new DetailData("Worrying about your followers, you need to get your dollars up"),
                        new DetailData("Started not to give a f*** and stopped fearing the consequence"),
                        new DetailData("Never not chasing a million things I want.")

                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 9:{
                setTitle("BEST FRIEND Captions");
                DetailData detailData[] = {
                        new DetailData("I don’t know what’s tighter, our jeans or our friendship!"),
                        new DetailData("I would rather walk with a friend in the dark, than alone in the light."),
                        new DetailData("Best Friends make good times better and hard times easier!"),
                        new DetailData("I don’t know what I did to have a best friend like you."),
                        new DetailData("Life was meant for Best Friends and Good Adventures!"),
                        new DetailData("She is my Best Friend. You break her heart, I will break your face."),
                        new DetailData("Meet my Partner in Crime!"),
                        new DetailData("It’s me and my Best Friend for Life!"),
                        new DetailData("Good Times + Crazy Friends = Great Memories!"),
                        new DetailData("Sometimes, being with your bff is all the therapy you need!")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 10:{
                setTitle("ME and MYSELF Captions");
                DetailData detailData[] = {
                        new DetailData("I don’t need your approval to be me."),
                        new DetailData("I am who I am, I am what I am, I do what I do and I ain’t never gonna do it any different. I don’t care who likes it and who don’t."),
                        new DetailData("Take me as I am, or watch me as I go."),
                        new DetailData("If I were you, I would adore me."),
                        new DetailData("Me? Weird? B***h Please! I am Limited Edition."),
                        new DetailData("I am not perfect. I make mistakes. But when I say Sorry… I mean it!"),
                        new DetailData("I am not trying to give an image of a fairy-tale, perfect, everything else, I am just being myself."),
                        new DetailData("I was both loved and hated for being upfront. But I was just being myself."),
                        new DetailData("I like being myself. Maybe just slimmer, with a few less wrinkles."),
                        new DetailData("I take a lot of pride in being myself. I’m comfortable with who I am."),
                        new DetailData("Everyone said I could be Anything.. So I became Sexy!")
                };
                adapter = new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 11:{
                setTitle("SAVAGE Captions");
                DetailData detailData[] = {
                        new DetailData("Life goes on, with or without you."),
                        new DetailData("her attitude savage but her heart is gold."),
                        new DetailData("Own what’s yours, or else others will try to."),
                        new DetailData("Don’t mistake my kindness for weakness."),
                        new DetailData("You couldn’t handle me even if I came with instructions."),
                        new DetailData("Forgive, yes. Forget, never."),
                        new DetailData("There’s a hole in my heart where you use to be."),
                        new DetailData("I don’t need any part-time people in my life."),
                        new DetailData("If you’re honestly happy, f*** what people think."),
                        new DetailData("Being pissed off gets old. I’m just at a whole new ‘f*** it’ level.")
                };
                adapter =  new DetailDataAdapter(detailData, this);
                recyclerView.setAdapter(adapter);
                break;
            }
            case 12:{
                setTitle("GOOD Captions");
                DetailData detailData[] = {
                        new DetailData("Hey, I just met you, this is crazy"),
                        new DetailData("At least this balloon is attracted to me!"),
                        new DetailData("I must destroy you with hugs and kisses"),
                        new DetailData("Stop looking for happiness in the same place you just lost it."),
                        new DetailData("I woke up like this"),
                        new DetailData("If we could only turn back time…"),
                        new DetailData("Keep smiling because life is a beautiful thing and there’s so much to smile about."),
                        new DetailData("Beauty is power; a smile is it’s sword"),
                        new DetailData("My autobiography is this"),
                        new DetailData("Last day of class"),
                        new DetailData("Got my coffee and donut"),
                        new DetailData("Proof that I can do selfies better than you"),
                        new DetailData("When your mom lectures you about how you need to lose weight for an hour and your’re like ‘shit i don’t care I have got a skinny mirror to make me look good’!"),
                        new DetailData("A friend will always make you Smile, specially when you don’t want to…"),
                        new DetailData("Life is like a balloon..If you never let go, you will not know how high can you rise."),
                        new DetailData("Sometimes life can surprise you with a happy coincidence."),
                        new DetailData("You can’t afford my Swag!"),
                        new DetailData("This is to the Echos of our laughter. The looks That we Share. The never ending gossips. and the Sudden amazing get aways. This is to our Past And This is to Our Future. This is to our Friendship that will Never Fade."),
                        new DetailData("Life isn’t perfect..But my Hair is! #selfieaddict"),
                        new DetailData("Always classy, never trashy, and a little bit sassy.")
                };
                adapter =  new DetailDataAdapter(detailData, this);
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