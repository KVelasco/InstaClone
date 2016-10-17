# InstaClone

## Getting Started

### Prerequisities

You will need 

* Android Studio 
* Android SDK
* Gradle 
* Java 8
* An Android device or emulator


### Installing

Install Homewbrew by pasting the following command in the terminal 

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

Install Java 8 

```
brew update
brew cask install java
```

Install Gradle 

```
brew install gradle
```

Install Android Studio and SDK Tool 

```
https://developer.android.com/studio/index.html
```

Once you have the above done you can clone the repo and open in it Android Studio. 


## Running the app

You'll need an Android device or emulator to be able to run the application. If you have an Android device simply plugin the device to your computer and hit run but make sure your device has developer options and USB debugging enabled To enabled developer options and USB debugging you can follow the link below 

```
http://www.howtogeek.com/129728/how-to-access-the-developer-options-menu-and-enable-usb-debugging-on-android-4.2/
```

Once you have enabled developer and options and USB debugging simply hit run in Android studio to run the app

Otherwise you will need an Android emulator. You can follow the link below for instructions on to install the official Android emulator 

```
https://developer.android.com/studio/run/managing-avds.html
```

Once you have an emulator you can simple start the emulator and hit run in Android studio to start the app 

##Libraries 

Libraries that this app uses: 

* [Retrofit](http://square.github.io/retrofit/) - A type-safe REST client for Android and Java
* [OkHttp](http://square.github.io/okhttp/) - An HTTP & SPDY client for Android and Java applications
* [RxJava](https://github.com/ReactiveX/RxJava) - Reactive Extensions for the JVM 
* [ButterKnife](https://github.com/JakeWharton/butterknife) - Bind Android views and callbacks to fields and methods
* [Picasso](https://github.com/square/picasso) -  powerful image downloading and caching library for Android
* [Dagger 2](http://google.github.io/dagger/) - Dagger is a fully static, compile-time dependency injection framework for both Java and Android.
* [Gson] (https://github.com/google/gson) - A Java serialization/deserialization library that can convert Java Objects into JSON and back
* [Retro Lambda] (https://github.com/evant/gradle-retrolambda) - A gradle plugin for getting java lambda support in java 6, 7 and android

##Breakdown of the application 

InstaClone is a simple Android which uses the Instagram API to get a list of media based on a location. The location is hardcoded in the app and is set to San Francisco. If we wanted to get the location of the user we would have to set the location persmission in the mainfest and then ask for that persmission at runtime but for the sake of making things simle we just harcode the location. You are also able to like any of the photos that appear in the feed by hitting a like button. the app will change the status of photo when clicking the button.

I used a few libraries to speed up the development of this simple application. Rerofit/OkHttp/RxJava were used on the networking layer. This allowed me to REST calls in a easy fashion that also allows to handle errors in a nice way. 

ButterKnife was used to avoid the boilerplate that is findViewByID()

Retrolamda was used to just get the sugar syntax of lambdas from Java 8 

Gson was used to not have to manually parse the JSON from the calls myself. 

Picasso was used from image loading.

Dagger 2 was used for DI to create the singletons on the network layer and the dependencies they rely in a nice fashion 



