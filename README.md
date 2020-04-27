# ToDodo

- Note this was written in Kotlin and I worked on it with Android Studio IDE
- It's based off LinkedIn learning's [Build a Note-taking app](https://www.linkedin.com/learning/building-a-note-taking-app-for-android/) and [Building an Android App with Architecture Components](https://www.linkedin.com/learning/building-an-android-app-with-architecture-components/)

## Step 1: Set up your Database

1. Create a *utils/DBUtils* file that has the following:
    - DATABASE_NAME: String
        - name of db
    - DATABASE_VERSION: Int
        - db version, has to increment each new version
    - TABLE_NOTES: String
        - name of db table
    - NOTE_ID: String
        - when you add data to each table row, it autoincrements the primary key
    - NOTE_TEXT: String
        - text
    - NOTE_CREATED: String
        - marks as a table created
    - TABLE_CREATE: String
        - SQL Query to create a table

2. Create a *DBOpenHelper* file

    - Implement its constructor extending *SQLiteOpenHelper*, it will help with SQL Queries
    - Implement **OnCreate**, creates a DB table is freshly installed
    - Implement **OnUpgrade**, used when the app is upgraded

3. To find out if DB is created successfully
    1. Start up the app with your real device or emulator
    2. In Android Studio IDE, select *Device File Explorer* which SHOULD have your device selected in dropdown
    3. Go to its directory then subdirectory both labelled **data**
    4. Go to the package name (found in *MainActivity* file), mine's was ***com.joshuatheengineer.tododo***
    5. Under the directory **databases**, you should find your SQL Databases

## Step 2: Add some default material design

1. Customize ActionBar.
    - Remove ActionBar via *AndroidManifest*.xml file
    - Separate content of Main Activity XML into *activity_main.xml* and *content_main.xml*

2. Add FloatingActionButton
    - Add FAB actions in *MainActivity.kt* file
    - Add FAB button in *activity_main.xml* file
        - com.google.android.material.floatingactionbutton.FloatingActionButton

3. Create a menu resource file to activate upper menu
    - Add *menu/menu_main.xml* file
    - Add menu selection in *MainActivity.kt* file

4. Add a Vector Asset based on Android's preexisting Add, Edit, Delete, and Check icons
    0. To allow custom assets,
        - go to **build.gradle(app)**
        - set this 'vectorDrawables.useSupportLibrary = true' under 'defaultConfig'
    1. Right Click the **app** directory and choose 'Create New Vector Asset*
    2. Select 'Clip Art' and search for the 'Add button'
    3. I made it #FFFFF or white and renamed it as the *ic_add.xml*
    4. it will be in the **drawable** directory
    5. Repeat steps 1 to 4 with the remaining buttons

5. Adding [Lifecycle and Room dependencies](https://developer.android.com/topic/libraries/architecture/adding-components)

## Step 3: Adding Note List UI

1. Add [Viewbinding](https://developer.android.com/topic/libraries/view-binding) to RecyclerView. Follow link to implement
    - To get it to work, you have to make sure your [Android Studio is upgraded to 3.6.*+](https://stackoverflow.com/questions/57947991/error-could-not-find-method-viewbinding-for-arguments)
    - Optional. In "File > Project Structure > Dependencies > App", click the add button to include latest versions of
        - jakewharton:butterknife
        - jakewharton:butterknife-compiler (added as annotationProcessor)

2. Add a RecyclerView to the *context_main.xml* file.
    - you can use the constraint params from the Hello World textview
    - then remove it
    - set the layout width and height to 0dp

3. Add some Sample data to **utils/SampleData**

4. Add a NoteListItem xml with a NoteEntity data object

5. Added a NoteListAdapter and NoteViewHolder.

## Step (WIP): Create a Content Provider

- A [Content Provider](https://stuff.mit.edu/afs/sipb/project/android/docs/guide/topics/providers/content-provider-creating.html) can help centralize your content so you can manage how different applications access your data.



