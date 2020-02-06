## Overview

## Description
_Nowadays, cellphones and technology are a huge part of daily life. But it can be easy to get carried away and lose focus of the task at hand. This app can monitor app usage at locations marked by pins on a map, and time limits may be set for specific apps, at specific locations. Productivity is the goal, not limitation. This app will help you increase productivity, decrease device usage as distractions from work or school, and leave enough time for games and social media elsewhere._

## Key Features

* Time limits may be set for certain apps to save you from a 30 minute Facebook binge while you're at work or studying.

* Time limits may be assigned to specific locations, allowing more time for social media and games while the user may be at home, or less/no time while doing more important tasks.

* Can require administrator credentials to change settings.

* "SafeMode" allows users to set a specific hour in which the settings can be changed.(works best for users who want to increase their own productivity.)

## Later Release Goals:

* "Lockdown" while the user is in motion(In vehicle), locks all app functionality, except emergency contacts.

* Device to device connection for superuser control(sorry kids).

## Intended Users

_This app would be for:_

* People who want to increase their daily productivity by limiting device usage in places where more focus is required.

* Parents wanting to monitor and limit their kids device usage at school but maybe not at home.  

* Users who simply want to see how much they user their devices at work or at the gym.

### [User stories](user-stories.md)

## External Services

* [Mapbox](https://docs.mapbox.com/api/maps/) - Mapping Service.

* Mapbox [Forward Geocoding](https://docs.mapbox.com/api/search/#geocoding) - Allows the user to search for desired locations for pin dropping.

* Manifest.permission_group [ACTIVITY_RECOGNITION](https://developer.android.com/reference/android/Manifest.permission_group) - Allows the app to use features like location and needed to make app restrictions.

* [DeviceAdminService](https://developer.android.com/reference/android/app/admin/DeviceAdminService?hl=en) - Allows the app to always run in the background, it also has the ability to disable/enable its own service. MUST use protected Permissions, otherwise device will ignore it.

* App will require location to function properly and internet connection to search for new locations for pins.

## Design Documentation

### [Wireframe](wireframe.md)

### [Entity-relationship diagram](erd.md)
