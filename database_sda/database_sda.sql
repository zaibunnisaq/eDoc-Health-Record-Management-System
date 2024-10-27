use edoc;
create database edoc;
# only patient can sign up
# DELETE FROM users WHERE id = 4;
# Update users set uname = 'faiza' where id = 8;
#drop table users;
#drop table doctor;
#drop table patient;
#drop table admin;
CREATE TABLE doctor(
  id int AUTO_INCREMENT PRIMARY KEY,
uname varchar(30),
uemail varchar(30),
uusername varchar(30),
upassword varchar(30),
uphone varchar(30),
uusertype varchar(30)
);
CREATE TABLE patient(
    id int AUTO_INCREMENT PRIMARY KEY,
uname varchar(30),
uemail varchar(30),
uusername varchar(30),
upassword varchar(30),
uphone varchar(30),
uusertype varchar(30)
);
CREATE TABLE admin(
id int AUTO_INCREMENT PRIMARY KEY,
uname varchar(30),
uemail varchar(30),
uusername varchar(30),
upassword varchar(30),
uphone varchar(30),
uusertype varchar(30)
);
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'kissa','kissa@gmail.com','kissazahra','kissa123','01234567891',
'Patient');
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'aira','aira@gmail.com','airamash','aira123','01434567891',
'Patient');
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'Zaib','zaib@gmail.com','zaibunnisa','zaib123','01234567891',
'Patient');
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'Amna','amna@gmail.com','amnaali','amna123','85234567891',
'Patient');
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'Ali','Ali@gmail.com','Ali','ali123','01434567891',
'Patient');
insert into patient(uname, uemail, uusername, upassword, uphone, uusertype) values(   #Patient
'Areeba','areeba@gmail.com','areeba','areeba123','85203567891',
'Patient');

# our doctors and staff will be fixed 
insert into doctor(uname, uemail, uusername, upassword, uphone, uusertype) values(   #doctor 
'kalsoom','kalsoom@gmail.com','kalsoomtariq','kalsoom123','01234567851',
'Doctor');
insert into doctor(uname, uemail, uusername, upassword, uphone, uusertype) values(   #doctor 
'Aliza','alzia@gmail.com','alizaibrahim','aliza123','01234564851',
'Doctor');
insert into doctor(uname, uemail, uusername, upassword, uphone, uusertype) values(     #doctor 
'Faiza','faiza@gmail.com','faizarehman','faiza123','01234264851',
'Doctor');

# 1 admin that will maintain DB
insert into admin(uname, uemail, uusername, upassword, uphone, uusertype) values(     #admin
'ted','ted@gmail.com','ted','ted123','01234264351',
'Admin');

#select * from patient;
#select * from doctor;
#select * from admin;

create table appointmentscheduling
(
id int AUTO_INCREMENT PRIMARY KEY,
pid int,
date varchar(30),
did int,
FOREIGN KEY (pid) REFERENCES patient(id),
FOREIGN KEY (did) REFERENCES doctor(id)
);
#insert into appointmentscheduling(pid,date,did) values (1,'12-8-2023',1);
#insert into appointmentscheduling (pid,date,did)values (2,'12-8-2023',1);
#insert into appointmentscheduling(pid,date,did) values (3,'12-8-2023',2);
#insert into appointmentscheduling (pid,date,did)values (3,'12-8-2023',3);
#select * from appointmentscheduling;
create table currentpatient
(
id int AUTO_INCREMENT PRIMARY KEY,
pid int,
FOREIGN KEY (pid) REFERENCES patient(id)
);
create table currentdoctor
(
id int AUTO_INCREMENT PRIMARY KEY,
did int,
FOREIGN KEY (did) REFERENCES doctor(id)
);

#select * from currentdoctor;

#select * from currentpatient;
#select * from patient;
#SELECT pid FROM currentpatient ORDER BY id DESC LIMIT 1;
#SELECT id, uname, uemail FROM doctor;

create table Register (
    id int AUTO_INCREMENT PRIMARY KEY,
    patient_id int,
    registration_date DATE,
    diagnosis varchar(100),
    treatment varchar(100),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);
#select * from Register;
#INSERT INTO Register (patient_id, registration_date, diagnosis, treatment)
#VALUES
 #   (1, '2023-01-01', 'Common cold', 'Prescribed rest and fluids'),
  #  (1, '2023-02-15', 'Allergic reaction', 'Administered antihistamines'),
   # (2, '2023-03-10', 'Sprained ankle', 'Applied ice and recommended rest');
    #INSERT INTO Register (patient_id, registration_date, diagnosis, treatment)
#VALUES
#    (4, '2023-01-01', 'Stomach Ache', 'Prescribed rest and fluids'),
#    (5, '2023-08-23', 'Allergies', 'Administered antihistamines'),
#    (6, '2023-01-02', 'Acidity', 'Prescribed Medicine'),
#    (5, '2023-09-28', 'Back ache', 'Administered Injections'),
#    (3, '2023-03-20', 'Knee pain', 'Applied ice and recommended rest');
 #   SELECT p.id FROM Register r join patient p WHERE p.id = r.patient_id;
 #INSERT INTO Register (patient_id, registration_date, diagnosis, treatment)
#VALUES
  #  (2, '2022-01-01', 'Stomach Ache', 'Prescribed rest and fluids'),
  #  (3, '2022-08-23', 'Allergies', 'Administered antihistamines'),
  #  (5, '2022-01-02', 'Acidity', 'Prescribed Medicine'),
  #  (4, '2022-09-28', 'Back ache', 'Administered Injections'),
   # (3, '2021-03-20', 'Knee pain', 'Applied ice and recommended rest')
    
    create table payment(
      id int AUTO_INCREMENT PRIMARY KEY,
      patient_id int,
      payamt int,
      returnamt int,
	FOREIGN KEY (patient_id) REFERENCES patient(id)
    );
 #   select * from payment;
#	DELETE FROM payment WHERE id = 1 or id = 2;
SELECT registration_date, diagnosis, treatment FROM Register where patient_id = 1;
    
   
    



