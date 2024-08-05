create database RiwiAcademyDB;
use RiwiAcademyDB;


create table student(
id int auto_increment primary key,
name varchar(100) not null,
email varchar(100) not null unique,
statu boolean default true not null,
courseSigned varchar(100) not null
);

create table course(
id int auto_increment primary key,
name varchar(100) unique not null,
studentId int,
foreign key (studentId) references student(id) ON DELETE CASCADE
);

create table inscription(
id int auto_increment primary key,
description text,
courseId int,
foreign key (courseId) references course(id) ON DELETE CASCADE
);

create table score(
id int auto_increment primary key,
description text,
studentId int,
foreign key (studentId) references student(id) ON DELETE CASCADE
);

/*Query*/

select * from course;
select * from student;
select * from inscription;
select * from score;


/* Inner join */

/*join student-course*/
select * from student join course on course.studentId =  student.id;

/*join student-course-inscription*/
select * from student join course on course.studentId =  student.id join inscription on inscription.courseId  = course.id;

/*join student-course-inscription-score*/
select * from student join course on course.studentId =  student.id join inscription on inscription.courseId  = course.id join score on score.studentId = student.id