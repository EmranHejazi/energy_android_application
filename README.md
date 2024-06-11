# Energy App

Welcome to Energy App! This application is designed to provide users with information about various exercises and actions to help them maintain a healthy lifestyle. Whether you're a beginner or an experienced fitness enthusiast, Energy App has something for everyone.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [How to Use](#how-to-use)
4. [Project Structure](#project-structure)
5. [Technical Details](#technical-details)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction

Energy App is an Android application developed to assist users in their fitness journey by providing detailed information about different exercises and actions. The app aims to educate users about proper workout techniques and help them achieve their fitness goals.

## Features

- **Exercise Information**: Browse through a variety of exercises categorized by body parts.
- **Action Details**: View detailed instructions and descriptions for each exercise action.
- **Customizable Settings**: Adjust font size and other settings according to personal preferences.
- **Sleek Design**: Enjoy a modern and intuitive user interface for seamless navigation.
- **Search**:  You can search for every action you need to find in this app.

## How to Use

To use Energy App, follow these simple steps:

1. **Installation**: Download and install the Android studio with the required SDK version.
2. **Launching**: Build the project and wait for launch the application in the emulator or your real android device.
3. **Navigation**: Upon launching the app, you'll be greeted with the splash screen followed by the main screen displaying various exercises.
4. **Exploration**: Tap on any exercise to view detailed actions associated with it.
5. **Settings**: Customize the app settings by accessing the Settings page from the navigation drawer.
6. **About Us**: Learn more about the Energy App and its developers by visiting the About Us page.

### Requirements

- Android device running Android 7.0 (Nougat) or above.
- Minimum SDK version: 27
- Target SDK version: 34

## Project Structure

The project structure is organized as follows:

```plaintext
energy/
|-- app/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- app.emran.energy/
|                   |-- activities/
|                   |-- adapters/
|                   |-- data/
|                   |-- models/
|           |-- res/
|               |-- layout/
|               |-- values/
|               |-- drawable/
|               |-- ...
|-- build.gradle
|-- AndroidManifest.xml
|-- README.md
```

- **activities**: Contains all activity classes responsible for various screens in the app.
- **adapters**: Houses RecyclerView adapters for displaying data.
- **data**: Holds data-related classes such as constants and data models.
- **models**: Contains POJO (Plain Old Java Object) classes representing data entities.
- **layout**: XML layout files for defining the UI of each screen.
- **values**: Resource files including strings, colors, and dimensions.

## Technical Details

### Architecture

Energy App follows the Model-View-ViewModel (MVVM) architecture pattern for separation of concerns and efficient data management.

### RecyclerView

The main screen utilizes a RecyclerView to display a list of exercises. Each exercise item is populated dynamically using an adapter.

```mermaid
graph TD;
    A[Activity] --> B[RecyclerView];
    B --> C[Adapter];
    C --> D[ViewHolder];
    D --> E[Item View];
    E --> F[Data Model];
```

#### RecyclerView Functionality

The RecyclerView functions as follows:

| Step        | Description                                              |
|-------------|----------------------------------------------------------|
| 1. Populate | The RecyclerView is populated with exercise items.       |
| 2. Display  | Exercise items are displayed on the main screen.         |
| 3. Interaction | Users can interact with each exercise item to view detailed actions. |

### Splash Screen

A splash screen is implemented to provide users with a smooth transition when launching the app.

```mermaid
sequenceDiagram
SplashScreen->>MainActivity: Show splash screen
MainActivity->>SplashScreen: Transition to main activity
```

### Activity Diagram

Here's a diagram illustrating all activities and their relationships in Energy App:

```mermaid
graph TD;
    SplashScreen --> MainActivity;
    MainActivity --> ContentActivity;
    MainActivity --> ActionsActivity;
    MainActivity --> AboutActivity;
    MainActivity --> SettingsActivity;
    MainActivity --> SplashActivity;
```

### SharedPreferences

SharedPreferences is used in Energy App to store user preferences such as font size and theme color. This allows users to customize their experience within the app.

## Contributing

We welcome contributions from the community! If you'd like to contribute to Energy App, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and submit a pull request.

## License

Energy App is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

Thank you for choosing Emran Hejazi to develop this app! I hope you have a really good presentation for this app. If you have any questions or feedback, please don't hesitate to reach out to me.

**Developed by Emran Hejazi**
























Sure, here's the README file with some added colors to make it more visually appealing:

```markdown
# Energy App

Welcome to Energy App! This application is designed to provide users with information about various exercises and actions to help them maintain a healthy lifestyle. Whether you're a beginner or an experienced fitness enthusiast, Energy App has something for everyone.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [How to Use](#how-to-use)
4. [Project Structure](#project-structure)
5. [Technical Details](#technical-details)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction

Energy App is an Android application developed to assist users in their fitness journey by providing detailed information about different exercises and actions. The app aims to educate users about proper workout techniques and help them achieve their fitness goals.

## Features

- **Exercise Information**: Browse through a variety of exercises categorized by body parts.
- **Action Details**: View detailed instructions and descriptions for each exercise action.
- **Customizable Settings**: Adjust font size and other settings according to personal preferences.
- **Sleek Design**: Enjoy a modern and intuitive user interface for seamless navigation.
- **Search**:  You can search for every action you need to find in this app.

## How to Use

To use Energy App, follow these simple steps:

1. **Installation**: Download and install the Android studio with the required SDK version.
2. **Launching**: Build the project and wait for launch the application in the emulator or your real android device.
3. **Navigation**: Upon launching the app, you'll be greeted with the splash screen followed by the main screen displaying various exercises.
4. **Exploration**: Tap on any exercise to view detailed actions associated with it.
5. **Settings**: Customize the app settings by accessing the Settings page from the navigation drawer.
6. **About Us**: Learn more about the Energy App and its developers by visiting the About Us page.

<details>
  <summary><b>Requirements</b></summary>
  
  - Android device running Android 7.0 (Nougat) or above.
  - Minimum SDK version: 27
  - Target SDK version: 34
</details>

## Project Structure

The project structure is organized as follows:

```
energy/
|-- app/
|   |-- src/
|       |-- main/
|           |-- java/
|               |-- app.emran.energy/
|                   |-- activities/
|                   |-- adapters/
|                   |-- data/
|                   |-- models/
|           |-- res/
|               |-- layout/
|               |-- values/
|               |-- drawable/
|               |-- ...
|-- build.gradle
|-- AndroidManifest.xml
|-- README.md
```

- **activities**: Contains all activity classes responsible for various screens in the app.
- **adapters**: Houses RecyclerView adapters for displaying data.
- **data**: Holds data-related classes such as constants and data models.
- **models**: Contains POJO (Plain Old Java Object) classes representing data entities.
- **layout**: XML layout files for defining the UI of each screen.
- **values**: Resource files including strings, colors, and dimensions.

## Technical Details

### Architecture

Energy App follows the Model-View-ViewModel (MVVM) architecture pattern for separation of concerns and efficient data management.

### RecyclerView

The main screen utilizes a RecyclerView to display a list of exercises. Each exercise item is populated dynamically using an adapter.

```mermaid
graph TD;
    A[Activity] --> B[RecyclerView];
    B --> C[Adapter];
    C --> D[ViewHolder];
    D --> E[Item View];
    E --> F[Data Model];
```

#### RecyclerView Functionality

The RecyclerView functions as follows:

| Step        | Description                                              |
|-------------|----------------------------------------------------------|
| 1. Populate | The RecyclerView is populated with exercise items.       |
| 2. Display  | Exercise items are displayed on the main screen.         |
| 3. Interaction | Users can interact with each exercise item to view detailed actions. |

### Splash Screen

A splash screen is implemented to provide users with a smooth transition when launching the app.

```mermaid
sequenceDiagram
SplashScreen->>MainActivity: Show splash screen
MainActivity->>SplashScreen: Transition to main activity
```

### Activity Diagram

Here's a diagram illustrating all activities and their relationships in Energy App:

```mermaid
graph TD;
    SplashScreen --> MainActivity;
    MainActivity --> ContentActivity;
    MainActivity --> ActionsActivity;
    MainActivity --> AboutActivity;
    MainActivity --> SettingsActivity;
    MainActivity --> SplashActivity;
```

### SharedPreferences

SharedPreferences is used in Energy App to store user preferences such as font size and theme color. This allows users to customize their experience within the app.

## Contributing

We welcome contributions from the community! If you'd like to contribute to Energy App, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and submit a pull request.

## License

Energy App is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

Thank you for choosing Emran Hejazi to develop this app! I hope you have a really good presentation for this app. If you have any questions or feedback, please don't hesitate to reach out to me.

**Developed by Emran Hejazi**
```

This version incorporates some color changes and makes use of collapsible sections for better organization. Feel free to adjust the colors or any other aspect to better suit your preferences!
