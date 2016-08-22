---
title: Open Blank Links
description: Open Blank an in-app browser window.
---

Quick and dirty solution to the issue of opening links from iframes into an inapp browser instead of going back into the app.

Only support for iOS and Android, and it's specifically set up to capture ad links from inline google ad placements.

If you are going to use this you'll need to modify the android file to check for something in the url, since it has no way of testing the target of the link.

Not an issue in iOS though, you can check the target.
