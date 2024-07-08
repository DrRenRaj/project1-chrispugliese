**Overview:**

Project1_S24 is an Android application designed to provide a smooth user experience with functionalities such as task management, user profile management, notifications, settings, and a music player. The app incorporates drawer navigation and bottom navigation.

**Features**

1. Task Management: Create, view, and manage tasks.
2. User Profile: View and edit user profile information.
3. Notifications: Display notifications.
4. Settings: Customize app settings.
5. Music Player: Play and pause music using the built-in music player.
6. Responsive Design: Support for different screen sizes including tablets (sw600dp layout).


**Technologies Used:**

1. Kotlin: The programming language used for Android development. 
2. Jetpack Navigation: For managing navigation between fragments and activities.
3. ViewModel and LiveData: For managing UI-related data in a lifecycle-conscious way.
4. MediaPlayer: For music playback functionality.

**Project Structure:**

Activities:

  MainActivity: Hosts the main navigation logic using drawer and bottom navigation.

  SettingsActivity: Manages app settings.


**Fragments:**
1. HomeFragment: Displays a greeting message.
2. TaskListFragment: Displays a list of tasks.
3. AddTaskFragment: Allows adding a new task.
4. TaskDetailFragment: Displays details of a selected task.
5. ProfileFragment: Displays and edits user profile information.
6. NotificationFragment: Displays notifications.
7. EditProfileFragment: Allows editing the profile.
8. CreateProfileFragment: Allows creating a new profile.
9. MusicPlayerFragment: Manages music playback.
   
**Installation and Setup**

Clone the repository:

1. git clone https://github.com/chrispugliese/project1_s24.git cd project1_s24


2. Open Android Studio.
3. Click on File -> Open and select the cloned repository folder.
  Build the project:

4. Click on Build -> Make Project or press Ctrl + F9.
  Run the project:

5. Click on the Run button or press Shift + F10.
**Usage**
Navigation:

Use the drawer navigation to access Home, Profile, Notifications, and Settings.

Use the bottom navigation to switch between Home, Tasks, and Music Player.

Task Management:

Add new tasks using the "Add Task" button in the Task List Fragment.
View task details by selecting a task from the list.
Edit and delete tasks as needed.

Profile Management: View and edit profile information in the Profile Fragment.

Music Player: Play and pause music using the buttons in the Music Player Fragment.

****ENJOY!****
