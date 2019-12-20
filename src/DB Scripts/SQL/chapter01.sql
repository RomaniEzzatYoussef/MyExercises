         /* CHAPTER 01 */

select * from employees;/* this is a projection select;*/
select department_name , location_id from departments;
select location_id , department_name from departments;
select last_name , salary , salary+300 from employees;
select last_name , salary , 12*salary+100 from employees;
select last_name , salary , 12*(salary+100) from employees;
select last_name , job_id , salary , commission_pct from employees;
select last_name , 12*salary*commission_pct from employees; /* employees that havenot commission does not evaluated in the statement; */
select last_name name , commission_pct comm from employees;
select last_name "$Name" , salary*12 "Annual Salary" from employees; 
select last_name || job_id as "Employees" from employees;
select last_name || ' is a ' || job_id emp from employees;
select last_name || ': 1 Month salary = ' || salary Monthly from employees;
select department_name || q'<, it's assigned Manager ID: >' || manager_id  from departments;
select distinct department_id from employees;
select distinct job_id from employees;
select distinct department_id , employee_id from employees;
select distinct department_id , job_id from employees;
desc employees;
select employee_id||','||first_name||','||last_name||','||email||','||salary||','||phone_number||','||hire_date||','||job_id||','||salary||','||commission_pct||','||manager_id||','||department_id the_output from employees;


