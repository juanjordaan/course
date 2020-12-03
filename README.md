# Getting Started


### Building
* Requires Java 9 and Maven 3
1. ./mvnw clean install
2. ./mvnw spring-boot:run

### H2 Database
 * h2 is available through web browser at http://localhost:8080/h2-console
 * jdbc url = jdbc:h2:file:./data/school
 * username = sa
 * password = password

### Rest API
* All the Controllers are in cloud.jordaan.juan.csg.interfaces.rest


### Usage
1. You create a Course 
2. Then you Create a Term
3. Link the Term and Course to create a CourseTerm
4. Then you can start creating Students
5. Link the Student to a Course to create a StudentCourse
6. Now you can Grade a Student
7. You can also now to Attendance for a Student


* Usage can Also be determined by the Tests
* A student can have Multiple Courses, and be graded and present with them
