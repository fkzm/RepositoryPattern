# RepositoryPattern
RepositoryPattern sample in android


Setting up development Environment on Linux
----------------------------------

### Installing JAVA
sudo add-apt-repository ppa:webupd8team/java

sudo apt-get update

sudo apt-get install oracle-java8-installer

### Installing SDK
cd path/to/project

mkdir -p "SDK_HOME/licenses"

echo -e "\n8933bad161af4178b1185d1a37fbf41ea5269c55" > "SDK_HOME/licenses/android-sdk-license"

echo -e "sdk.dir=SDK_HOME" > "./local.properties"

./gradlew assembleDebug

### Installing SDK Tools

wget https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip

sudo apt-get install unzip

unzip sdk-tools-linux-3859397.zip -d SDK_HOME

### Installing emulator image

emulator android 23 google api

wget https://dl.google.com/android/repository/sys-img/google_apis/x86-23_r16.zip

unzip x86-23_r16.zip -d SDK_HOME

### Installing android emulator

wget https://dl.google.com/android/repository/emulator-linux-4266726.zip

unzip emulator-linux-4266726.zip -d SDK_HOME

cd SDK_HOME/tools
./android create avd -n test --package "system-images;android-23;google_apis;x86" --tag "google_apis"

cd SDK_HOME/emulator
./emulator -avd test

cd path/to/project
./gradlew connectedAndroidTest

