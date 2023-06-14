# JPAdemo

The Student-Teacher Management API provides functionality to create, read, update and delete (CRUD) records and manage their many to many associations.

## API Endpoints for students

### Base URL: /students

### Create a new student
- **Endpoint:** `/students`
- **Method:** `POST`
- **Body:** `StudentDTO`
- **Description:** Adds a new student.

Example:
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "address": "123 Main St"
}
```

### Delete a student
- **Endpoint:** `/students/{studentId}`
- **Method:** `DELETE`
- **Description:** Deletes the student with the provided ID.
- **Return:** A confirmation message.

### Update a student
- **Endpoint:** `/students/{studentId}`
- **Method:** `PUT`
- **Body:** `StudentDTO`
- **Description:** Updates the details of the student with the provided ID.
- **Return:** The updated `StudentDTO`.

Example:
```json
{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "address": "123 Main St"
}
```

### Get a student
- **Endpoint:** `/students/{studentId}`
- **Method:** `GET`
- **Description:** Retrieves the student with the provided ID.
- **Return:** The `StudentDTO`.

### Get all students
- **Endpoint:** `/students`
- **Method:** `GET`
- **Description:** Retrieves all students.
- **Return:** A list of `StudentDTO`.

### Get all teachers for a student
- **Endpoint:** `/students/{studentId}/teachers`
- **Method:** `GET`
- **Description:** Retrieves all teachers associated with the student with the provided ID.
- **Return:** A list of `TeacherDTO`.

### Add a new teacher to a student
- **Endpoint:** `/students/{studentId}/teachers/{teacherId}`
- **Method:** `POST`
- **Description:** Adds the teacher with the provided teacherId to the student with the provided studentId.
- **Return:** A confirmation message.

### Delete a teacher from a student
- **Endpoint:** `/students/{studentId}/teachers/{teacherId}`
- **Method:** `DELETE`
- **Description:** Deletes the association between the student with the provided studentId and the teacher with the provided teacherId.
- **Return:** A confirmation message.

## API Endpoints for teachers

### Base URL: /teachers

### **Create a new teacher**

- **Endpoint:** POST /teachers
- **Body:** TeacherDTO object
- **Function:** Creates a new teacher in the system.

### **Delete a teacher**

- **Endpoint:** DELETE /teachers/{id}
- **Path Variables:** ID of the teacher to be deleted
- **Returns:** ID of the deleted teacher as a String
- **Function:** Deletes an existing teacher in the system.

### **Update a teacher**

- **Endpoint:** PUT /teachers/{id}
- **Path Variables:** ID of the teacher to be updated
- **Body:** TeacherDTO object with updated fields
- **Returns:** TeacherDTO object of the updated teacher
- **Function:** Updates an existing teacher in the system.

### **Get a teacher by ID**

- **Endpoint:** GET /teachers/{id}
- **Path Variables:** ID of the teacher to be retrieved
- **Returns:** TeacherDTO object of the retrieved teacher
- **Function:** Retrieves a specific teacher in the system.

### **Get all teachers**

- **Endpoint:** GET /teachers
- **Returns:** List of TeacherDTO objects representing all teachers in the system.
- **Function:** Retrieves all teachers in the system.

### **Get all students for a teacher**

- **Endpoint:** GET /teachers/{teacherId}/students
- **Path Variables:** ID of the teacher
- **Returns:** List of StudentDTO objects representing all students associated with the teacher.
- **Function:** Retrieves all students associated with a specific teacher in the system.

### **Add a new student to a teacher**

- **Endpoint:** POST /teachers/{teacherId}/students/{studentId}
- **Path Variables:** ID of the teacher and ID of the student
- **Returns:** String message indicating the student was added to the teacher
- **Function:** Associates a student to a teacher in the system.

### **Delete a student from a teacher**

- **Endpoint:** DELETE /teachers/{teacherId}/students/{studentId}
- **Path Variables:** ID of the teacher and ID of the student
- **Returns:** String message indicating the student was removed from the teacher
- **Function:** Removes the association of a student from a teacher in the system.

## Exceptions

### Overview

The `GlobalExceptionHandler` is annotated with `@ControllerAdvice` making it applicable to all controllers in the application. It contains methods for handling exceptions that are thrown across the application. Each method in the class is annotated with `@ExceptionHandler`, specifying the type of exception it can handle.

## Exception Handling Methods

### **Handle PeopleNotFoundException**

- **Exception Type:** `PeopleNotFoundException`
- **Response Status:** 404 NOT FOUND
- **Function:** Handles a `PeopleNotFoundException` which is typically thrown when a requested resource (a person - teacher or student in this context) is not found in the system.
- **Log:** Logs the exception message and type at ERROR level.

### **Handle Any Other Exceptions**

- **Exception Type:** `Exception`
- **Response Status:** 400 BAD REQUEST
- **Function:** Handles any other exception that has not been explicitly handled. This serves as a catch-all handler for any exceptions that the application might throw, but are not already handled.
- **Log:** Logs the exception message and type at ERROR level.

## Response

In case of an exception, the handler constructs an `ErrorResponse` object with the status code, message, and timestamp and sends it in the response with the appropriate HTTP status.

Note that while this class has handlers for `PeopleNotFoundException` and `Exception`, you can add more handlers as needed for other types of exceptions, following the same pattern.

## Logging

We use the Slf4j logging framework with the Logback implementation. The `GlobalExceptionHandler` logs the exception message and type at ERROR level.

And we have the global `RequestLoggingFilter` that logs the request and response payloads at DEBUG level. This filter is applied to all requests and responses in the application.

## Author

Noah  :)

06/14/2023

