# Navi

*Hey, listen!*

Adds listeners for `Activity` and `Fragment`.

## WARNING

If you can't tell, this is a work in progress! It's not even alpha and you shouldn't use it.

It's open for comments, feedback, etc. but most likely everything will change.

## Why?

In a word: **composition**.

**For applications**, you currently have to tie a lot of your functionality directly to each `Activity` and `Fragment`. The potential for code reuse is low. Testing is difficult.

**For libraries**, if you want to interact with the `Activity` or `Fragment` at all, good luck. You either have to leave brittle instructions on how to properly implement the library, or you provide your own `Activity`/`Fragment`. Two libraries with the same problem are difficult (or impossible) to use together.

With Navi, you can avoid all these problems. Applications can decouple your code from the underlying `Activity` or `Fragment`. Libraries using Navi can write real plugins instead of brittle/coupled solutions.

## Usage

`NaviActivity` and `NaviFragment` are the basis for everything; you can add/remove listeners for
any specific callbacks that exist on `Activity` and `Fragment`.

Implementing the interface yourself would be a pain, so Navi provides default
implementations for both in `AbstractNaviActivity`, `AbstractNaviFragment` and
`AbstractDialogNaviFragment`.

Since RxJava is the bees knees, it also provides Rx bindings for all listeners via `RxNaviActivity`
and `RxNaviFragment`. Simply pass your `NaviActivity` or `NaviFragment` to them and it'll do the
rest. For example, you could use it to set the content view instead of overriding `onCreate()`:

```java
RxNaviActivity.creating(naviActivity)
    .subscribe(bundle -> setContentView(R.layout.main));
```

## Issues

- How do we handle events like `Fragment.onCreateView()`? Obviously we can't have multiple listeners returning `Views` they all want to be the `Fragment`. However, if we don't at least provide the option then it's not possible to create an entirely listener-based `Fragment`.

## Plans

- Gather feedback
- Implement more listeners
- Remove reliance on RxJava for base lib
- Split up lib into components:
    - Base listener activities/fragments
    - AppCompat listener activities/fragments
    - Rx support


## Installation

You'll just have to compile it yourself for now!

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