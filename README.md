# Navi

*Hey, listen!*

Adds listeners for `Activity` and `Fragment`.

## Why?

In a word: **composition**.

**For applications**, you currently have to tie a lot of your functionality directly to each `Activity` and `Fragment`. The potential for code reuse is low. Testing is difficult.

**For libraries**, if you want to interact with the `Activity` or `Fragment` at all, good luck. You either have to leave brittle instructions on how to properly implement the library, or you provide your own `Activity`/`Fragment`. Two libraries providing their own components are difficult (or impossible) to use together.

With Navi, you can avoid all these problems. Applications can decouple your code from the underlying `Activity` or `Fragment`. Libraries using Navi can write real plugins instead of brittle/coupled solutions.

## Usage

The `NaviComponent` interface is the basis for everything; you can add/remove listeners for
any specific callbacks that exist on `Activity` and `Fragment`:

```java
naviComponent.addListener(Event.CREATE, new Listener<Bundle>() {
  @Override public void call(Bundle bundle) {
    setContentView(R.layout.main);
  }
});
```

You will either need to implement the `NaviComponent` interface yourself, or if you're able, you
can save time by using one of the default implementations provided (in the form of `NaviActivity`,
`NaviAppCompatActivity`, `NaviFragment` and `NaviDialogFragment`). This flexibility allows you to
integrate Navi even if you're already being forced to use a different base `Activity` or `Fragment`.

Since RxJava is the bees knees, it also provides Rx bindings for all listeners via `RxNavi`. Simply pass your `NaviComponent` to them and it'll do the
rest. For example, you could use it to set the content view instead of overriding `onCreate()`:

```java
RxNavi.observe(naviComponent, Event.CREATE)
    .subscribe(bundle -> setContentView(R.layout.main));
```

## Installation

```gradle
compile 'com.trello:navi:0.1.1'
```

## License

    Copyright (C) 2015 Trello

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.