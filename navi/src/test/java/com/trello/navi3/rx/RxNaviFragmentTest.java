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

package com.trello.navi3.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi3.Event;
import com.trello.navi3.internal.NaviEmitter;
import com.trello.navi3.model.ActivityResult;
import com.trello.navi3.model.RequestPermissionsResult;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.Test;

import static com.trello.navi3.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final NaviEmitter emitter = NaviEmitter.createFragmentEmitter();

  @Test public void observeAttach() {
    setSdkInt(21);

    TestObserver<Context> testObserver = RxNavi.observe(emitter, Event.ATTACH).test();
    testObserver.assertNoValues();

    Activity activity = mock(Activity.class);
    emitter.onAttach(activity);
    testObserver.dispose();
    emitter.onAttach(activity);

    testObserver.assertValue(activity);
  }

  @Test public void observeAttachApi23() {
    setSdkInt(23);

    TestObserver<Context> testObserver = RxNavi.observe(emitter, Event.ATTACH).test();
    testObserver.assertNoValues();

    Context context = mock(Context.class);
    emitter.onAttach(context);
    testObserver.dispose();
    emitter.onAttach(context);

    testObserver.assertValue(context);
  }

  @Test public void observeCreate() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.CREATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    testObserver.dispose();
    emitter.onCreate(bundle);

    testObserver.assertValue(bundle);
  }

  @Test public void observeCreateView() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.CREATE_VIEW).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreateView(bundle);
    testObserver.dispose();
    emitter.onCreateView(bundle);

    testObserver.assertValue(bundle);
  }

  @Test public void observeActivityCreated() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.ACTIVITY_CREATED).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onActivityCreated(bundle);
    testObserver.dispose();
    emitter.onActivityCreated(bundle);

    testObserver.assertValue(bundle);
  }

  @Test public void observeViewStateRestored() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.VIEW_STATE_RESTORED).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onViewStateRestored(bundle);
    testObserver.dispose();
    emitter.onViewStateRestored(bundle);

    testObserver.assertValue(bundle);
  }

  @Test public void observeStart() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.START).test();
    testObserver.assertNoValues();

    emitter.onStart();
    testObserver.dispose();
    emitter.onStart();

    testObserver.assertValueCount(1);
  }

  @Test public void observeResume() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.RESUME).test();
    testObserver.assertNoValues();

    emitter.onResume();
    testObserver.dispose();
    emitter.onResume();

    testObserver.assertValueCount(1);
  }

  @Test public void observePause() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.PAUSE).test();
    testObserver.assertNoValues();

    emitter.onPause();
    testObserver.dispose();
    emitter.onPause();

    testObserver.assertValueCount(1);
  }

  @Test public void observeStop() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.STOP).test();
    testObserver.assertNoValues();

    emitter.onStop();
    testObserver.dispose();
    emitter.onStop();

    testObserver.assertValueCount(1);
  }

  @Test public void observeDestroyView() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.DESTROY_VIEW).test();
    testObserver.assertNoValues();

    emitter.onDestroyView();
    testObserver.dispose();
    emitter.onDestroyView();

    testObserver.assertValueCount(1);
  }

  @Test public void observeDestroy() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.DESTROY).test();
    testObserver.assertNoValues();

    emitter.onDestroy();
    testObserver.dispose();
    emitter.onDestroy();

    testObserver.assertValueCount(1);
  }

  @Test public void observeDetach() {
    TestObserver<Object> testObserver = RxNavi.observe(emitter, Event.DETACH).test();
    testObserver.assertNoValues();

    emitter.onDetach();
    testObserver.dispose();
    emitter.onDetach();

    testObserver.assertValueCount(1);
  }

  @Test public void observeSaveInstanceState() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.SAVE_INSTANCE_STATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    testObserver.dispose();
    emitter.onSaveInstanceState(bundle);

    testObserver.assertValue(bundle);
  }

  @Test public void observeConfigurationChanged() {
    TestObserver<Configuration> testObserver =
        RxNavi.observe(emitter, Event.CONFIGURATION_CHANGED).test();
    testObserver.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    testObserver.dispose();
    emitter.onConfigurationChanged(configuration);

    testObserver.assertValue(configuration);
  }

  @Test public void observeActivityResult() {
    TestObserver<ActivityResult> testObserver =
        RxNavi.observe(emitter, Event.ACTIVITY_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    testObserver.dispose();
    emitter.onActivityResult(requestCode, resultCode, data);

    testObserver.assertValue(ActivityResult.create(requestCode, resultCode, data));
  }

  @Test public void observeRequestPermissionsResult() {
    TestObserver<RequestPermissionsResult> testObserver =
        RxNavi.observe(emitter, Event.REQUEST_PERMISSIONS_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    testObserver.dispose();
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testObserver.assertValue(
        RequestPermissionsResult.create(requestCode, permissions, grantResults));
  }
}
