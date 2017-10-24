
package com.kuruvatech.election;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
//import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kuruvatech.election.fragment.MainFragment;
import com.kuruvatech.election.fragment.ShareAppFragment;
import com.kuruvatech.election.utils.SessionManager;
import com.splunk.mint.Mint;

//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.splunk.mint.Mint;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private DrawerLayout dLayout;
    SessionManager session;
    RelativeLayout navHead;
    TextView name,email,phno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mint.initAndStartSession(this, "49d903c2");
        session = new SessionManager(getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNavigationDrawer();
        setToolBar();
        if (!checkNotificationListenerServiceRunning()) {
            startService(new Intent(this, NotificationListener.class));
        }

    }
    private void setToolBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        View hView =  navView.inflateHeaderView(R.layout.header);
        navHead = (RelativeLayout) hView.findViewById(R.id.profileinfo);
        name = (TextView) hView.findViewById(R.id.myNameHeader);
        phno = (TextView) hView.findViewById(R.id.phNoHeader);
        email = (TextView)hView.findViewById(R.id.eMailHeader);

//        name.setText(session.getName());
//        phno.setText(session.getKeyPhone());
//        email.setText(session.getEmail());

        transaction.replace(R.id.frame, new MainFragment());
        transaction.commit();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                Fragment frag = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.main) {
                    frag = new MainFragment();
                }else if (itemId == R.id.invite) {
                    frag = new ShareAppFragment();
                }
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);
                    transaction.commit();
                    dLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;

        switch(itemId) {

            case android.R.id.home: {
                dLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return false;
    }
    public boolean checkNotificationListenerServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("com.kuruvatech.election.NotificationListener"
                    .equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
