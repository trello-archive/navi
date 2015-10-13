package com.trello.navi.sample;

import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.trello.navi.NaviActivity;
import com.trello.navi.component.support.AbstractNaviActivity;
import com.trello.navi.model.BundleBundle;
import com.trello.navi.rx.RxNaviActivity;
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
public class MainActivity extends AbstractNaviActivity {

  // This demonstrates we don't necessarily need a reference to the Activity itself in order
  // to hook into its lifecycle; the NaviActivity could be provided by anyone.
  private final NaviActivity naviActivity = this;

  @Bind(R.id.counter) TextView counter;

  public MainActivity() {
    // Instead of using onCreate, we can use Observables
    RxNaviActivity.creating(naviActivity)
        .subscribe(new Action1<BundleBundle>() {
          @Override public void call(BundleBundle bundleBundle) {
            setContentView(R.layout.main);
            ButterKnife.bind(MainActivity.this);
          }
        });

    // Counter that operates on screen only while resumed; automatically ends itself on destroy
    RxNaviActivity.resuming(naviActivity)
        .flatMap(new Func1<Object, Observable<Long>>() {
          @Override public Observable<Long> call(Object o) {
            return Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(RxNaviActivity.pausing(naviActivity));
          }
        })
        .takeUntil(RxNaviActivity.destroying(naviActivity))
        .startWith(-1L)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Long>() {
          @Override public void call(Long count) {
            counter.setText("Num seconds resumed: " + (count + 1));
          }
        });
  }
}
