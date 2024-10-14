# Maima Bank Android App

## About the App
**Maima Bank Android App** is a mobile banking application built using Jetpack Compose that provides users with a seamless banking experience. The app connects to the [MaimaBank API](https://github.com/malcolmmaima/maimabank) to enable users to manage their bank accounts, perform transactions, and access detailed account information.

## Stack
- **Jetpack Compose**: Modern toolkit for building native UI.
- **Kotlin**: Primary programming language.
- **MVVM Architecture**: Ensures separation of concerns and enhances testability.
- **Dagger Hilt**: Dependency injection framework.
- **Retrofit**: Networking library for API integration.
- **Room**: Offline persistence library.
- **WorkManager**: Background task management.
- **Coil**: Image loading library.
- **Jetpack Navigation**: Simplifies navigation in the app.
- **Firebase Cloud Messaging (FCM)**: Push notifications and real-time updates.
- **Jetpack Security**: Handles data encryption and security features.

## App Usage
**Login Credentials:**
- **Email**: ...
- **Password**: ...
- **OTP**: ...

Use these credentials to log in, or try other credentials to trigger error handling features.

### Demo Video
_(pending...)_

### Design Reference
Inspired by the design from [Finance Mobile App UI Kit](https://www.figma.com/community/file/1106055934725589367/Finance-Mobile-App-UI-KIT) by Aparna Tati.

## Implemented Features
- **User Authentication**: Sign up, log in, and OTP verification.
- **Account Management**: Create and manage bank accounts.
- **Transaction History**: View and manage transaction records.
- **Fund Transfers**: Securely transfer funds between accounts.
- **Account Statements**: Generate detailed statements for account transactions.
- **Multi-Currency Support**: Handle transfers in different currencies with real-time conversion.
- **Loan Management**: Manage loan accounts, repayments, and interest calculations.
- **Savings Management**: Create and manage savings accounts with interest features.
- **User Profile**: Edit user information, manage security settings, and set up biometric authentication.

## Technical Details
The app is structured using **Clean Architecture** principles, with distinct layers for data, domain, and UI. The app utilizes an **MVVM** (Model-View-ViewModel) pattern for its presentation layer, ensuring responsiveness and a clear separation of concerns.

### App Layers
- **UI Layer**: Contains all UI components built with Jetpack Compose.
- **Domain Layer**: Holds business logic and interacts with the data layer.
- **Data Layer**: Manages data sources, including local Room databases and remote API calls.

## Feature Details
- **User Authentication**: Secure login with email/password and OTP verification.
- **Account Operations**: Users can create accounts, view balances, and perform transactions.
- **Transaction Management**: View transaction history and details with options to filter and search.
- **Multi-Currency Transactions**: Automatically convert currencies using real-time exchange rates.
- **Loan Accounts**: Support for managing loan limits, repayments, and interest calculations.
- **Security Features**: Two-factor authentication, biometric login, and encrypted data storage.

## Used Materials
- [Jetpack Compose Official Documentation](https://developer.android.com/jetpack/compose)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Android MVI Pattern](https://developer.android.com/jetpack/guide)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Room Persistence Library](https://developer.android.com/training/data-storage/room)

## Setup Local Development
To run the Maima Bank Android App locally, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/malcolmmaima/maimabank-android.git
   cd maimabank-android
   ```

2. **Open the project in Android Studio** and sync the Gradle dependencies.
3. **Set up API locally** for the MaimaBank API.
4. **Build and run** the app on an Android emulator or physical device.

### Running the App
To build and run the app:

```bash
./gradlew assembleDebug
```

The APK will be available in the `/app/build/outputs/apk/debug/` directory.

## Testing
### Unit Tests
Run unit tests using:

```bash
./gradlew test
```

### UI Tests
To run UI tests with Espresso:

```bash
./gradlew connectedAndroidTest
```

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request. Ensure to include relevant unit tests for any new features or bug fixes.

1. Fork the repo.
2. Create your feature branch (`git checkout -b feature/my-new-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/my-new-feature`).
5. Open a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
