#!/bin/bash

# Check for auction database connection information
if [ -n "$SPRING_DATASOURCE_URL_AUCTION" ]; then
  DB_HOST=$(echo "$SPRING_DATASOURCE_URL_AUCTION" | cut -d '/' -f 3 | cut -d ':' -f 1)
  DB_PORT=$(echo "$SPRING_DATASOURCE_URL_AUCTION" | cut -d ':' -f 2)
  DB_USER="$SPRING_DATASOURCE_USERNAME_AUCTION"
  DB_NAME=$(echo "$SPRING_DATASOURCE_URL_AUCTION" | cut -d '/' -f 4)
else
  echo "Error: No database connection information found for auction service."
  exit 1
fi

while ! pg_isready -h "$DB_HOST" -p "$DB_PORT" -U "$DB_USER" -d "$DB_NAME"; do
  echo "Waiting for PostgreSQL to start..."
  sleep 2
done

echo "PostgreSQL is up - starting the auction service..."
java -jar /app/app.jar