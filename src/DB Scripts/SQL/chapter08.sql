/*    chapter 08     */ -- Manipulating Data

create table emps (
    ID NUMBER(6)    not null
        constraint EMP_ID_PK
            primary key,
    name     VARCHAR2(20),
    SALARY         NUMBER(8, 2)
            check (salary > 0),
    COMMISSION NUMBER(2, 2)
) ;

-- desc emps;

-- Insert Statement
insert into emps (ID, name, SALARY, COMMISSION) VALUES (1 , 'Romani' , 3500 , 0.10);
insert into emps (ID, name, SALARY) VALUES (2 , 'Romani' , 3500);
insert into emps VALUES (3 , 'Mourad' , null , null);

select * from emps;

-- Copying Rows from Another Table
INSERT INTO emps(id, name, salary, commission)
SELECT employee_id, last_name, salary, commission_pct
FROM   employees
WHERE  job_id LIKE '%REP%';


-- insert into (select id , name , SALARY , COMMISSION
--     from emps
--     where SALARY = null)
-- values (3 , 'Mohsen' , 2100 , 0.15);

-- Update Statement
UPDATE emps
SET   name = 'Sarah'
WHERE  id = '2';

select * from emps;

-- Update with subquery
UPDATE   emps
SET      SALARY  = (SELECT  SALARY
                    FROM    emps
                    WHERE   id = 1),
         COMMISSION  = (SELECT  COMMISSION
                    FROM    emps
                    WHERE   id = 1)
WHERE    id    =  3;

UPDATE  emps
SET  SALARY    =  (SELECT SALARY FROM employees
                WHERE COMMISSION_PCT = 0.15 and LAST_NAME = 'Tuvault')
WHERE   COMMISSION   <=  0.15;

-- DML (Select , Insert , Update , delete [with rollback] , merge)
-- DDL (create , alter , drop , truncate [no rollback])
-- DCL (Grant , Revoke)
-- TCL (commit , savepoint , rollback)

-- Delete Statement
delete from emps
where COMMISSION is null;

select * from emps;

delete from emps
where name = (select LAST_NAME from EMPLOYEES
    where LAST_NAME = 'Hall');

-- create table copy_emps
create TABLE copy_emp (id number not null , name varchar2(20) , phone number , birthday date);

insert into copy_emp (id, name, phone, birthday)
select EMPLOYEE_ID , LAST_NAME , SALARY , HIRE_DATE
from EMPLOYEES
where DEPARTMENT_ID = 50;

select * from copy_emp;

-- truncate table with no rollback
truncate table copy_emp;

INSERT INTO
    (SELECT id , name, phone, birthday
     FROM   copy_emp
     WHERE  id in (122, 121))
VALUES (1555, 'Taylor',  5000, sysdate);

-- savepoint statement
savepoint a;

select * from copy_emp;

--delete all rows in table copy_emp
delete  from copy_emp;

-- if you use commit you can not rollback
commit;

--rollback delete in savepoint a
rollback to a;

-------
