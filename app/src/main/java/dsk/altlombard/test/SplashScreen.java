package dsk.altlombard.test;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import dsk.altlombard.test.databinding.SplashBinding;

/**
  для визуализации заставки
  перед запуском приложения(работает совместно с splash.xml(layout))
*/
public class SplashScreen extends AppCompatActivity {

    private long ms=0;
    private long splashTime=2000;
    private boolean splashActive = true;
    private boolean paused=false;

    private SplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SplashBinding.inflate(getLayoutInflater());
        setContentView(R.layout.splash);
        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if(!paused)
                            ms=ms+100;
                        sleep(100);
                    }
                } catch(Exception e) {}
                finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();
    }
}
