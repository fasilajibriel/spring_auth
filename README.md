# Spring Auth Application

## Getting Started

This project organizes the source code using a feature-based layout. After refactoring,
verify the application builds and runs:

```bash
mvn clean package
```

Run the application and ensure authentication and role management endpoints work as expected.

<!-- AUTO-GEN-API-DOCS -->
## Table of Contents
- [AuthController](#authcontroller)
- [RolesController](#rolescontroller)
- [UserController](#usercontroller)
- [Error model & pagination](#error-model--pagination)

## AuthController
### POST /login
**Description:** Login

**Request JSON example**
```json
{
  "email": "user@example.com", // string
  "password": "string" // string
}
```
**Response JSON example**
```json
{
  "token": "jwt-token" // string
}
```
**Status codes:** 200

**Security:** None

## RolesController
### GET /roles
**Description:** Get Roles

**Response JSON example**
```json
[
  {
    "id": "uuid", // UUID
    "name": "string" // string
  }
]
```
**Status codes:** 200

**Security:** JWT Bearer

### GET /roles/{id}
**Description:** Get Role

**Response JSON example**
```json
{
  "id": "uuid", // UUID
  "name": "string", // string
  "scopes": [
    { "id": "uuid", "name": "string" }
  ],
  "permissions": [
    { "id": "uuid", "name": "string" }
  ]
}
```
**Status codes:** 200, 404

**Security:** JWT Bearer

### POST /roles
**Description:** Create Role

**Request JSON example**
```json
{
  "name": "string", // string
  "scopes": [
    { "id": "uuid" }
  ],
  "permissions": [
    { "id": "uuid" }
  ]
}
```
**Response JSON example**
```json
{
  "id": "uuid", // UUID
  "name": "string", // string
  "scopes": [
    { "id": "uuid", "name": "string" }
  ],
  "permissions": [
    { "id": "uuid", "name": "string" }
  ]
}
```
**Status codes:** 201

**Security:** JWT Bearer

### POST /roles/{id}/permissions
**Description:** Update Permissions

**Request JSON example**
```json
{
  "permissions": [
    { "id": "uuid" }
  ]
}
```
**Response JSON example**
```json
{
  "id": "uuid", // UUID
  "name": "string", // string
  "scopes": [
    { "id": "uuid", "name": "string" }
  ],
  "permissions": [
    { "id": "uuid", "name": "string" }
  ]
}
```
**Status codes:** 200

**Security:** JWT Bearer

## UserController
### GET /api/me
**Description:** Get Me

**Response JSON example**
```json
{
  "id": "uuid", // UUID
  "email": "user@example.com" // string
}
```
**Status codes:** 200

**Security:** JWT Bearer

### GET /api/me/access-info
**Description:** Get Access Info

**Response JSON example**
```json
[
  {
    "accessScope": "string", // string
    "permissions": ["string"] // list<string>
  }
]
```
**Status codes:** 200

**Security:** JWT Bearer

## Error model & pagination
**ApiError**
```json
{
  "timestamp": "2023-01-01T12:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/path"
}
```
**Page<T> wrapper**
```json
{
  "content": [],
  "totalElements": 0,
  "totalPages": 0,
  "size": 20,
  "number": 0
}
```
