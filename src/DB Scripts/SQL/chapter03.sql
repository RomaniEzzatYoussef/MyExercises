              /* CHAPTER 03 
              
Single Row Functions:-
        * Character
        * Number 
        * Date
        * Conversion
        * General
*/

/* CASE Functions  */
select lower('SQL Course') from dual;
select upper('SQL Course') from dual;
select initcap('SQL Course') from dual;

select 'The job id for ' || upper(last_name) || ' is "' || lower(job_id) ||'".' AS "Employee Details" from employees;
select employee_id , last_name , department_id from employees where last_name = 'higgins';
select employee_id , last_name , department_id from employees where lower(last_name) = 'higgins';
select employee_id , last_name , department_id from employees where initcap(last_name) = 'Higgins';


/* CHARACTER Functions */
select last_name , length(last_name) from employees;
select concat(concat(lower(first_name),initcap(' ')) , initcap(last_name)) from employees;
select last_name , substr(last_name,3 , 5) from employees;
select last_name , instr(lower(last_name) , 'a') from employees;
select lpad(salary , 10 , '*') from employees;
select rpad((lpad((concat(salary , last_name || job_id)) , 30 , '-')) , 40 , '*') from employees;
select last_name , instr(lower(last_name) , 'o') , replace(lower(last_name) , 'o' , 'OO') from employees;
select last_name , trim('a' from lower(last_name)) from employees;

select first_name , upper(&column_name) from employees;

select employee_id , concat(first_name , last_name) NAME , job_id , length(last_name) , instr(last_name , 'a') "contains 'a'?" 
from employees
where substr(job_id , 4) = 'REP';

select employee_id , concat(first_name , last_name) NAME , job_id , length(last_name) , instr(last_name , 'a') "contains 'a'?" 
from employees
where last_name like '%n';

select employee_id , concat(first_name , last_name) NAME , job_id , length(last_name) , instr(last_name , 'a') "contains 'a'?" 
from employees
where substr(last_name , -1 , 1) = 'n';


/* NUMBER Functions  */
select salary*commission_pct*12.59258555 total , round(salary*commission_pct*12.59258555) round ,  round(salary*commission_pct*12.59258555 , 2) round  
from employees 
where commission_pct is not null;

select salary*commission_pct*12.59258555 total , trunc(salary*commission_pct*12.59258555) trunc ,  trunc(salary*commission_pct*12.59258555 , 2) trunc  
from employees 
where commission_pct is not null;

select salary , salary/5 , mod(salary , 5) from employees;

select round(45.923 , 2) , round(45.923 , 0) , round(445.923 , -2) from dual;
select trunc(45.923 , 2) , trunc(45.923) , trunc(45.923 , -1) from dual;
select last_name , salary , mod(salary , 5000) from employees where lower(job_id) = 'sa_rep';



/*          Working With Dates       */

select last_name , hire_date from employees where hire_date < '01-feb-02';
select sysdate from dual;

/* Arithmetic with Dates */
select first_name || last_name "Full Name" , hire_date , hire_date+10 , sysdate-10 , round((sysdate-hire_date)/365.25,2) "Date from hired" , sysdate+10/24 from employees;
select last_name , (sysdate-hire_date)/7 weeks from employees where department_id = 90;


/*           DATE Functions    
     months_between
     add_months
     next_day
     last_day
     round
     trunc
*/
select sysdate , hire_date , months_between(sysdate , hire_date) , months_between(hire_date , sysdate) from employees;
select sysdate , add_months(sysdate , 4) , add_months(sysdate , -4) from dual;
select next_day(sysdate , 'Monday') from dual;
select last_day(sysdate) from dual;
select round(sysdate) from dual;
select round(sysdate , 'Month') from dual;
select round(sysdate , 'Year') from dual;

select trunc(sysdate) from dual;
select trunc(sysdate , 'Month') from dual;
select trunc(sysdate , 'Year') from dual;

select months_between('01-sep-95' , '11-jan-94') , round(months_between('01-sep-95' , '11-jan-94') , 2) , trunc(months_between('01-sep-95' , '11-jan-94') , 2) from dual;
select add_months('11-jan-94' , 6) from dual;
select next_day('01-sep-95' , 'Friday') from dual;
select last_day('01-feb-95') from dual;

select employee_id , hire_date , months_between(sysdate,hire_date) tenure , add_months(hire_date , 6) review , next_day(hire_date , 'Friday') , last_day(hire_date) 
from employees 
where months_between(sysdate , hire_date) > 180;

/* 04-Sep-17 */
select round(sysdate , 'Month') , round(sysdate , 'Year') from dual;
select trunc(sysdate , 'month') , trunc(sysdate , 'year') from dual;

select employee_id , last_name ,  hire_date , round(hire_date , 'Month') , trunc(hire_date , 'month') from employees where hire_date like '%01';

/*     TO_CHAR FUNCTION  with dates   */

select employee_id , last_name ,  to_char(hire_date , 'mm/yy') "Monthly Hired" from employees where last_name = 'Higgins';

select to_char(sysdate , 'DD/MM/YYYY') from dual;
select to_char(sysdate , 'Day Month Year') from dual;
select to_char(sysdate , 'Dy/Mon/Year') from dual;

/* Sample Format Elements of Valid Date Formats*/

select to_char(sysdate , 'scc-a.d.  cc-bc cc A.D.') from dual; /* century*/
select to_char(sysdate , 'syyyy YYYY SYear Year yyy yy y Y,YYY y.yyy IYYY,IYY,IY,I Q') from dual; /* years*/
select to_char(sysdate , 'mm Mon Month month rm RM') from dual; /* months*/
select to_char(sysdate , 'ww w ddd dd d Day DY J') from dual; /*days and weeks*/
select (36*7) / 30 from dual;

/*      Time Date       */

select to_char(sysdate , 'hh12:mi:ss am') from dual; /* hours and minutes and seconds format*/
select to_char(sysdate+10 , 'dd "of" Month YYYY  ddspth') from dual; /* ddspth (sp ===> suffixes spell)*/
select to_char(sysdate , 'hh:mi:ss a.m.') from dual;
select to_char(sysdate , 'cc dd/mm/yyyy  hh24:mi:ss am') from dual;
select to_char(sysdate , 'ww w ddd dd d sssss') from dual;

select last_name , to_char(hire_date , 'fmDD Month YYYY') as hiredate from employees;
select last_name , to_char(hire_date , 'DD Month YYYY') as hiredate from employees;

select last_name , to_char(hire_date , 'fmDDspth "of" Month YYYY fmhh:mi:ss am') as hiredate from employees;


/*  to_char  with numbers */

select salary , to_char(salary , '$999,999.99') from employees;

select salary , to_char(salary , 'L0999999') from employees;
select salary , to_char(salary , '99D99') from employees;

select salary , to_char(salary , '99D99') from employees;
select salary , to_char(salary , '99G999') from employees;

select salary , to_char(salary , '99999MI') from employees;
select salary , to_char(salary , '99999PR') from employees;
select salary , to_char(salary , '99999EEEE') from employees;

select salary , to_char(salary , 'U99999') from employees;
select salary , to_char(salary , '99999V999') from employees;
select salary , to_char(salary , 'S99999') from employees;

select salary , to_char(salary , 'B999999') from employees;

/*     **********     */

select to_char(salary , '$99,999.00') salary from employees where last_name = 'Ernst';

select last_name , hire_date , to_date('May 24, 2003' , 'fxMonth dd, yyyy') from employees;

select to_char(sysdate , 'rrrr yy') from dual;

select last_name , hire_date , to_char(hire_date , 'DD-Mon-YYYY') from employees where hire_date < to_date('01-Jan-03' , 'dd-Mon-RR');

select last_name , hire_date , to_char(hire_date , 'DD-Mon-YYYY') from employees where to_date(hire_date , 'DD-Mon-yy') < '01-Jan-2003';

/*      Nesting Functions         */

select last_name , upper(concat(substr(last_name, 1 , 8) , '_US')) from employees where department_id = 60;
select to_char(next_day(add_months(hire_date , 6) , 'Friday') , 'fmDay, Month ddth, yyyy') "Next 6 Month Review" from employees order by hire_date; 


/*   Null Function 
    NVL
*/
select last_name , commission_pct , nvl(commission_pct , 0) from employees where commission_pct is null;;
select last_name , hire_date , nvl(hire_date , '01-Jan-2017') from employees where hire_date is null;
select last_name , job_id , nvl(job_id , 'No Job Yet') from employees where job_id is null;;

select last_name , salary , nvl(commission_pct , 0) , (salary*12) + (salary*12*nvl(commission_pct , 0)) an_sal from employees;

/*    NVL2     */

select last_name , salary , commission_pct , nvl2(commission_pct , 'SAL+COMM' , 'SAL') income  from employees where department_id in (50,80);
select last_name , salary , commission_pct , nvl2(commission_pct , salary*commission_pct , 0) income  from employees where department_id in (50,80);
select last_name , salary , commission_pct , nvl2(commission_pct , 'SAL+COMM' , 0) income  from employees where department_id in (50,80);

/*   Null IF   doesnot work  */
select first_name , length(first_name) , last_name , length(last_name) expr1 , NULLIF(length(first_name) , length(last_name)) result from employees;

/* Case */
select first_name , length(first_name) , last_name , length(last_name) expr1 , 
case when length(first_name) = length(last_name) then null else length(first_name) end result 
from employees;

/* Coalesce  */

select last_name , coalesce(manager_id , commission_pct , -1) comm ,
case when manager_id = employee_id then -2 else 0 end comm2
from employees 
where manager_id is null and commission_pct is null 
order by commission_pct desc;

/*      using CASE expression     */

select last_name , job_id , salary ,
      case job_id when 'IT_PROG' then 1.10*salary
                  when 'ST_CLERK' then 1.15*salary
                  when 'SA_REP' then 1.20*salary
      else      salary end   "revised_salary"
from employees;


select last_name , salary ,
      case when salary<5000 then 'Low'
           when salary<10000 then 'Medium'
           when salary<20000 then 'Good'
           else 'Excellent'
      end  "qualified_salary"
from employees;      

/*     Using Decode Function      */

select last_name , job_id , salary ,
      decode(job_id , 'IT_PROG' , 1.10*salary ,
                      'ST_CLERK' , 1.15*salary ,
                      'SA_REP' , 1.20*salary , salary) revised_salary
from employees; 

/* IF THEN*/

-- select last_name , job_id , salary ,
--       if job_id = 'IT_PROG' then salary = 1.10*salary
--       if job_id = 'ST_CLERK' then salary = 1.15*salary
--       if job_id = 'SA_REP' then salary = 1.20*salary
--       else salary = salary
-- from employees;

select last_name , salary , trunc(salary/2000,0),
      decode (trunc(salary/2000,0),
                          0, 0.00 ,
                          1, 0.09 ,
                          2, 0.20 ,
                          3, 0.30 ,
                          4, 0.40 ,
                          5, 0.42 ,
                          6, 0.44 ,
                            0.45) tax_rate
from employees
where department_id = 80;

select hire_date , sysdate , round((sysdate-hire_date)/365.25 , 2)  from employees;

/*          Practise 03   */
select sysdate "Date" from dual;
select employee_id , last_name , salary , round(salary+salary*0.155 , 0) "New Salary" from employees;
select employee_id , last_name , salary , round(salary * 1.155) "New Salary different way" from employees;
select employee_id , last_name , salary , round(salary * 1.155) "New Salary" , round(salary*0.155) "Increase1" , round(salary * 1.155) - salary "Increase2"  from employees;
select initcap(last_name) "Name" , length(last_name) "Length" 
from employees 
where last_name like 'J%' 
   OR last_name like 'M%'
   OR last_name like 'A%'
order by last_name;
select initcap(last_name) "Name" , length(last_name) "Length" from employees where last_name like '&start_letter%' order by last_name;
select last_name , round(months_between(sysdate, hire_date)) months_worked from employees order by months_worked;
select last_name||' earns '||to_char(salary , 'fm$99,999.00')||' monthly but wants '||to_char(salary*3 , 'fm$99,999.00')||'.' "Dream Salaries" from employees;
select last_name , lpad(salary,15,'$') salary from employees;
select last_name , rpad(salary,15,'$') salary from employees;
select last_name , hire_date , to_char(next_day(add_months(hire_date,6) , 'Monday') , 'fmDay, "the" Ddspth "of" Month, YYYY') review from employees;
select last_name , hire_date , to_char(hire_date-1 , 'd') , to_char(hire_date , 'Day') day from employees order by to_char(hire_date-1 , 'd');
select last_name , nvl(to_char(commission_pct) , 'No Commission') comm from employees;
SELECT rpad(last_name , 8) ||' '|| rpad(' ',salary/1000+1,'*') EMPLOYEES_AND_THEIR_SALARIES , salary
FROM employees
ORDER BY salary desc;
select job_id , decode(job_id , 'ST_CLERK' , 'E' ,
                                'SA_REP' ,   'D' ,
                                'IT_PROG' ,  'C' ,
                                'ST_MAN' ,   'B' ,
                                'AD_PRES' ,  'A' , 
                                'O') GRADE
from employees;

select job_id , case job_id when 'ST_CLERK' then 'E'
                            when 'SA_REP'   then 'D'
                            when 'IT_PROG'  then 'C'
                            when 'ST_MAN'   then 'B'
                            when 'AD_PRES'  then 'A' 
                            else 'o' end GRADE
from employees;                            