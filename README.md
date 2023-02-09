# ManhwaLab
Manhwalab is a revolutionary community page, and a modern library for people with great interest in the culture of japanese mangas, korean manhwas and chinese manhuas. Find your next comic to read here, check out the most popular stuff, and immerse yourself in the statistics and unlimited information provided by us.

# Installation Guide

# Usage
The deployed website is pretty slow, due to the (free) service we are using for deploying, but it should work properly after a few minutes.

Our website is available at https://manhwalab.onrender.com/

It is usable locally, by completing (with your environment variables), and running the start.sh script for the backend, and by the "npm run serve" command for the frontend. It is important to start the backend first. 

# Features

On the deployed version:
- Browse
- Check Comic profile
- Counting views
- Showing most popular comics for the day/week/month ( currently the database resets after a while, soon will be fixed)

On localhost:
- All of the above
- Register/login (JWT)
- Database does not reset

Fixes, optimizations are continously done.


# Tech Stack

## Backend
- Java Spring
- Docker
- PSQL

## Frontend
- Vue
- Pinia
