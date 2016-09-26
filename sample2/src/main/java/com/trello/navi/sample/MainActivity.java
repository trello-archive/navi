package com.trello.navi.sample;

import java.util.concurrent.TimeUnit;

import com.trello.navi.Event;
import com.trello.navi.NaviComponent;
import com.trello.navi.component.support.NaviAppCompatActivity;
import com.trello.navi.rx.RxNavi;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Tiny sample.
 *
 * Don't take this too seriously. This is just a fraction of what could be done with Navi.
 */
public class MainActivity extends NaviAppCompatActivity {

  // This demonstrates we don't necessarily need a reference to the Activity itself in order
  // to hook into its lifecycle; the NaviActivity could be provided by anyone.
  private final NaviComponent naviComponent = this;

  @Bind(R.id.counter) TextView counter;

  public MainActivity() {
    // Instead of using onCreate, we can use Observables
    RxNavi.observe(naviComponent, Event.CREATE).subscribe(new Consumer<Bundle>() {
      @Override public void accept(Bundle bundle) throws Exception {
        setContentView(R.layout.main);
        ButterKnife.bind(MainActivity.this);
      }
    });

    // Counter that operates on screen only while resumed; automatically ends itself on destroy
    RxNavi.observe(naviComponent, Event.RESUME)
        .flatMap(new Function<Void, Observable<Long>>() {
          @Override public Observable<Long> apply(Void v) throws Exception {
            return Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(RxNavi.observe(naviComponent, Event.PAUSE));
          }
        })
        .takeUntil(RxNavi.observe(naviComponent, Event.DESTROY))
        .startWith(-1L)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Long>() {
          @Override public void accept(Long count) throws Exception {
            counter.setText("Num seconds resumed: " + (count + 1));
          }
        });
  }
}
