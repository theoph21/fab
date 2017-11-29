package ke.co.astatech.fab;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    View fabBgLayout;
    boolean isFABOpen=false;
    FloatingActionButton fabEndTrip,fab2,fab3,mainfab;
    LinearLayout fabL1,fabL2,fabL3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      fabBgLayout =findViewById(R.id.fabBgLayoutt);
      fabEndTrip = findViewById(R.id.fabEndTrip);
      fabL1 = findViewById(R.id.fabL1);
      fabL2 = findViewById(R.id.fabL2);
      fabL3 = findViewById(R.id.fabL3);
      fab2 =findViewById(R.id.fab2);
      fab3 = findViewById(R.id.fab3);
      mainfab = findViewById(R.id.mainfab);

      mainfab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (!isFABOpen){
                  showFABMenu();
              }else {
                  closeFABMenu();
              }
          }
      });

      fabBgLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              closeFABMenu();
          }
      });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void showFABMenu(){
        isFABOpen=true;
        fabL1.setVisibility(View.VISIBLE);
        fabL2.setVisibility(View.VISIBLE);
        fabL3.setVisibility(View.VISIBLE);
        fabBgLayout.setVisibility(View.VISIBLE);

        mainfab.animate().rotationBy(180);
        fabL1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabL2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabL3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBgLayout.setVisibility(View.GONE);
        mainfab.animate().rotationBy(-180);
        fabL1.animate().translationY(0);
        fabL2.animate().translationY(0);
        fabL3.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isFABOpen) {
                    fabL1.setVisibility(View.GONE);
                    fabL2.setVisibility(View.GONE);
                    fabL3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
