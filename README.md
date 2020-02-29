# Captain Sonar Backend
This is the server project for the making of "Clone of Captain Sonar" board game.
It is built on of SmartFox Server.

Please make sure to install [SFS2X](https://www.smartfoxserver.com/download/sfs2x#p=installer) before trying to run the project.

# Dependencies
`build.gradle` file is configured to handle dependency and deployment for SFS2X but you still need to configure `sfs2xPath`.

Open [build.gradle](build.gradle.kts) and replace the following with your sfs2x installation folder location.
```kotlin
var sfs2xPath: String = "$home/SmartFoxServer_2X/SFS2X"
```

# Project Structure
The project contains two main packages one for game logic and the other for communication with client

## Server Package
Files found in [com.speda.captain.sonar.**server**](src/main/kotlin/com/speda/captain/sonar/server) package are all
related to client-server communication and are all dependent on *SmartFoxServer*.
[Documentation found here](https://doc2x.smartfoxserver.com).

## Game Logic Package
Files found [com.speda.captain.sonar.**game**](src/main/kotlin/com/speda/captain/sonar/game) are related to game
logic and should be able to run a game independently of server package.

Few subpackages can be found game packages _this structure is not final please apply any improvements you think about_.

### Game Board Package ([.baord](src/main/kotlin/com/speda/captain/sonar/game/board))
This package contains models and logic related to game board, settings, map and scenarios

### Game Role Package ([.role](src/main/kotlin/com/speda/captain/sonar/game/role))
This package contains models and logic related players roles (Caption, Radio Operator, FirstMate and Engineer)

### Game Submarine Package ([.submarine](src/main/kotlin/com/speda/captain/sonar/game/submarine))
This package contains models and logic related Submarine

### Game Submarine Package ([.model](src/main/kotlin/com/speda/captain/sonar/game/model))
This package contains models

# Deployment
Run the following command to build SmartFox extension with all its dependencies and copy it to SFS2X extensions directory
```cmd
gradle buildExtension
```