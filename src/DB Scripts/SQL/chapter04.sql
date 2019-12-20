/*    chapter 04     */

select round(avg(salary) , 3) from employees;
select count(employee_id) , count(commission_pct) , count(*) from employees;
select max(employee_id) , max(salary) from employees;
select min(employee_id) , min(salary) from employees;
select stddev(salary) , stddev(employee_id) from employees;
select sum(employee_id) , sum(salary) from employees;
select variance(SALARY) from EMPLOYEES;