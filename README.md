## Demo of MVVM (Model View ViewModel) Architecture
### Used to show Communication between two Fragments.
It's very common that two or more fragments in an activity need to communicate with each other. 
Imagine a common case, where we have a fragment in which the user posts some data in a list 
and another fragment that displays the contents of the List.
This case is never trivial as both fragments need to define some interface description, and the owner activity must bind the two together.
In addition, both fragments must handle the scenario where the other fragment is not yet created or visible.
This common pain point can be addressed by using ViewModel objects.
These fragments can share a ViewModel using their activity scope to handle this communication, as illustrated by the following sample code.
Also If the system destroys or re-creates a Activity, any UI-related data you store in them is lost.
For example, our app may include a list of users in one of its activities.
When the activity is re-created on rotation, the new activity has to re-fetch the list of users.
For simple data, the activity can use the onSaveInstanceState() method and restore its data from the bundle in onCreate(),
but this approach is only suitable for small amounts of data that can be serialized then deserialized,
not for potentially large amounts of data like a list of users or bitmaps so in that case ViewModel takes care of that.
##### For more Information read: "https://developer.android.com/topic/libraries/architecture/viewmodel"
##### Download Apk: "https://drive.google.com/open?id=1kTIJS9G7oWmJvdItGceZj7L_lOVdfRk2"
<img src="https://github.com/ashiagarwal73/MVVM_Architecture/blob/master/Screenshot_20190526-205028.png" alt="output" width="250">
