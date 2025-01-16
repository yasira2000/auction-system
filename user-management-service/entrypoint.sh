#!/bin/bash

if [ -n "$SPRING_DATASOURCE_URL_USER" ]; then
  DB_HOST=$(echo "$SPRING_DATASOURCE_URL_USER" | cut -d '/' -f 3 | cut -d ':' -f 1)
  DB_PORT=$(echo "$SPRING_DATASOURCE_URL_USER" | cut -d ':' -f 2)
  DB_USER="$SPRING_DATASOURCE_USERNAME_USER"
  DB_NAME=$(echo "$SPRING_DATASOURCE_URL_USER" | cut -d '/' -f 4)
else
  echo "Error: No database connection information found."
  exit 1
fi

while ! pg_isready -h "$DB_HOST" -p "$DB_PORT" -U "$DB_USER" -d "$DB_NAME"; do
  echo "Waiting for PostgreSQL to start..."
  sleep 2
done

echo "PostgreSQL is up - starting the application..."
java -jar /app/app.jar