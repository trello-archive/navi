package com.trello.navi2.sample;

import android.os.Bundle;
import android.widget.TextView;
import com.trello.navi2.Event;
import com.trello.navi2.NaviComponent;
import com.trello.navi2.component.support.NaviAppCompatActivity;
import com.trello.navi2.rx.RxNavi;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Tiny sample.
 *
 * Don't take this too seriously. This is just a fraction of what could be done with Navi.
 */
public class MainActivity extends NaviAppCompatActivity {

  // This demonstrates we don't necessarily need a reference to the Activity itself in order
  // to hook into its lifecycle; the NaviActivity could be provided by anyone.
  private final NaviComponent naviComponent = this;

  TextView counter;

  public MainActivity() {
    // Instead of using onCreate, we can use Observables
    RxNavi.observe(naviComponent, Event.CREATE).subscribe(new Action1<Bundle>() {
      @Override public void call(Bundle bundle) {
        setContentView(R.layout.main);
        counter = (TextView) findViewById(R.id.counter);
      }
    });

    // Counter that operates on screen only while resumed; automatically ends itself on destroy
    RxNavi.observe(naviComponent, Event.RESUME)
        .flatMap(new Func1<Void, Observable<Long>>() {
          @Override public Observable<Long> call(Void v) {
            return Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(RxNavi.observe(naviComponent, Event.PAUSE));
          }
        })
        .takeUntil(RxNavi.observe(naviComponent, Event.DESTROY))
        .startWith(-1L)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Long>() {
          @Override public void call(Long count) {
            counter.setText("Num seconds resumed: " + (count + 1));
          }
        });
  }
}
