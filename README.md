# P2PFileShare
This project implements a simple peer-to-peer (P2P) file sharing system using Java sockets. The system consists of a central Tracker and multiple Peers, allowing file sharing operations among the Peers registered and managed by the Tracker.

## Features

- **User Registration, Login, and Logout**: Peers can register, login, and logout from the system through the Tracker.
- **File Sharing**: Peers share files by notifying the Tracker of the files they possess.
- **File Searching and Downloading**: Peers can query the Tracker for available files and download them from other peers.
- **Concurrency Handling**: The system is capable of handling multiple peer connections simultaneously ensuring thread safety.

## Getting Started

### Prerequisites

- Java JDK 11 or newer
- Network access between all participating machines (if not running locally)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourgithub/p2p-file-sharing.git

2. Navigate to the project directory:
   ```bash
   cd p2p-file-sharing


### Running the Tracker

1. Compile the Java files:
   ```bash
   javac Tracker.java
   
2. Start the Tracker:
   ```bash
   java Tracker
   
 ### Running a Peer

1. Compile the Java files:
   ```bash
   javac Peer.java
   
2. Start the Peer:
   ```bash
   java Peer



## Usage
Register: Peers must register with a unique username to participate.
Login: After registration, peers must login to interact with the system.
Inform and Query: Once logged in, peers must inform the tracker about their files and may query available files.
Download: Peers can download files directly from other peers after querying the Tracker for the required details.

## Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.
To contribute:
1. Fork the project.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## License
Distributed under the MIT License. See `LICENSE` for more information.

## Contact
Project Lead - [just-sudo-it](mailto:lefteris.michailides@gmail.com)

Project Link: [https://github.com/just-sudo-it/P2PFileShare](https://github.com/just-sudo-it/P2PFileShare)
