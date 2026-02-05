#!/bin bash
# Simple helper script to build and run a Maven-based Java project.

set -e

echo "[INFO] Building project using Maven..."
mvn clean package

JAR_FILE=$(ls target/*.jar 2>/dev/null | head -n 1 || true)

if [ -z "$JAR_FILE" ]; then
  echo "[ERROR] No JAR file found in target/."
  echo "Make sure there is a Maven project with a valid pom.xml."
  exit 1
fi

echo "[INFO] Running JAR: $JAR_FILE"
java -jar "$JAR_FILE"
