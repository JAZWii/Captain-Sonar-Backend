# Captain Sonar Backend
This is the server project for the making of "Clone of Captain Sonar" board game.
It is built on of SmartFox Server.

Please make sure to install [SFS2X](https://www.smartfoxserver.com/download/sfs2x#p=installer) before trying to run the project.

# Dependencies
`build.gradle` file is configured to handle dependency and deployment for SFS2X but you still need to configure `sfs2xPath`.

Open `build.gradle` and replace the following with your sfs2x installation folder location.
```kotlin
var sfs2xPath: String = "$home/SmartFoxServer_2X/SFS2X"
```
