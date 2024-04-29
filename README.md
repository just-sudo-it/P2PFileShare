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
