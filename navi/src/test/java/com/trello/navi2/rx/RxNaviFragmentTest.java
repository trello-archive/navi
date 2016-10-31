package com.trello.navi2.rx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi2.Event;
import com.trello.navi2.internal.NaviEmitter;
import com.trello.navi2.model.ActivityResult;
import com.trello.navi2.model.RequestPermissionsResult;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import static com.trello.navi2.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final NaviEmitter emitter = NaviEmitter.createFragmentEmitter();

  @Test public void observeAttach() {
    setSdkInt(21);

    TestObserver<Context> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.ATTACH).subscribe(testObserver);
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

    TestObserver<Context> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.ATTACH).subscribe(testObserver);
    testObserver.assertNoValues();

    Context context = mock(Context.class);
    emitter.onAttach(context);
    testObserver.dispose();
    emitter.onAttach(context);

    testObserver.assertValue(context);
    testObserver.assertNotTerminated();
  }

  @Test public void observeCreate() {
    TestObserver<Bundle> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.CREATE).subscribe(testObserver);
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreate(bundle);
    testObserver.dispose();
    emitter.onCreate(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeCreateView() {
    TestObserver<Bundle> testObserver = new TestObserver<>();

    RxNavi.observe(emitter, Event.CREATE_VIEW).subscribe(testObserver);
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onCreateView(bundle);
    testObserver.dispose();
    emitter.onCreateView(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeActivityCreated() {
    TestObserver<Bundle> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.ACTIVITY_CREATED).subscribe(testObserver);
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onActivityCreated(bundle);
    testObserver.dispose();
    emitter.onActivityCreated(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeViewStateRestored() {
    TestObserver<Bundle> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.VIEW_STATE_RESTORED).subscribe(testObserver);
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onViewStateRestored(bundle);
    testObserver.dispose();
    emitter.onViewStateRestored(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeStart() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.START).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onStart();
    testObserver.dispose();
    emitter.onStart();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeResume() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.RESUME).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onResume();
    testObserver.dispose();
    emitter.onResume();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observePause() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.PAUSE).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onPause();
    testObserver.dispose();
    emitter.onPause();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeStop() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.STOP).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onStop();
    testObserver.dispose();
    emitter.onStop();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDestroyView() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.DESTROY_VIEW).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onDestroyView();
    testObserver.dispose();
    emitter.onDestroyView();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDestroy() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.DESTROY).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onDestroy();
    testObserver.dispose();
    emitter.onDestroy();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeDetach() {
    TestObserver<Object> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.DETACH).subscribe(testObserver);
    testObserver.assertNoValues();

    emitter.onDetach();
    testObserver.dispose();
    emitter.onDetach();

    testObserver.assertValueCount(1);
    testObserver.assertNotTerminated();
  }

  @Test public void observeSaveInstanceState() {
    TestObserver<Bundle> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.SAVE_INSTANCE_STATE).subscribe(testObserver);
    testObserver.assertNoValues();

    Bundle bundle = new Bundle();
    emitter.onSaveInstanceState(bundle);
    testObserver.dispose();
    emitter.onSaveInstanceState(bundle);

    testObserver.assertValue(bundle);
    testObserver.assertNotTerminated();
  }

  @Test public void observeConfigurationChanged() {
    TestObserver<Configuration> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.CONFIGURATION_CHANGED).subscribe(testObserver);
    testObserver.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    emitter.onConfigurationChanged(configuration);
    testObserver.dispose();
    emitter.onConfigurationChanged(configuration);

    testObserver.assertValue(configuration);
    testObserver.assertNotTerminated();
  }

  @Test public void observeActivityResult() {
    TestObserver<ActivityResult> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.ACTIVITY_RESULT).subscribe(testObserver);
    testObserver.assertNoValues();

    int requestCode = 1;
    int resultCode = Activity.RESULT_OK;
    Intent data = new Intent();
    emitter.onActivityResult(requestCode, resultCode, data);
    testObserver.dispose();
    emitter.onActivityResult(requestCode, resultCode, data);

    testObserver.assertValue(ActivityResult.create(requestCode, resultCode, data));
    testObserver.assertNotTerminated();
  }

  @Test public void observeRequestPermissionsResult() {
    TestObserver<RequestPermissionsResult> testObserver = new TestObserver<>();
    RxNavi.observe(emitter, Event.REQUEST_PERMISSIONS_RESULT).subscribe(testObserver);
    testObserver.assertNoValues();

    int requestCode = 1;
    String[] permissions = new String[0];
    int[] grantResults = new int[0];
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    testObserver.dispose();
    emitter.onRequestPermissionsResult(requestCode, permissions, grantResults);

    testObserver.assertValue(
        RequestPermissionsResult.create(requestCode, permissions, grantResults));
    testObserver.assertNotTerminated();
  }
}
