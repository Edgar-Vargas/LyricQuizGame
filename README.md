Here's a README for all the classes from our entire conversation:

---

# Lyric Game 

## Overview

The Lyric Game API is designed to manage a collection of songs and their lyrics for use in a quiz-style game. It allows users to retrieve random lyrics from songs, select lines from lyrics, and manage song data.

## Classes

### 1. LyricGameMain

This class serves as the entry point for the Lyric Game API. It contains the main method to start the application.

#### Responsibilities:
- Initialize and run the Spring Boot application.
- Manage song data and interactions.

### 2. FileManager

FileManager is responsible for handling file operations, such as reading song files, storing songs, and managing the file system.

#### Responsibilities:
- Read song files from a specified folder.
- Store songs in a designated directory.
- Retrieve a list of files and their corresponding lyrics.
- Generate and save random lyrics for each song.

### 3. Song

The Song class represents a single song in the Lyric Game API.

#### Responsibilities:
- Store song metadata, such as name and lyrics.

### 4. SaveRandomFile

This class is responsible for saving randomly selected lyrics to files.

#### Responsibilities:
- Write randomly selected lyrics to files for each song.

### 5. LineSelect

LineSelect is responsible for selecting random lines from a list of lyrics.

#### Responsibilities:
- Select a specified number of random lines from a list of lyrics.

### 6. Home HTML and JavaScript
The Home HTML and JavaScript classes are responsible for creating and handling the home page of the Lyric Quiz application.

### 7. Quiz HTML and JavaScript
The Quiz HTML and JavaScript classes are responsible for creating and handling the quiz page of the Lyric Quiz application.

Responsibilities:
Display quiz questions and answer options.
Allow users to select answers and submit their choices.
Update scores and question counts based on user interactions.

### 8. Score HTML and JavaScript
The Score HTML and JavaScript classes display the final score of the quiz and allow users to return to the home page.

## Usage

1. Start the Lyric Game API by running the `LyricGameMain` class.
2. Use the `FileManager` class to manage song files and lyrics.
3. Utilize the `SaveRandomFile` class to save randomly selected lyrics to files.
4. Use the `LineSelect` class to select random lines from a list of lyrics.

## Dependencies

- Spring Boot: Used to create and run the API application.
- Apache Commons Lang: Utilized for string manipulation utilities.

## Contributors

- [Your Name]
- [Your Organization]

## License

[License Information]

---

Feel free to customize this README with additional details, such as installation instructions, API endpoints, or any other relevant information specific to your project.
