## CSYE6225 Assignment - Student Management System API

### Overview
* This API provides users management capabilities to retrieve and modify programs information.
* Use HTTP verbs (GET, POST, PUT, DELETE) to operate on the programs, students and courses.
* Github Link:https://github.com/YalinNEU/CSYE6225-StudentManagementSystem

### API URLs
* List of programs:
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs
* Add a new program : 
    * POST http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs
* A single program:
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}
* Update this program:
    * PUT http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}
* Delete this program:
    * DELETE http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}
* All courses in a particular program :
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/courses
* Add a new course to a particular program:
    * POST http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/courses
* A single course belonging to a particular program :
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/courses/{courseId}
* Update this course belonging to a particular program :
    * PUT http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/courses/{courseId}
* Delete this course belonging to a particular program :
    * DELETE http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/courses/{courseId}
* All students in a particular program:
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/students
* Add a new student to a particular program:
    * POST http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/students
* A single student enrolled a particular program:
    * GET http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/students/{studentId}
* Update this student enrolled a particular program:
    * PUT http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/students/{studentId}
* Delete this student enrolled a particular program:
    * DELETE http://cyse6225studentmanagementsystem-env.k3rdmezrew.us-west-2.elasticbeanstalk.com/webapi/programs/{programID}/students/{studentId}