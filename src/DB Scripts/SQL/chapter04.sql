/*    chapter 04     */ -- Reporting Aggregated Data Using the Group Functions

-- Using the AVG and SUM Functions
SELECT AVG(salary), MAX(salary),
       MIN(salary), SUM(salary)
FROM   employees
WHERE  job_id LIKE '%REP%';

SELECT MIN(hire_date), MAX(hire_date)
FROM	  employees;

SELECT MIN(last_name), MAX(last_name)
FROM   employees;

SELECT COUNT(*)
FROM   employees
WHERE  department_id = 50;

select count (*) from EMPLOYEES;

SELECT COUNT(commission_pct)
FROM   employees
WHERE  department_id = 80;

select count(COMMISSION_PCT) from EMPLOYEES where COMMISSION_PCT is not null;
select count(*) from EMPLOYEES where COMMISSION_PCT is null;

SELECT COUNT(DISTINCT department_id)
FROM   employees;

SELECT AVG(commission_pct)
FROM   employees;

SELECT AVG(NVL(commission_pct, 0))
FROM   employees;

select round(avg(salary) , 3) from employees;
select count(employee_id) , count(commission_pct) , count(*) from employees;
select max(employee_id) , max(salary) from employees;
select min(employee_id) , min(salary) from employees;
select stddev(salary) , stddev(employee_id) from employees;
select sum(employee_id) , sum(salary) from employees;
select variance(SALARY) from EMPLOYEES;

SELECT   department_id, AVG(salary)
FROM     employees
GROUP BY department_id
order by DEPARTMENT_ID;

SELECT   AVG(salary)
FROM     employees
GROUP BY department_id
order by DEPARTMENT_ID;

SELECT   department_id, AVG(salary)
FROM     employees
GROUP BY department_id
ORDER BY AVG(salary);

SELECT   department_id dept_id, job_id, SUM(salary)
FROM     employees
GROUP BY department_id, job_id
ORDER BY DEPARTMENT_ID;

SELECT   department_id dept_id, job_id, COUNT(JOB_ID) ,  SUM(salary)
FROM     employees
group by department_id, job_id
ORDER BY DEPARTMENT_ID asc , job_id asc;

SELECT department_id, COUNT(last_name)
FROM   employees
group by department_id
order by DEPARTMENT_ID;

SELECT   department_id, avg(salary)
FROM     employees
group by department_id
HAVING   AVG(salary) > 8000
order by DEPARTMENT_ID;

SELECT   department_id, MAX(salary)
FROM     employees
GROUP BY department_id
HAVING   MAX(salary)<10000 ;

SELECT   department_id, AVG(salary)
FROM     employees
GROUP BY department_id
HAVING   max(salary)>10000;

SELECT   job_id, SUM(salary) PAYROLL
FROM     employees
WHERE    job_id NOT LIKE '%REP%'
GROUP BY job_id
HAVING   SUM(salary) > 13000
ORDER BY SUM(salary);

SELECT DEPARTMENT_ID , AVG(salary) as s
FROM     employees
GROUP BY department_id
order by  s;

SELECT Max(AVG(salary))
FROM     employees
GROUP BY department_id;

SELECT JOB_ID , AVG(salary) as s
FROM     employees
GROUP BY JOB_ID
order by  s;

SELECT max(AVG(salary))
FROM     employees
group by job_id;

-----

select DEPARTMENT_ID , count(LAST_NAME)
from EMPLOYEES
where LAST_NAME like '%a%'
group by DEPARTMENT_ID
having count(LAST_NAME) > 2
order by DEPARTMENT_ID;