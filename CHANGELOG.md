# Changelog

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