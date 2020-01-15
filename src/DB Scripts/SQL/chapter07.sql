/*    chapter 07     */  --Using the Set Operators

-- using union operator

SELECT employee_id , job_id
FROM   employees
UNION
SELECT employee_id , job_id
FROM   job_history;

SELECT employee_id , LAST_NAME, job_id
FROM   employees
UNION
SELECT employee_id, to_char(null) , job_id
FROM   job_history;

-- using union all
SELECT employee_id , job_id, department_id
FROM   employees
UNION ALL
SELECT employee_id ,  job_id, department_id
FROM   job_history
ORDER BY  employee_id;

SELECT employee_id, LAST_NAME , job_id, department_id
FROM   employees
UNION ALL
SELECT employee_id, to_char(null) ,  job_id, department_id
FROM   job_history
ORDER BY  employee_id;

-- using intersect operator
SELECT employee_id ,  job_id
FROM   employees
INTERSECT
SELECT employee_id , job_id
FROM   job_history;


SELECT employee_id, job_id, department_id
FROM   employees
INTERSECT
SELECT employee_id, job_id, department_id
FROM   job_history;

--MINUS Operator
SELECT employee_id,job_id
FROM   employees
MINUS
SELECT employee_id,job_id
FROM   job_history;

--MINUS Operator
SELECT employee_id,job_id
FROM   JOB_HISTORY
MINUS
SELECT employee_id,job_id
FROM   EMPLOYEES;

-- Matching the SELECT Statements
SELECT department_id, TO_NUMBER(null) location, hire_date
FROM   employees
UNION
SELECT department_id, location_id,  TO_DATE(null)
FROM   departments;

SELECT employee_id, job_id,salary
FROM   employees
UNION
SELECT employee_id, job_id,0
FROM   job_history;

-- Controlling the Order of Rows
-- COLUMN a_dummy NOPRINT;
SELECT 'sing' AS "My dream", 3 a_dummy
FROM dual
UNION
SELECT 'I''d like to teach', 1 a_dummy
FROM dual
UNION
SELECT 'the world to', 2 a_dummy
FROM dual
UNION all
SELECT 'the world to', 2 a_dummy
FROM dual
ORDER BY a_dummy;
