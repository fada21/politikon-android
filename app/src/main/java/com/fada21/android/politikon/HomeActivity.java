package com.fada21.android.politikon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fada21.android.politikon.events.EventAdapter;
import com.fada21.android.politikon.events.EventViewModel;
import com.fada21.android.politikon.events.EventViewModelConverter;
import com.fada21.android.politikon.repos.models.Event;
import com.fada21.android.politikon.repos.models.EventData;
import com.fada21.android.politikon.repos.remote.RemotePolitikonRepo;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadData();
                }
            });
        }
        setupNavDrawer(toolbar);
        setupRecyclerView();
        loadData();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.bet_list);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    void loadData() {
        Observable<EventData> events = new RemotePolitikonRepo().getEventsService().getEvents(50);
        final EventViewModelConverter converter = new EventViewModelConverter();
        events.concatMap(new Func1<EventData, Observable<Event>>() {
            @Override public Observable<Event> call(EventData events) {
                return Observable.from(events.results);
            }
        }).map(new Func1<Event, EventViewModel>() {
            @Override public EventViewModel call(Event event) {
                return converter.convert(event);
            }
        }).toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<EventViewModel>>() {
                               @Override public void call(List<EventViewModel> eventViewModels) {
                                   recyclerView.setAdapter(new EventAdapter(eventViewModels));
                               }
                           },
                        new Action1<Throwable>() {
                            @Override public void call(Throwable throwable) {
                                Snackbar.make(fab, "Internety nie działajo :(", Snackbar.LENGTH_LONG)
                                        .setAction("Odświeżamy?", new View.OnClickListener() {
                                            @Override public void onClick(View view) {
                                                loadData();
                                            }
                                        }).show();
                            }
                        });
    }

    private void setupNavDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.home, menu);
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
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
