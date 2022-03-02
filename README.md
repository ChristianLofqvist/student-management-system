## Laboration 2

### JSON FORMAT
{\
"id": 1,\
"name": "Math",\
"students": [\
{\
"email": "test@test.com",\
"firstName": "ABC",\
"id": 2,
"lastName": "XYZ",\
"phoneNumber": "1234567891"\
},\
{\
"email": "test2@test.com",\
"firstName": "123",\
"id": 1,\
"lastName": "456",\
"phoneNumber": "1234567891"\
}\
],\
"teacher": {\
"firstName": "Test",\
"id": 1,\
"lastName": "Testson"\
}\
}

### ENDPOINTS
### Students
Create students: localhost:8080/sms/students/ (POST)
Get Students: localhost:8080/sms/students/ (GET)
Get students by lastname: localhost:8080/sms/students/query, med query "LastName" (GET)
Patch student: localhost:8080/sms/students/{id} (PATCH)
Update student: localhost:8080/sms/students/{id} (PUT)
Get student by ID: localhost:8080/sms/students/{id} (GET)
Delete student: localhost:8080/sms/students/{id} (DELETE)

### Teachers
Create teachers: localhost:8080/sms/teachers/ (POST)
Get Students: localhost:8080/sms/teachers/ (GET)
Get teachers by lastname: localhost:8080/sms/teachers/query, med query "LastName" (GET)
Patch teacher: localhost:8080/sms/teachers/{id} (PATCH)
Update teacher: localhost:8080/sms/teachers/{id} (PUT)
Get teacher by ID: localhost:8080/sms/teachers/{id} (GET)
Delete teacher: localhost:8080/sms/teachers/{id} (DELETE)

### Subjects
Create subject: localhost:8080/sms/subjects/ (POST)
Get all subjects: localhost:8080/sms/subjects/ (GET)
Patch subject: localhost:8080/sms/subjects/{id} (PATCH)
Get subject by ID: localhost:8080/sms/subjects/{id} (GET)
Get all students in subject: localhost:8080/sms/subjects/{id}/students (GET)
Delete subject: localhost:8080/sms/subjects/{id} (DELETE)

### ORDER OF ENDPOINTS
To create a subject, you first need to create a student and a teacher.
1. Create at least one student and one teacher
2. Create subject

____________________________________________________________________________

## Laboration 1

### JSON FORMAT

{\
"email": "test4@test.se",\
"firstName": "123",\
"id": 1,\
"lastName": "Test4"\
"phoneNumber": "1234567891"\
}

### ENDPOINTS 

Create students: localhost:8080/sms/students/ (POST)

Get students: localhost:8080/sms/students (GET)

Get students by lastname: localhost:8080/sms/students/query, med query "LastName" (GET)

Patch student: localhost:8080/sms/students/{id} (PATCH)

Update student: localhost:8080/sms/students/{id} (PUT)

Get student by ID: localhost:8080/sms/students/{id} (GET)

Delete student: localhost:8080/sms/students/{id} (DELETE)

### GROUPMATE

Jag jobbade tillsammans med Oscar Eriksson Stjernfeldt genom Code With Me i IntelliJ.
Svårt att säga vem som har gjort exakt vad. Sammarbetet fungerade bra.

### PROBLEMS

Det var svårt att få rätt exceptions vid rätt fel.