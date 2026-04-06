# EcomGestion — Spring Boot + React

Application de gestion e-commerce complète avec CRUD pour **Catégories**, **Fournisseurs** et **Produits**.

---

## 🏗️ Architecture

```
ecommerce/
├── backend/          ← Spring Boot 3.2, Java 17, H2 DB
│   └── src/main/java/com/ecommerce/
│       ├── model/         (Categorie, Fournisseur, Produit)
│       ├── repository/    (JpaRepository)
│       ├── service/       (Business logic)
│       ├── controller/    (REST API)
│       └── DataInitializer.java  (données de démo)
└── frontend/         ← React 18, React Router, Axios
    └── src/
        ├── components/  (Sidebar, Modal, FormFields, UI)
        ├── pages/       (Dashboard, Categories, Fournisseurs, Produits)
        └── services/    (api.js — couche axios)
```

---

## 🚀 Démarrage rapide

### 1. Backend (Spring Boot)

**Prérequis :** Java 17+, Maven 3.8+

```bash
cd ecommerce/backend
mvn spring-boot:run
```

Le backend démarre sur **http://localhost:8080**  
Console H2 : **http://localhost:8080/h2-console** (URL: `jdbc:h2:mem:ecommercedb`)

### 2. Frontend (React)

**Prérequis :** Node.js 18+, npm

```bash
cd ecommerce/frontend
npm install
npm start
```

Le frontend démarre sur **http://localhost:3000**

---

## 🌐 API REST

### Catégories
| Méthode | Endpoint              | Description           |
|---------|-----------------------|-----------------------|
| GET     | /api/categories       | Liste toutes          |
| GET     | /api/categories/{id}  | Détail par id         |
| POST    | /api/categories       | Créer                 |
| PUT     | /api/categories/{id}  | Modifier              |
| DELETE  | /api/categories/{id}  | Supprimer             |

### Fournisseurs
| Méthode | Endpoint                | Description |
|---------|-------------------------|-------------|
| GET     | /api/fournisseurs       | Liste tous  |
| GET     | /api/fournisseurs/{id}  | Détail      |
| POST    | /api/fournisseurs       | Créer       |
| PUT     | /api/fournisseurs/{id}  | Modifier    |
| DELETE  | /api/fournisseurs/{id}  | Supprimer   |

### Produits
| Méthode | Endpoint           | Description |
|---------|--------------------|-------------|
| GET     | /api/produits      | Liste tous  |
| GET     | /api/produits/{id} | Détail      |
| POST    | /api/produits      | Créer       |
| PUT     | /api/produits/{id} | Modifier    |
| DELETE  | /api/produits/{id} | Supprimer   |

---

## 🎯 Fonctionnalités

- ✅ CRUD complet : Catégories, Fournisseurs, Produits
- ✅ Dashboard avec statistiques en temps réel
- ✅ Recherche des produits
- ✅ Relations Produit → Catégorie & Fournisseur
- ✅ Prévisualisation image dans le formulaire produit
- ✅ Confirmations de suppression
- ✅ Notifications toast
- ✅ Données de démo pré-chargées
- ✅ Base de données H2 en mémoire (prête à migrer vers PostgreSQL/MySQL)

---

## 🔄 Migrer vers PostgreSQL

Dans `backend/src/main/resources/application.properties`, remplacer :

```properties
# Remplacer H2 par PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommercedb
spring.datasource.username=postgres
spring.datasource.password=votre_mot_de_passe
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Et ajouter dans `pom.xml` :

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## 📦 Technologies

| Côté | Technologie |
|------|-------------|
| Backend | Spring Boot 3.2, Spring Data JPA, Spring Validation |
| Base de données | H2 (dev) / PostgreSQL (prod) |
| Frontend | React 18, React Router 6, Axios |
| Style | CSS-in-JS custom, Google Fonts (Syne + DM Sans) |
