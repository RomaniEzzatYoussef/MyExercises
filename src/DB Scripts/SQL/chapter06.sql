/*    chapter 06     */ -- Using Subqueries to Solve Queries

-- Using a Subquery
select LAST_NAME , salary
from employees
where salary > (select salary from employees where last_name = 'Abel');

--Executing Single-Row Subqueries
SELECT last_name, job_id, salary
FROM   employees
WHERE  job_id =
       (SELECT job_id
        FROM   employees
        WHERE  employee_id = 141)
  AND    salary >
         (SELECT salary
          FROM   employees
          WHERE  employee_id = 143);

--Using Group Functions in a Subquery
SELECT last_name, job_id, salary
FROM   employees
WHERE  salary =
       (SELECT MIN(salary)
        FROM   employees);

-- The HAVING Clause with Subqueries
SELECT   department_id, MIN(salary)
FROM     employees
GROUP BY department_id
HAVING   MIN(salary) >
         (SELECT MIN(salary)
          FROM   employees
          WHERE  department_id = 50);

--What Is Wrong with This Statement?
SELECT employee_id, last_name
FROM   employees
WHERE  salary =
       (SELECT   MIN(salary)
        FROM     employees
       /* GROUP BY department_id*/);

--Will This Statement Return Rows?
SELECT last_name, job_id
FROM   employees
WHERE  job_id =
       (SELECT job_id
        FROM   employees
        WHERE  last_name = 'Haas');

--Will This Statement Return Rows?
SELECT last_name, job_id , DEPARTMENT_ID
FROM   employees
WHERE  DEPARTMENT_ID =
       (SELECT DEPARTMENT_ID
        FROM   employees
        WHERE  last_name = 'Ande');

select distinct (LAST_NAME) from EMPLOYEES;

-- using the in operator
SELECT employee_id, last_name, job_id, salary
FROM   employees
WHERE  salary in
       (SELECT salary
        FROM   employees
        WHERE  job_id = 'IT_PROG')
  AND    job_id <> 'IT_PROG';


-- using the any operator
SELECT employee_id, last_name, job_id, salary
FROM   employees
WHERE  salary < ANY -- where salary < any greater value returned
       (SELECT salary
        FROM   employees
        WHERE  job_id = 'IT_PROG')
  AND    job_id <> 'IT_PROG';


-- using the all operator
SELECT employee_id, last_name, job_id, salary
FROM   employees
WHERE  salary < ALL -- where salary < from smallest value
       (SELECT salary
        FROM   employees
        WHERE  job_id = 'IT_PROG')
  AND    job_id <> 'IT_PROG';
