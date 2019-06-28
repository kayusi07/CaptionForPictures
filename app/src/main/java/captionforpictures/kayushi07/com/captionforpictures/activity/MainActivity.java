package captionforpictures.kayushi07.com.captionforpictures.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import captionforpictures.kayushi07.com.captionforpictures.R;
import captionforpictures.kayushi07.com.captionforpictures.fragments.FragmentSingle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if(fragment == null){
            fragment = FragmentSingle.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }


    }


}
