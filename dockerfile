# Utilise une image de base avec Java (OpenJDK 21)
FROM openjdk:21

# Crée un dossier de travail dans le conteneur
WORKDIR /app

# Copie tous les fichiers dans ce dossier
COPY . .

# Compile le fichier Java
RUN javac src/main/student/StudentApplication.java

# Lance l'application
CMD ["java","-cp","src","main","student", "StudentApplication"]