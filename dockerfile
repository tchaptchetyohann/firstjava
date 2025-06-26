# Utilise une image de base avec Java (OpenJDK 21)
#FROM openjdk:21

# Crée un dossier de travail dans le conteneur
#WORKDIR /app

# Copie tous les fichiers dans ce dossier
#COPY . .

# Compile le fichier Java
#RUN javac src/main/java/com/example/student/StudentApplication.java

# Lance l'application
#CMD ["java","-cp","src","main","java","com","example","student", "StudentApplication"]


# Étape 1 : Build avec Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Run avec JDK
FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
