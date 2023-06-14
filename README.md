# JPAdemo

The Student Management API provides functionality to create, read, update and delete (CRUD) student records and manage their associations with teachers.

## API Endpoints for students

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
