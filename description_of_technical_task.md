#  Technical task:

## Business model include two entities: "project" and "task", with a one-to-many relationship.

### Entities description:
1. Project is a product. Its have id, name, and tasks that executed on this project.
2. Task have id, type of task (DESIGN, MARKETING, BUSINESS_DEVELOPMENT, PROJECT_MANAGEMENT)

### Technology architecture:
1. Rest api on Java with using Spring Boot
2. Project build - maven
3. DB - postgreSQL