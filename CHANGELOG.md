# Changelog

## 1.0 (2016-08-09)

First and (hopefully) final release of 1.x branch!

This release marks the start of maintenance mode for RxJava 1 support. Future work will be devoted
to supporting RxJava 2. Important bugs may be squashed but new features will have to be
extraordinarily compelling in order to be added.

## 0.2.2 (2016-08-09)

* [#62](https://github.com/trello/navi/pull/62) Added `Event.POST_CREATE` and `Event.POST_CREATE_PERSISTABLE`

## 0.2.1 (2016-07-05)

* [#57](https://github.com/trello/navi/pull/57) Added `Event.VIEW_CREATED` for `Fragments`
* [#54](https://github.com/trello/navi/pull/54) Use `final` modifier for interface implementations
* [#53](https://github.com/trello/navi/pull/53) Add `@CallSuper` annotation on component classes

## 0.2.0 (2016-02-27)

There are a few method signature and behavior changes, so upgrade carefully.

* [#47](https://github.com/trello/navi/pull/47) Added `Type.CREATE_PERSISTABLE`, `Type.SAVE_INSTANCE_STATE_PERSISTABLE` and `Type.RESTORE_INSTANCE_STATE_PERSISTABLE` so that the `ALL` tracker can distinguish between events.

    Also avoided calling `CREATE`, `SAVE_INSTANCE_STATE` and `RESTORE_INSTANCE_STATE` too often in persistable `Activities`.

* [#46](https://github.com/trello/navi/pull/46) Destruction events now emit before their super() calls.
* [#41](https://github.com/trello/navi/pull/41) Removed unnecessary `Event` parameter from `NaviComponent.removeListener()`.
* [#39](https://github.com/trello/navi/pull/39) Added `NaviAppCompatDialogFragment`.

## 0.1.3 (2015-12-03)

* [#24](https://github.com/trello/navi/pull/24) Converted hasEvent() -> handlesEvents()

## 0.1.2 (2015-11-25)

* [#20](https://github.com/trello/navi/pull/20) Added `Event.ALL` for listening to all events

## 0.1.1 (2015-11-09)

* [#16](https://github.com/trello/navi/pull/16) Fixed concurrency problems with add/removing listeners while emitting an event

## 0.1.0 (2015-11-04)

Initial release!