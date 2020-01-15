/*    chapter 05     */ -- Displaying Data from Multiple Tables

-- NATURAL JOIN

select LOCATION_ID from LOCATIONS order by LOCATION_ID;
select LOCATION_ID from DEPARTMENTS order by LOCATION_ID;

SELECT department_id, department_name,
       location_id, city
FROM   departments NATURAL JOIN locations ;

select EMPLOYEE_ID, LAST_NAME , DEPARTMENT_ID , DEPARTMENT_NAME
from EMPLOYEES natural join DEPARTMENTS;

select EMPLOYEE_ID, LAST_NAME , DEPARTMENT_ID , DEPARTMENT_NAME
from EMPLOYEES  join DEPARTMENTS using(department_id);

SELECT  department_id, department_name,
        location_id, city
FROM    departments NATURAL JOIN locations
WHERE   department_id IN (20, 50);

SELECT l.city, d.department_name
FROM   locations l JOIN departments d USING (location_id)
WHERE  location_id = 1400;

select l.CITY , d.DEPARTMENT_NAME , LOCATION_ID
from LOCATIONS l join DEPARTMENTS d using (location_id);

SELECT employees.employee_id, employees.last_name,
       departments.location_id, department_id
FROM   employees JOIN departments USING (department_id) ;

select FIRST_NAME , LAST_NAME , DEPARTMENT_ID
from EMPLOYEES
where DEPARTMENT_ID is null ;

select FIRST_NAME , LAST_NAME , DEPARTMENT_ID, MANAGER_ID
from EMPLOYEES
where MANAGER_ID is null ;

SELECT e.employee_id, e.last_name,
       d.location_id, department_id
FROM   employees e JOIN departments d USING (department_id) ;

SELECT e.employee_id, e.last_name, e.department_id,
       d.department_id ,  d.location_id
FROM   employees e JOIN departments d
ON     (e.department_id = d.department_id);

-- Self Join using ON clause
SELECT e.EMPLOYEE_ID , e.last_name emp,e.MANAGER_ID ,  m.EMPLOYEE_ID , m.last_name mgr
FROM   employees e JOIN employees m
ON    (e.manager_id = m.employee_id)
order by MANAGER_ID;

-- Additional conditions
SELECT e.employee_id, e.last_name, e.department_id, e.MANAGER_ID ,
       d.department_id, d.location_id
FROM   employees e JOIN departments d
ON  (e.department_id = d.department_id) AND e.manager_id = 149 ;

-- Additional conditions using where clause
SELECT e.employee_id, e.last_name, e.department_id,
       d.department_id, d.location_id
FROM   employees e JOIN departments d
ON    (e.department_id = d.department_id)
WHERE  e.manager_id = 149;

-- Three-Way Joins with the ON Clause
SELECT employee_id, city, department_name
FROM   employees e JOIN   departments d
ON     (d.department_id = e.department_id)
    JOIN   locations l
ON     (d.location_id = l.location_id);


-- Retrieving Records with Non-Equijoins -- This is also called a Cartesian product between the two tables.
SELECT e.last_name, e.salary, j.JOB_TITLE , j.MIN_SALARY , j.MAX_SALARY
FROM   employees e JOIN JOBS j
ON     e.salary BETWEEN j.MIN_SALARY AND j.MAX_SALARY
order by e.LAST_NAME;

select * from JOBS;

select e.DEPARTMENT_ID , d.DEPARTMENT_NAME , e.EMPLOYEE_ID
from EMPLOYEES e join DEPARTMENTS d
on e.DEPARTMENT_ID = d.DEPARTMENT_ID
order by DEPARTMENT_ID ;

select DEPARTMENT_ID , d.DEPARTMENT_NAME , e.EMPLOYEE_ID
from EMPLOYEES e join DEPARTMENTS d using(DEPARTMENT_ID)
order by DEPARTMENT_ID ;

-- LEFT OUTER JOIN
SELECT e.last_name, e.department_id, d.department_name
FROM   employees e LEFT OUTER JOIN departments d
ON   (e.department_id = d.department_id) ;

--RIGHT OUTER JOIN
SELECT e.last_name, e.department_id, d.department_name
FROM   employees e RIGHT OUTER JOIN departments d
ON    (e.department_id = d.department_id) ;

--FULL OUTER JOIN
SELECT e.last_name, d.department_id, d.department_name
FROM   employees e FULL OUTER JOIN departments d
ON   (e.department_id = d.department_id) ;

--Creating Cross Joins -This is also called a Cartesian product between the two tables.
SELECT last_name, department_name
FROM   employees CROSS JOIN departments ;

select count(DEPARTMENT_NAME) from DEPARTMENTS