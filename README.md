# Movie Catalogue System

A Movie Catalogue System built with Java Spring Boot, integrating The Movie Database (TMDb) API to display trending movies, allow users to search for movies, and save their favorite movies. The system uses Thymeleaf for rendering dynamic views, and an in-memory H2 database to store user favorites.

## 🖥️ Features

- **Movie Listing**: Fetches a list of popular movies from the TMDb API and displays them on the homepage.
- **Movie Search**: Allows users to search for movies by title.
- **Movie Detail View**: Displays detailed information about a selected movie, including title, poster, overview, rating, and release date.
- **Favorites Management**: Users can mark movies as favorites and view/manage their favorite movies.
- **In-memory Database**: Favorite movies are stored in an H2 database that is used for this project.

# Demo

Here’s a short demo of the application:

![Demo Video](assets/demovideo.avi)

## 🛠️ Technology Stack

- **Backend**: Java with Spring Boot
- **Frontend**: Thymeleaf for rendering dynamic HTML views
- **Database**: H2 in-memory database
- **API Integration**: TMDb API (https://www.themoviedb.org/documentation/api)
- **Dependencies**:
  - Spring Boot
  - Spring Data JPA
  - Thymeleaf
  - RestTemplate (for API calls)
  - H2 Database

## 📦 Project Setup

Follow these steps to run the project locally:

### Prerequisites

- **Java 11+**: Ensure that you have Java 11 or later installed on your system.
- **Maven**: Ensure Maven is installed for managing project dependencies (or use Gradle if preferred).
- **API Key**: You need a valid TMDb API key to fetch movie data. Sign up [here](https://www.themoviedb.org/signup) to get an API key.

### Step 1: Clone the Repository

```bash
git clone https://github.com/manavpatel1310/Movie-search-Final-Project.git
cd Movie-search-Final-Project

