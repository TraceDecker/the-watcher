## Current State

### Completion
 The user can See current location on home page, and can navigate to pins and restrictions. The floating action button takes user to the app selecting view, allowing them to select the apps they want to restrict. This view shows icons. User can select multiple apps, and the "NEXT" button takes them to the restriction view for setting the restrictions. The "DONE" button takes the user back to home fragment.

### Deficiencies

* Restriction list that will show up if any restrictions are at the current location does not populate from database.

* Pins view contains necessary components to show map of all pins and list, but no function code to populate it.

* Restriction view contains some code to populate, insufficient for implementation.

* Google sign in OAuth 2.0 and user creation views have been created and user can sign in with Oauth, but the project does not contain the functional code to take the received data and insert it into the database. Not accessible in current state.

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
