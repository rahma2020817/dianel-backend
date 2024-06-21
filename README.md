# dianel

# Keycloak and PostgreSQL Docker Compose Setup

This repository provides a Docker Compose setup to run Keycloak with a PostgreSQL database. This setup is ideal for development and testing purposes.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Getting Started

Follow these instructions to get the project up and running.

### Clone the Repository

```bash
git clone <your-repository-url>
cd <your-repository-directory>
```

### Configuration

By default, the configuration provided should work out of the box. However, if you need to customize settings such as database credentials or Keycloak configurations, you can modify the `docker-compose.yml` file.

#### `docker-compose.yml` Overview

```yaml
version: '3.8'

services:
  keycloak:
    image: jboss/keycloak:latest
    container_name: keycloak
    environment:
      - DB_VENDOR=postgres
      - DB_ADDR=postgres
      - DB_DATABASE=keycloak
      - DB_USER=keycloak
      - DB_PASSWORD=password
      - KEYCLOAK_USER=admin
      - KEYCLOAK_PASSWORD=admin
    ports:
      - 8080:8080
    depends_on:
      - postgres

  postgres:
    image: postgres:latest
    container_name: postgres
    environment:
      - POSTGRES_DB=keycloak
      - POSTGRES_USER=keycloak
      - POSTGRES_PASSWORD=password
    ports:
      - 5432:5432
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

### Start the Services

To start the services, run the following command:

```bash
docker-compose up -d
```

This command will download the necessary Docker images (if not already available locally) and start the Keycloak and PostgreSQL containers in detached mode.

### Access Keycloak

Once the services are up and running, you can access the Keycloak administration console at:

```
http://localhost:8080
```

Login with the default credentials:

- **Username:** admin
- **Password:** admin

### Stop the Services

To stop the running containers, use:

```bash
docker-compose down
```

## Persistent Data

The PostgreSQL data is stored in a Docker volume named `postgres_data`. This ensures that your data persists even if the containers are stopped or removed.

## Customization

### Changing Keycloak Admin Credentials

If you want to change the default Keycloak admin credentials, modify the following environment variables in the `keycloak` service definition in `docker-compose.yml`:

```yaml
- KEYCLOAK_USER=<your-username>
- KEYCLOAK_PASSWORD=<your-password>
```

### Changing PostgreSQL Credentials

Similarly, to change the PostgreSQL credentials, modify the corresponding environment variables in the `postgres` service definition in `docker-compose.yml`:

```yaml
- POSTGRES_DB=<your-database>
- POSTGRES_USER=<your-username>
- POSTGRES_PASSWORD=<your-password>
```

## Troubleshooting

If you encounter any issues, check the logs of the containers to diagnose problems:

```bash
docker-compose logs keycloak
docker-compose logs postgres
```
