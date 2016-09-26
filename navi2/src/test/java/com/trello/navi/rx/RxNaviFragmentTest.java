package com.trello.navi.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.Event;
import com.trello.navi.internal.NaviEmitter;
import com.trello.navi.model.ActivityResult;
import com.trello.navi.model.RequestPermissionsResult;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import static com.trello.navi.TestUtils.setSdkInt;
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
    testObserver.assertNotTerminated();
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
    testObserver.assertNotTerminated();
  }


  @Test public void observeCreate() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.CREATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    testObserver.dispose();
    emitter.onCreate(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeCreateView() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.CREATE_VIEW).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreateView(bundle);
    testObserver.dispose();
    emitter.onCreateView(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeActivityCreated() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.ACTIVITY_CREATED).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onActivityCreated(bundle);
    testObserver.dispose();
    emitter.onActivityCreated(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeViewStateRestored() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.VIEW_STATE_RESTORED).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onViewStateRestored(bundle);
    testObserver.dispose();
    emitter.onViewStateRestored(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeStart() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.START).test();
    testObserver.assertNoValues();

    emitter.onStart();
    testObserver.dispose();
    emitter.onStart();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeResume() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.RESUME).test();
    testObserver.assertNoValues();

    emitter.onResume();
    testObserver.dispose();
    emitter.onResume();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observePause() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.PAUSE).test();
    testObserver.assertNoValues();

    emitter.onPause();
    testObserver.dispose();
    emitter.onPause();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeStop() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.STOP).test();
    testObserver.assertNoValues();

    emitter.onStop();
    testObserver.dispose();
    emitter.onStop();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDestroyView() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.DESTROY_VIEW).test();
    testObserver.assertNoValues();

    emitter.onDestroyView();
    testObserver.dispose();
    emitter.onDestroyView();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDestroy() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.DESTROY).test();
    testObserver.assertNoValues();

    emitter.onDestroy();
    testObserver.dispose();
    emitter.onDestroy();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDetach() {
    TestObserver<Void> testObserver = RxNavi.observe(emitter, Event.DETACH).test();
    testObserver.assertNoValues();

    emitter.onDetach();
    testObserver.dispose();
    emitter.onDetach();

    testObserver.assertValue(null);
    testObserver.assertNotTerminated();
  }

  @Test public void observeSaveInstanceState() {
    TestObserver<Bundle> testObserver = RxNavi.observe(emitter, Event.SAVE_INSTANCE_STATE).test();
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    testObserver.dispose();
    emitter.onSaveInstanceState(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeConfigurationChanged() {
    TestObserver<Configuration> testObserver = RxNavi.observe(emitter, Event.CONFIGURATION_CHANGED).test();
    testObserver.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    testObserver.dispose();
    emitter.onConfigurationChanged(configuration);

    testObserver.assertValue(configuration);
    testObserver.assertNotTerminated();
  }

  @Test public void observeActivityResult() {
    TestObserver<ActivityResult> testObserver = RxNavi.observe(emitter, Event.ACTIVITY_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    testObserver.dispose();
    emitter.onActivityResult(requestCode, resultCode, data);

    testObserver.assertValue(new ActivityResult(requestCode, resultCode, data));
    testObserver.assertNotTerminated();
  }

  @Test public void observeRequestPermissionsResult() {
    TestObserver<RequestPermissionsResult> testObserver = RxNavi.observe(emitter, Event.REQUEST_PERMISSIONS_RESULT).test();
    testObserver.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    testObserver.dispose();
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testObserver.assertValue(
        new RequestPermissionsResult(requestCode, permissions, grantResults));
    testObserver.assertNotTerminated();
  }
}
