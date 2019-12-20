                       /* chapter 02 */

select employee_id , last_name , job_id , department_id from employees where department_id = 90;
select last_name , job_id , department_id from employees where last_name = 'Whalen';
select last_name , salary from employees where salary <= 3000;
select last_name , salary from employees where salary between 2500 and 3500;
select first_name , last_name from employees where last_name between 'King' and 'Smith';
select employee_id , last_name , salary , manager_id from employees where manager_id in (100,101,201);
select employee_id , last_name , manager_id , department_id from employees where last_name in ('Hartstein','Vargas');
select first_name from employees where first_name like 'S%';
select first_name from employees where first_name like 'S%r';
select last_name , hire_date from employees where hire_date like '%02';
select last_name from employees where last_name like '_o%';
select employee_id , last_name , job_id from employees where job_id like '%SA\_%' escape '\'; /* escape option;*/
select last_name , manager_id from employees where manager_id is null;
select last_name , job_id , commission_pct from employees where commission_pct is null;
select employee_id , last_name , job_id , salary from employees where salary <= 10000 and job_id like '%MAN%';
select employee_id , last_name , job_id , salary from employees where salary >= 10000 or job_id like '%MAN%';
select last_name , job_id from employees where job_id not in ('IT_PROG','ST_CLERK','SA_REP');

select * from employees where job_id not in ('AC_ACCOUNT','AD_VP');
select * from employees where salary not between 10000 and 15000;
select * from employees where last_name not like '%A%';

select last_name , job_id ,salary from employees where job_id = 'SA_REP' or job_id = 'AD_PRES' and salary > 15000;
select last_name , job_id ,salary from employees where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

select last_name , job_id , department_id , hire_date from employees order by hire_date desc;
select employee_id , last_name , salary*12 annsal from employees order by annsal asc;
select last_name , department_id , salary from employees order by department_id , salary desc;
select last_name , department_id , salary from employees where department_id = 50 order by department_id , salary desc;
select * from employees order by commission_pct;
select * from employees order by commission_pct desc;

select employee_id , last_name , salary , department_id from employees where employee_id = &employee_num;
select last_name , department_id , salary*12 from employees where job_id = '&job_title';
select employee_id , last_name , job_id , &column_name from employees where &condition order by &order_column;

select employee_id , last_name , job_id , &&column_name from employees order by &column_name;


set verify on
define employee_num = 200; 
select employee_id , last_name , salary , department_id from employees where employee_id = &employee_num;
undefine employee_num;

/**
  * PRACTICE 02;
  */
  
select last_name , salary  from employees where salary >= 12000;
select last_name , department_id from employees where employee_id = 176;
select last_name , salary from employees where salary not between 5000 and 12000;
select last_name , job_id , hire_date from employees where last_name in ('Matos','Taylor') order by hire_date desc;
select last_name , department_id from employees where department_id = 20 or department_id = 50 order by last_name asc;
select last_name , department_id from employees where department_id in (20 , 50) order by last_name asc;
select last_name As "Employees" , salary As "Monthly Salary" from employees where salary between 5000 and 12000 AND department_id in (20 , 50);
select last_name , hire_date from employees where hire_date like '%02';
select last_name , job_id from employees where manager_id is null;
select last_name , salary , commission_pct from employees where commission_pct is not null order by salary desc , commission_pct desc;
select last_name , salary from employees where salary > &salaryAmount;
select employee_id , last_name , salary , department_id from employees where manager_id = &managerNumber order by &sortedColumnName;
select employee_id , last_name from employees where last_name like '__a%';
select last_name from employees where last_name like '%a%' and last_name like '%e%'; /* the first condition is run or the second is run in where clause*/
select last_name from employees where last_name like '%a%e%';
select last_name , job_id , salary from employees where job_id in ('SA_REP','ST_CLERK') AND salary not in (2500,3500,7000);
select last_name , job_id , salary from employees where (job_id = 'SA_REP' OR job_id = 'ST_CLERK') AND salary not in (2500,3500,7000);
select last_name AS "Employee" , salary AS "Monthly Salary" , commission_pct from employees where commission_pct = '0.20';



