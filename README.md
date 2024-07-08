Overview:

Project1_S24 is an Android application designed to provide a smooth user experience with functionalities such as task management, user profile management, notifications, settings, and a music player. The app incorporates drawer navigation and bottom navigation.

Features

    Task Management: Create, view, and manage tasks.
    User Profile: View and edit user profile information.
    Notifications: Display notifications.
    Settings: Customize app settings.
    Music Player: Play and pause music using the built-in music player.
    Responsive Design: Support for different screen sizes including tablets (sw600dp layout).

Technologies Used:

    Kotlin: The programming language used for Android development.
    Jetpack Navigation: For managing navigation between fragments and activities.
    ViewModel and LiveData: For managing UI-related data in a lifecycle-conscious way.
    MediaPlayer: For music playback functionality.

Project Structure:

Activities:

MainActivity: Hosts the main navigation logic using drawer and bottom navigation.

SettingsActivity: Manages app settings.

Fragments:

    HomeFragment: Displays a greeting message.
    TaskListFragment: Displays a list of tasks.
    AddTaskFragment: Allows adding a new task.
    TaskDetailFragment: Displays details of a selected task.
    ProfileFragment: Displays and edits user profile information.
    NotificationFragment: Displays notifications.
    EditProfileFragment: Allows editing the profile.
    CreateProfileFragment: Allows creating a new profile.
    MusicPlayerFragment: Manages music playback.

Installation and Setup

Clone the repository:

    git clone https://github.com/chrispugliese/project1_s24.git cd project1_s24

    Open Android Studio.

    Click on File -> Open and select the cloned repository folder. Build the project:

    Click on Build -> Make Project or press Ctrl + F9. Run the project:

    Click on the Run button or press Shift + F10. Usage Navigation:

Use the drawer navigation to access Home, Profile, Notifications, and Settings.

Use the bottom navigation to switch between Home, Tasks, and Music Player.

Task Management:

Add new tasks using the "Add Task" button in the Task List Fragment. View task details by selecting a task from the list. Edit and delete tasks as needed.

Profile Management: View and edit profile information in the Profile Fragment.

Music Player: Play and pause music using the buttons in the Music Player Fragment.

ENJOY!
