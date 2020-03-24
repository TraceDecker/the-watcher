## Overview

## Description

_This app was designed to improve productivity. It is meant to help users avoid distractions by limiting app usage, and allowing the user to set a specific amount of time they can have access to each app that they choose. Not only can the user restrict apps, but restrictions can be set to specific locations. At each location, different restrictions can be set for the same app. So more/less access may be permitted at different locations_.

_Nowadays, cellphones and technology are a huge part of daily life. With the level of integration of technology in almost everything we do, It can be hard to stay focused and not get drawn in by the scent of new posts or updates. Users can set limitations to exactly what they think will help them and where it will help them the most. Productivity is the goal, not limitation. This app will help you increase productivity, decrease device usage as distractions from work or school, and leave enough time for games and social media elsewhere. This app was inspired by my own flaws, as I often found myself spending anywhere from 30 minutes to hours looking at my phone, watching YouTube or looking at social media. I remember sitting up and realizing how much time I wasted, and thought of all the things I could have been doing with that time._

## Current State

### Completion
 The user can See current location on home page, and can navigate to pins and restrictions. The floating action button takes user to the app selecting view, allowing them to select the apps they want to restrict. This view shows icons. User can select multiple apps, and the "NEXT" button takes them to the restriction view for setting the restrictions. The "DONE" button takes the user back to home fragment.

### Deficiencies

* restriction list that will show up if any restrictions are at the current location does not populate from database.

* Pins view contains necessary components to show map of all pins and list, but no function code to populate it.

* restriction view contains some code to populate, insufficient for implementation.

* Google sign in and user creation views have been created, but do not contain function code to take the received data and insert it into the database. Not accessible in current state.

* Clicking in the navigation drawer and selecting a primary view(i.e., Home, Pins, restrictions) from app select view does not clear app select view.

* System apps are not filtered from app list.

* In the app selecting view, app names are not displayed.  

* Map on home page doesn't automatically find the user on app launch.

### Aesthetic Improvements

* Create cleaner layout for setting restrictions, and add app names to the view.

* Display app names on app selection.

* Expandable map for Pins view to see all pins.

* Create custom style and color scheme.

### functional Stretch Goals

* Add option to search for a location.

* Add option to see all restrictions by app or location, and all locations by app.

* User can set password to change restrictions.

* User can select specific days or time blocks and apply restrictions accordingly.

* Super user capability, allowing restrictions to be set on one device for another device.

## Key Features

* Time limits may be set for certain apps to save you from a 30 minute Facebook binge while you're at work or studying.

* Time limits may be assigned to specific locations, allowing more time for social media and games while the user may be at home, or less/no time while doing more important tasks.

## Later Release Goals:

* Can require administrator credentials to change settings.

* "SafeMode" allows users to set a specific hour in which the settings can be changed.(works best for users who want to increase their own productivity.)

* "Lockdown" while the user is in motion(In vehicle), locks all app functionality, except emergency contacts.

* Device to device connection for superuser control(sorry kids).

## Intended Users

_This app would be for:_

* People who want to increase their daily productivity by limiting device usage in places where more focus is required.

* Parents wanting to monitor and limit their kids device usage at school but maybe not at home.  

* Users who simply want to see how much they user their devices at work or at the gym.

### [User stories](user-stories.md)

## External Services

* Google Maps API [Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/intro) - Service for displaying maps. V.17.0.0

* [Google Sign In Service](https://developers.google.com/identity/protocols/oauth2) Google OAuth 2.0. 

* Android Maps [Utility Library](https://developers.google.com/maps/documentation/android-sdk/utility) - Utilities for android map tools.

* Manifest.permission [Android Permissions](https://developer.android.com/reference/android/Manifest.permission) - Allows the app to use features like location, and is needed to make app restrictions function.

### Permissions

* Access Fine location. Restrictions cannot be set without location access.

* Read External Storage. Apps cannot be selected without external storage access.

* Internet access. Cannot access location without internet.

## Later Release Goals:

* Mapbox [Forward Geocoding](https://docs.mapbox.com/api/search/#geocoding) - Allows the user to search for desired locations for pin dropping.

* [DeviceAdminService](https://developer.android.com/reference/android/app/admin/DeviceAdminService?hl=en) - Allows the app to always run in the background, it also has the ability to disable/enable its own service. MUST use protected Permissions, otherwise device will ignore it.

## Design Documentation

### [Wireframe](wireframe.md)

### [Entity-relationship diagram](erd.md)

### [Data model implementation](data-model.md)
