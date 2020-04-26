# ToDodo

- Note this was written in Kotlin and I worked on it with Android Studio IDE
- It's based off LinkedIn learning's Build a [Note-taking app](https://www.linkedin.com/learning/building-a-note-taking-app-for-android/)

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
