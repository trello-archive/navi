/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trello.navi3.sample;

import android.os.Bundle;
import android.widget.TextView;
import com.trello.navi3.Event;
import com.trello.navi3.NaviComponent;
import com.trello.navi3.component.support.NaviAppCompatActivity;
import com.trello.navi3.rx.RxNavi;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;

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
    RxNavi.observe(naviComponent, Event.CREATE).subscribe(new Consumer<Bundle>() {
      @Override public void accept(Bundle bundle) throws Exception {
        setContentView(R.layout.main);
        counter = (TextView) findViewById(R.id.counter);
      }
    });

    // Counter that operates on screen only while resumed; automatically ends itself on destroy
    RxNavi.observe(naviComponent, Event.RESUME)
        .flatMap(new Function<Object, Observable<Long>>() {
          @Override public Observable<Long> apply(Object ignore) throws Exception {
            return Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(RxNavi.observe(naviComponent, Event.PAUSE));
          }
        })
        .takeUntil(RxNavi.observe(naviComponent, Event.DESTROY))
        .startWith(Observable.just(-1L))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Long>() {
          @Override public void accept(Long count) throws Exception {
            counter.setText("Num seconds resumed: " + (count + 1));
          }
        });
  }
}
