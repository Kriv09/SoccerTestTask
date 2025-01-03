
# SoccerTestTask

This project is a test task for a company, designed to manage soccer player transfers between teams. The backend is implemented using Java with Spring Boot, and it allows for creating soccer transfers, updating them, and viewing the history of transfers.

## Setup Instructions

### 1. **Create the Database**

Before starting the application, you need to create a database. Make sure to set up a relational database (e.g., MySQL or PostgreSQL) and configure the connection settings in the `application.properties` file.

#### Example for MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/soccerdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 2. **Run the Application to Initialize Tables**

After setting up the database, start the Spring Boot application. This will initialize the required tables (`soccer_player`, `soccer_team`, and `soccer_transfer`) in the database.

You can run the application by executing the following command:

```bash
mvn spring-boot:run
```

Once the application starts, the database tables will be automatically created based on the entities defined in the code.

### 3. **Run Test Data Set**

After the tables are initialized, you can run the `TestDataSet.sql` to populate the database with test data. This will insert sample players, teams, and initial balance information into the database.

To run the SQL file:

1. Open your database client (e.g., MySQL Workbench, pgAdmin, or command line).
2. Execute the contents of the `TestDataSet.sql` file to insert test data into your tables.

```sql
-- Example of TestDataSet.sql
INSERT INTO soccer_team (id, name, balance, board) VALUES
(1, 'Red Lions', 500000.00, 1),
(2, 'Blue Falcons', 300000.00, 3),
(3, 'Golden Eagles', 750000.00, 4),
(4, 'Silver Warriors', 200000.00, 7);

INSERT INTO soccer_player (id, age, name, experience, team_id) VALUES
(1, 22, 'Alex Carter', 3, 1),
(2, 28, 'Benjamin Davis', 7, 2),
(3, 25, 'Charlie Evans', 5, 3),
(4, 30, 'Daniel Foster', 8, 4),
(5, 19, 'Ethan Green', 1, 1);
```

### 4. **Import Postman Collection and Run Tests**

To test the application, import the Postman collection available in the project and run the tests.

1. Open Postman.
2. Import the collection from the provided file (e.g., `SoccerTestTask.postman_collection.json`).
3. Ensure the correct environment is set for your application.
4. Run the requests to test creating, updating, and deleting transfers.


### All set ! Hope I have met all your requirements
