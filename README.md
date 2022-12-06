# specialtopics
special topics project

ABBOUD Ali

FAGBURE Oluwayomi

----------------------------------------

Our project consists of an Clinical Appointment with the following functionalities:

for a user (patient): 
· book an appointment
· search for previous appointments they made
for an admin (doctor): 
· update appointment
· delete appointments
· search for appointments
· see all appointments 

The data stored in the database is related to the books:
o name 
o author
o publisher-address, name
o year
o stock
o price

The user and the admin can search for appointments according to their CNP 

RESTful API design:

SEARCH for appointments:

 GET /api/v1/search
 GET /api/v1/admin/search
 
UPDATE appointment:

 PUT /api/v1/appointment/{appointmentID}
 
ADD appointment to database:

POST /api/v1/appointment/book

Delete appointment from database:

DELETE /api/v1/appointment/{appointmentID}

SEE ALL appointments:

GET /api/v1/appointment/all
