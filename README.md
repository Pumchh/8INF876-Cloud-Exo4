# 8INF876-Cloud-Exo4

Projet réalisé dans le cadre du cours **8INF876 – Conception et architecture des systèmes d’infonuagique (UQAC)**.  
L’objectif est d’implémenter une version simplifiée du **protocole HTTP** (client et serveur) en Java, via des **sockets TCP**.

## 📝 Description

Le projet comprend deux programmes :

- **Client HTTP** :  
  Se connecte à un serveur web (local ou distant), envoie une requête `GET` conforme à la RFC 2616,  
  puis affiche ou sauvegarde la réponse HTML reçue (par ex. `index.html`).

- **Serveur HTTP** :  
  Écoute sur le port 80, reçoit des requêtes HTTP et renvoie :
  - Le fichier demandé (ex. `index.html`) avec le code **200 OK**  
  - Un message d’erreur avec le code **404** si le fichier n’existe pas.

Ces programmes permettent de **simuler la communication HTTP** entre un client et un serveur sans utiliser de frameworks externes.

## 💡 À savoir

Communication via **Socket TCP**.

Respect du format des requêtes et réponses HTTP selon la **RFC 2616**.

Réponses du type :
- `HTTP/1.0 200 OK` → fichier trouvé
- `HTTP/1.0 404 File Not Found` → fichier manquant

## 🧰 Technologies utilisées
- Langage : Java  
- Communication : Sockets TCP  
- Protocole : HTTP/1.0 (RFC 2616)

