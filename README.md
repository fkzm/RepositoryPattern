# RepositoryPattern
RepositoryPattern sample in android


sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer

bash android.bat
./gradlew assembleDebug

ubuntu
wget https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip

windows
wget https://dl.google.com/android/repository/sdk-tools-windows-3859397.zip

sudo apt-get install unzip

unzip sdk-tools-linux-3859397.zip -d SDK_PATH

emulator android 23 google api
wget https://dl.google.com/android/repository/sys-img/google_apis/x86-23_r16.zip
unzip x86-23_r16.zip -d SDK_PATH

android emulator
wget https://dl.google.com/android/repository/emulator-linux-4266726.zip
unzip emulator-linux-4266726.zip -d SDK_PATH

SDK_PATH/tools ./android create avd -n test --package "system-images;android-23;google_apis;x86" --tag "google_apis"

SDK_PATH/emulator ./emulator -avd test

in repo ./gradlew connectedAndroidTest

