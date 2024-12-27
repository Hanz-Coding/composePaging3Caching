NewsApp - News Reader App

NewsApp is a mobile application that allows users to read news from various online sources. 
The app uses modern Android techniques to optimize user experience, including Paging for 
efficient data loading, Retrofit for API communication, Room Database for local storage, 
Dependency Injection with Koin, and MVVM architecture to separate concerns. The code is 
written with Clean Code principles for better maintainability and scalability.

FEATURES

• Read News: Users can view the latest articles from various news sources.

• Paging: Paging is used to load data in pages, saving bandwidth and resources.

• Offline Storage: Local storage using Room Database allows users to read news offline.

• Dependency Injection with Koin: Koin is used to manage dependencies, making the code easier to test and maintain.

• MVVM Architecture: The MVVM pattern ensures a clear separation between the View (UI), ViewModel (logic), and Model (data).

• Clean Code: The code is clean, easy to read, and maintainable.

TECHNOLOGIES USED

• Paging 3: For efficient loading and displaying of paged data.

• Retrofit: For API calls to fetch news data from the server.

• Room Database: For local storage of news data.

• Koin: For Dependency Injection in the app.

• MVVM: Model-View-ViewModel architecture to manage UI and logic separation.

• Coroutines: For asynchronous tasks, preventing UI blocking.

SETUP INSTRUCTION

• Clone the repository:

• git clone https://github.com/Hanz-Coding/composePaging3Caching.git

• Open the project in Android Studio.

• Install dependencies: This project uses Gradle, so you can install all dependencies by syncing the project in Android Studio.

• Run the app: Connect your Android device or use an emulator to run the app.

PROJECT STRUCTURE

• data: Contains classes that manage data, including:

  • remote: Classes for API communication using Retrofit.
  
  • local: Classes for Room Database management.
  
• domain: Contains classes that manage business logic

• presentation: Contains user interface classes, including:

  • view: Activities or Fragments.
  
  • viewmodel: ViewModel classes containing business logic for the UI.
  
• di: Contains Koin modules for Dependency Injection.
